import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonTreeTransformer {

    public static void main(String[] args) throws IOException {
        String inputPath = "parseTree.json";
        String outputPath = "output.json";

        String rawJson = new String(Files.readAllBytes(Paths.get(inputPath)));
        JSONObject rawTree = new JSONObject(rawJson);

        JSONObject result = transform(rawTree);

        try (FileWriter writer = new FileWriter(outputPath)) {
            writer.write(result.toString(4));
            System.out.println("output.json saved");
        }
    }

    public static JSONObject transform(JSONObject rawTree) {
        JSONObject result = new JSONObject();
        JSONArray program = rawTree.optJSONArray("program");
        if (program == null) return result;

        JSONObject createObject = null;
        String functionName = "create_user"; // Default to create_user

        // First pass to detect using statement and ID
        for (int i = 0; i < program.length(); i++) {
            JSONObject stmtWrapper = program.getJSONObject(i);

            // Check if this is a direct usingStmt at the top level
            if (stmtWrapper.has("usingStmt")) {
                JSONObject using = handleUsing(stmtWrapper.getJSONArray("usingStmt"));
                String reference = using.optString("reference");
                Object value = using.opt("value");

                // Store ID for later use
                if (reference != null && reference.contains("ID") && value != null) {
                    if (createObject == null) {
                        createObject = new JSONObject();
                    }
                    createObject.put("id", value);
                }
            }

            JSONArray statements = stmtWrapper.optJSONArray("statement");
            if (statements == null) continue;

            for (int j = 0; j < statements.length(); j++) {
                JSONObject stmt = statements.getJSONObject(j);

                if (stmt.has("usingStmt")) {
                    JSONObject using = handleUsing(stmt.getJSONArray("usingStmt"));
                    String reference = using.optString("reference");
                    Object value = using.opt("value");

                    // Store ID for later use
                    if (reference != null && reference.contains("ID") && value != null) {
                        if (createObject == null) {
                            createObject = new JSONObject();
                        }
                        // Use integer if it's an integer value
                        if (value instanceof Double && ((Double)value).intValue() == ((Double)value).doubleValue()) {
                            createObject.put("id", ((Double)value).intValue());
                        } else {
                            createObject.put("id", value);
                        }
                    }
                }

                if (stmt.has("createStmt")) {
                    JSONArray createStmt = stmt.getJSONArray("createStmt");

                    // Extract the entity type to determine function name
                    for (int k = 0; k < createStmt.length(); k++) {
                        JSONObject node = createStmt.getJSONObject(k);
                        if (node.has("identifier")) {
                            JSONArray identifiers = node.getJSONArray("identifier");
                            if (identifiers.length() >= 2) {
                                String entityType = identifiers.getJSONObject(1).getString("text");
                                if (entityType.toLowerCase().contains("user")) {
                                    functionName = "create_user";
                                } else if (entityType.toLowerCase().contains("person")) {
                                    functionName = "create_person";
                                }
                            }
                        }
                    }
                }
            }
        }

        // Initialize create object if not done in using statement
        if (createObject == null) {
            createObject = new JSONObject();
        }

        // Second pass to process all statements
        for (int i = 0; i < program.length(); i++) {
            JSONObject stmtWrapper = program.getJSONObject(i);

            // Handle exercises statement at program level
            if (stmtWrapper.has("exercisesStmt")) {
                JSONArray exercises = handleExercisesStmt(stmtWrapper.getJSONArray("exercisesStmt"));
                createObject.put("exercises", exercises);
                continue;
            }

            JSONArray statements = stmtWrapper.optJSONArray("statement");
            if (statements == null) continue;

            for (int j = 0; j < statements.length(); j++) {
                JSONObject stmt = statements.getJSONObject(j);

                if (stmt.has("createStmt")) {
                    // Merge attributes into existing createObject
                    JSONObject attributes = handleCreate(stmt.getJSONArray("createStmt"));
                    for (String key : attributes.keySet()) {
                        createObject.put(key, attributes.get(key));
                    }
                } else if (stmt.has("generateStmt")) {
                    JSONObject generate = handleGenerate(stmt.getJSONArray("generateStmt"));
                    result.put("function", "generate_training");
                    result.put("generate_training", generate);
                } else if (stmt.has("loopStmt")) {
                    JSONObject loop = handleLoop(stmt.getJSONArray("loopStmt"));
                    result.put("loop", loop);
                } else if (stmt.has("exercisesStmt")) {
                    // Handle Exercises block inside statement
                    JSONArray exercises = handleExercisesStmt(stmt.getJSONArray("exercisesStmt"));
                    createObject.put("exercises", exercises);
                }
            }
        }

        // Add completed create object to result
        if (!createObject.isEmpty()) {
            result.put("function", functionName);
            result.put(functionName, createObject);
        }

        return result;
    }

    private static JSONArray handleExercisesStmt(JSONArray exercisesStmt) {
        JSONArray exercises = new JSONArray();

        for (int i = 0; i < exercisesStmt.length(); i++) {
            JSONObject stmt = exercisesStmt.getJSONObject(i);

            // First, try to find exerciseEntry directly
            if (stmt.has("exerciseEntry")) {
                JSONArray entries = stmt.getJSONArray("exerciseEntry");
                processExerciseEntries(entries, exercises);
            }

            // If not found, search deeper for exerciseEntry
            else {
                // Look for exerciseEntry in child objects
                for (String key : stmt.keySet()) {
                    Object value = stmt.get(key);
                    if (value instanceof JSONArray) {
                        JSONArray array = (JSONArray)value;
                        for (int j = 0; j < array.length(); j++) {
                            if (array.getJSONObject(j).has("exerciseEntry")) {
                                JSONArray entries = array.getJSONObject(j).getJSONArray("exerciseEntry");
                                processExerciseEntries(entries, exercises);
                            }
                        }
                    }
                }
            }
        }

        return exercises;
    }

    private static void processExerciseEntries(JSONArray entries, JSONArray exercises) {
        for (int j = 0; j < entries.length(); j++) {
            JSONObject entry = entries.getJSONObject(j);
            JSONObject exercise = new JSONObject();

            // Get exercise name (might be in different places based on the parser output)
            if (entry.has("IDENTIFIER")) {
                exercise.put("name", entry.getString("IDENTIFIER"));
            } else if (entry.has("identifier")) {
                JSONArray identifiers = entry.getJSONArray("identifier");
                if (identifiers.length() > 0) {
                    exercise.put("name", identifiers.getJSONObject(0).optString("text"));
                }
            } else {
                // Look for text property that might contain the exercise name
                for (String key : entry.keySet()) {
                    if (entry.get(key) instanceof JSONObject &&
                            ((JSONObject)entry.get(key)).has("text")) {
                        exercise.put("name", ((JSONObject)entry.get(key)).getString("text"));
                        break;
                    }
                }
            }

            // Process parameters
            if (entry.has("exerciseParams")) {
                extractExerciseParams(entry.getJSONArray("exerciseParams"), exercise);
            }

            // If we have a valid exercise with at least a name, add it
            if (exercise.has("name") && !exercise.getString("name").isEmpty()) {
                exercises.put(exercise);
            }
        }
    }

    private static void extractExerciseParams(JSONArray params, JSONObject exercise) {
        for (int k = 0; k < params.length(); k++) {
            JSONObject param = params.getJSONObject(k);

            // Try to extract Weight, Sets, Reps
            extractParamValue(param, "Weight", "weight", exercise);
            extractParamValue(param, "Sets", "sets", exercise);
            extractParamValue(param, "Reps", "reps", exercise);
        }
    }

    private static void extractParamValue(JSONObject param, String srcKey, String targetKey, JSONObject exercise) {
        // Direct property
        if (param.has(srcKey)) {
            try {
                String valueStr = param.get(srcKey).toString();
                // Try to parse as number
                exercise.put(targetKey, Double.parseDouble(valueStr));
            } catch (NumberFormatException e) {
                exercise.put(targetKey, param.get(srcKey));
            }
            return;
        }

        // Look for NUMBER property for the value
        if (param.has("NUMBER") && param.has("text") && param.getString("text").equals(srcKey)) {
            try {
                exercise.put(targetKey, Double.parseDouble(param.getString("NUMBER")));
            } catch (NumberFormatException e) {
                exercise.put(targetKey, param.getString("NUMBER"));
            }
            return;
        }

        // Search deeper
        for (String key : param.keySet()) {
            if (param.get(key) instanceof JSONObject) {
                JSONObject child = param.getJSONObject(key);
                if (child.has(srcKey)) {
                    try {
                        exercise.put(targetKey, Double.parseDouble(child.get(srcKey).toString()));
                    } catch (NumberFormatException e) {
                        exercise.put(targetKey, child.get(srcKey));
                    }
                    return;
                }
            } else if (param.get(key) instanceof JSONArray) {
                JSONArray array = param.getJSONArray(key);
                for (int i = 0; i < array.length(); i++) {
                    if (array.getJSONObject(i).has(srcKey)) {
                        try {
                            exercise.put(targetKey, Double.parseDouble(array.getJSONObject(i).get(srcKey).toString()));
                        } catch (NumberFormatException e) {
                            exercise.put(targetKey, array.getJSONObject(i).get(srcKey));
                        }
                        return;
                    }
                }
            }
        }
    }

    private static JSONObject handleCreate(JSONArray createStmt) {
        JSONObject result = new JSONObject();
        for (int i = 0; i < createStmt.length(); i++) {
            JSONObject node = createStmt.getJSONObject(i);

            // For attributes directly from createStmt
            if (node.has("attributeList")) {
                JSONArray attributes = node.getJSONArray("attributeList");
                for (int j = 0; j < attributes.length(); j++) {
                    JSONObject attrWrapper = attributes.getJSONObject(j);
                    if (!attrWrapper.has("attribute")) continue;

                    JSONArray attr = attrWrapper.getJSONArray("attribute");
                    if (attr.length() == 0) continue;

                    // Handle different formats of identifiers
                    String key = "";
                    if (attr.getJSONObject(0).has("identifier")) {
                        key = formatKey(attr.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                    } else if (attr.getJSONObject(0).has("text")) {
                        key = formatKey(attr.getJSONObject(0).getString("text"));
                    }

                    if (key.isEmpty()) continue;

                    if (key.equals("exercises") && containsNestedAttributeList(attr)) {
                        result.put(key, extractExerciseList(attr));
                    } else if (key.equals("allergies") || key.equals("busyTime")) {
                        result.put(key, extractArrayValue(attr));
                    } else if (containsNestedAttributeList(attr)) {
                        result.put(key, extractNestedAttributes(attr));
                    } else if (isArrayValue(attr)) {
                        result.put(key, extractArrayValue(attr));
                    } else {
                        Object value = extractValue(attr);
                        if (value != null) {
                            result.put(key, value);
                        }
                    }
                }
            }

            // Special case handling for direct attributes
            if (node.has("attribute")) {
                JSONArray attr = node.getJSONArray("attribute");
                String key = "";
                if (attr.length() > 0) {
                    if (attr.getJSONObject(0).has("identifier")) {
                        key = formatKey(attr.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                    } else if (attr.getJSONObject(0).has("text")) {
                        key = formatKey(attr.getJSONObject(0).getString("text"));
                    }
                }

                if (!key.isEmpty()) {
                    if (key.equals("weight") || key.equals("height")) {
                        // Try to convert to number
                        Object value = extractValue(attr);
                        if (value instanceof String) {
                            try {
                                double doubleVal = Double.parseDouble((String)value);
                                result.put(key, doubleVal);
                            } catch (NumberFormatException e) {
                                result.put(key, value);
                            }
                        } else {
                            result.put(key, value);
                        }
                    } else {
                        result.put(key, extractValue(attr));
                    }
                }
            }
        }
        return result;
    }

    private static JSONObject handleUsing(JSONArray usingStmt) {
        JSONObject result = new JSONObject();

        // Extract the reference part (person.ID)
        for (int i = 0; i < usingStmt.length(); i++) {
            JSONObject node = usingStmt.getJSONObject(i);

            // Handle reference (e.g., person.ID)
            if (node.has("reference")) {
                result.put("reference", joinIdentifiers(node.getJSONArray("reference")));
            } else if (node.has("identifier")) {
                result.put("reference", node.getJSONArray("identifier").getJSONObject(0).getString("text"));
            }
        }

        // Look for literals or numbers which would be the assigned value
        for (int i = 0; i < usingStmt.length(); i++) {
            JSONObject node = usingStmt.getJSONObject(i);

            // Check for direct literal
            if (node.has("literal")) {
                String valueStr = node.getJSONArray("literal").getJSONObject(0).getString("text");
                try {
                    // Try parsing as number first
                    result.put("value", Double.parseDouble(valueStr));
                } catch (NumberFormatException e) {
                    // Otherwise store as string
                    result.put("value", stripQuotes(valueStr));
                }
                return result; // Found direct literal value
            }

            // Check for NUMBER
            if (node.has("NUMBER")) {
                String valueStr = node.getString("NUMBER");
                try {
                    // Try parsing as int or double
                    double doubleVal = Double.parseDouble(valueStr);
                    if (doubleVal == (int)doubleVal) {
                        result.put("value", (int)doubleVal);
                    } else {
                        result.put("value", doubleVal);
                    }
                } catch (NumberFormatException e) {
                    result.put("value", stripQuotes(valueStr));
                }
                return result; // Found NUMBER value
            }

            // Search deeper in nested objects
            if (node.has("value")) {
                JSONArray valueArray = node.getJSONArray("value");
                for (int j = 0; j < valueArray.length(); j++) {
                    JSONObject valueNode = valueArray.getJSONObject(j);
                    if (valueNode.has("literal")) {
                        String valueStr = valueNode.getJSONArray("literal").getJSONObject(0).getString("text");
                        try {
                            double doubleVal = Double.parseDouble(valueStr);
                            if (doubleVal == (int)doubleVal) {
                                result.put("value", (int)doubleVal);
                            } else {
                                result.put("value", doubleVal);
                            }
                        } catch (NumberFormatException e) {
                            result.put("value", stripQuotes(valueStr));
                        }
                        return result; // Found nested literal value
                    }
                }
            }
        }

        // Last resort: look for "=" and then a number
        for (int i = 0; i < usingStmt.length(); i++) {
            JSONObject node = usingStmt.getJSONObject(i);
            if (node.has("text") && node.getString("text").equals("=")) {
                // The value should be the next item
                if (i + 1 < usingStmt.length()) {
                    JSONObject valueNode = usingStmt.getJSONObject(i + 1);
                    if (valueNode.has("text")) {
                        String valueStr = valueNode.getString("text");
                        try {
                            double doubleVal = Double.parseDouble(valueStr);
                            if (doubleVal == (int)doubleVal) {
                                result.put("value", (int)doubleVal);
                            } else {
                                result.put("value", doubleVal);
                            }
                        } catch (NumberFormatException e) {
                            result.put("value", stripQuotes(valueStr));
                        }
                    }
                }
            }
        }

        return result;
    }

    private static JSONObject handleGenerate(JSONArray generateStmt) {
        JSONObject result = new JSONObject();
        result.put("type", "training");
        JSONObject params = new JSONObject();

        for (int i = 0; i < generateStmt.length(); i++) {
            JSONObject node = generateStmt.getJSONObject(i);
            if (node.has("paramList")) {
                JSONArray paramList = node.getJSONArray("paramList");
                for (int j = 0; j < paramList.length(); j++) {
                    JSONObject paramWrapper = paramList.getJSONObject(j);
                    if (paramWrapper.has("param")) {
                        JSONArray param = paramWrapper.getJSONArray("param");
                        String key = formatKey(param.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                        params.put(key, extractValue(param));
                    }
                }
            }
        }

        result.put("parameters", params);
        return result;
    }

    private static JSONObject handleLoop(JSONArray loopStmt) {
        JSONObject loop = new JSONObject();
        loop.put("type", "while");

        for (int i = 0; i < loopStmt.length(); i++) {
            JSONObject node = loopStmt.getJSONObject(i);
            if (node.has("condition")) {
                loop.put("condition", extractCondition(node.getJSONArray("condition")));
            } else if (node.has("block")) {
                JSONArray block = node.getJSONArray("block");
                JSONArray body = new JSONArray();
                for (int j = 0; j < block.length(); j++) {
                    JSONObject blockStmt = block.getJSONObject(j);
                    if (blockStmt.has("statement")) {
                        JSONArray stmts = blockStmt.getJSONArray("statement");
                        for (int k = 0; k < stmts.length(); k++) {
                            JSONObject inner = stmts.getJSONObject(k);
                            if (inner.has("outputStmt")) {
                                JSONObject out = new JSONObject();
                                out.put("type", "output");
                                out.put("target", extractOutput(inner.getJSONArray("outputStmt")));
                                body.put(out);
                            }
                        }
                    }
                }
                loop.put("body", body);
            }
        }

        return loop;
    }

    private static Object extractOutput(JSONArray outputStmt) {
        for (int i = 0; i < outputStmt.length(); i++) {
            JSONObject node = outputStmt.getJSONObject(i);
            if (node.has("expression")) {
                return joinIdentifiers(node.getJSONArray("expression").getJSONObject(0).getJSONArray("reference"));
            }
        }
        return null;
    }

    private static String extractCondition(JSONArray condition) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < condition.length(); i++) {
            JSONObject node = condition.getJSONObject(i);
            if (node.has("text")) sb.append(node.getString("text")).append(" ");
            else if (node.has("reference")) sb.append(joinIdentifiers(node.getJSONArray("reference"))).append(" ");
        }
        return sb.toString().trim();
    }

    private static Object extractValue(JSONArray attr) {
        for (int i = 0; i < attr.length(); i++) {
            JSONObject node = attr.getJSONObject(i);
            if (node.has("value")) {
                JSONObject valNode = node.getJSONArray("value").getJSONObject(0);
                if (valNode.has("literal")) {
                    String valueText = valNode.getJSONArray("literal").getJSONObject(0).getString("text");
                    // Try to parse as number if possible
                    try {
                        return Double.parseDouble(valueText);
                    } catch (NumberFormatException e) {
                        return stripQuotes(valueText);
                    }
                }
                if (valNode.has("reference")) return joinIdentifiers(valNode.getJSONArray("reference"));
            }
        }
        return null;
    }

    private static boolean containsNestedAttributeList(JSONArray attr) {
        for (int i = 0; i < attr.length(); i++) {
            if (attr.getJSONObject(i).has("attributeList")) return true;
        }
        return false;
    }

    private static JSONObject extractNestedAttributes(JSONArray attr) {
        JSONObject nested = new JSONObject();
        for (int i = 0; i < attr.length(); i++) {
            JSONObject node = attr.getJSONObject(i);
            if (node.has("attributeList")) {
                JSONArray list = node.getJSONArray("attributeList");
                for (int j = 0; j < list.length(); j++) {
                    JSONArray inner = list.getJSONObject(j).getJSONArray("attribute");
                    String key = formatKey(inner.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                    Object value = extractValue(inner);
                    nested.put(key, value);
                }
            }
        }
        return nested;
    }

    private static boolean isArrayValue(JSONArray attr) {
        for (int i = 0; i < attr.length(); i++) {
            if (attr.getJSONObject(i).has("value")) {
                JSONObject valObj = attr.getJSONObject(i).getJSONArray("value").getJSONObject(0);
                if (valObj.has("literal")) {
                    String text = valObj.getJSONArray("literal").getJSONObject(0).getString("text");
                    return text.contains(",") || text.matches(".*\\{.*\\}.*");
                }
            }
        }
        return false;
    }

    private static JSONArray extractArrayValue(JSONArray attr) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < attr.length(); i++) {
            JSONObject node = attr.getJSONObject(i);
            if (node.has("value")) {
                JSONObject valObj = node.getJSONArray("value").getJSONObject(0);
                if (valObj.has("literal")) {
                    String raw = stripQuotes(valObj.getJSONArray("literal").getJSONObject(0).getString("text"));

                    // Handle {"09:00-17:00", "19:00-21:00"} format
                    raw = raw.replaceAll("[{}\"]", "").trim();
                    String[] entries = raw.split(",");

                    for (String entry : entries) {
                        entry = entry.trim();
                        if (entry.contains("-")) {
                            // Handle time ranges like "09:00-17:00"
                            String[] times = entry.split("-");
                            if (times.length == 2) {
                                JSONArray timeRange = new JSONArray();
                                timeRange.put(times[0].trim());
                                timeRange.put(times[1].trim());
                                result.put(timeRange);
                            }
                        } else if (!entry.isEmpty()) {
                            // Regular array item (avoid empty entries)
                            result.put(entry);
                        }
                    }
                } else if (valObj.has("array")) {
                    // Handle array values explicitly
                    JSONArray arrayValues = valObj.getJSONArray("array");
                    for (int j = 0; j < arrayValues.length(); j++) {
                        JSONObject item = arrayValues.getJSONObject(j);
                        if (item.has("value")) {
                            JSONObject itemVal = item.getJSONArray("value").getJSONObject(0);
                            if (itemVal.has("literal")) {
                                String entryText = stripQuotes(itemVal.getJSONArray("literal").getJSONObject(0).getString("text"));
                                result.put(entryText);
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    private static JSONArray extractExerciseList(JSONArray attr) {
        JSONArray result = new JSONArray();
        for (int i = 0; i < attr.length(); i++) {
            JSONObject node = attr.getJSONObject(i);
            if (node.has("attributeList")) {
                JSONArray exercises = node.getJSONArray("attributeList");
                for (int j = 0; j < exercises.length(); j++) {
                    JSONObject wrapper = exercises.getJSONObject(j);
                    JSONArray fields = wrapper.getJSONArray("attribute");
                    JSONObject exercise = new JSONObject();
                    String name = formatKey(fields.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                    exercise.put("name", name);
                    for (int k = 0; k < fields.length(); k++) {
                        if (fields.getJSONObject(k).has("attributeList")) {
                            JSONArray nested = fields.getJSONObject(k).getJSONArray("attributeList");
                            for (int l = 0; l < nested.length(); l++) {
                                JSONArray entry = nested.getJSONObject(l).getJSONArray("attribute");
                                String k2 = formatKey(entry.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                                exercise.put(k2, extractValue(entry));
                            }
                        }
                    }
                    result.put(exercise);
                }
            }
        }
        return result;
    }

    private static String stripQuotes(String s) {
        return s.replaceAll("^\"|\"$", "").replaceAll("^'|'$", "");
    }

    private static String formatKey(String s) {
        return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }

    private static String joinIdentifiers(JSONArray ref) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ref.length(); i++) {
            JSONObject part = ref.getJSONObject(i);
            if (part.has("identifier")) {
                if (sb.length() > 0) sb.append(".");
                sb.append(part.getJSONArray("identifier").getJSONObject(0).getString("text"));
            }
        }
        return sb.toString();
    }
}