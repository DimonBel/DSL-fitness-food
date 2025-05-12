package com.example.dsl_backend.DSL;
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

        JSONObject createObject = new JSONObject();
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
                    // Ensure ID is stored as integer if possible
                    if (value instanceof Double && ((Double)value).intValue() == ((Double)value).doubleValue()) {
                        createObject.put("id", ((Double)value).intValue());
                    } else if (value instanceof String) {
                        try {
                            Double doubleVal = Double.parseDouble((String)value);
                            if (doubleVal.intValue() == doubleVal.doubleValue()) {
                                createObject.put("id", doubleVal.intValue());
                            } else {
                                createObject.put("id", doubleVal);
                            }
                        } catch (NumberFormatException e) {
                            createObject.put("id", value);
                        }
                    } else {
                        createObject.put("id", value);
                    }
                }
            }

            JSONArray statements = stmtWrapper.optJSONArray("statement");
            if (statements == null) continue;

            for (int j = 0; j < statements.length(); j++) {
                JSONObject stmt = statements.getJSONObject(j);

                if (stmt.has("createStmt")) {
                    JSONArray createStmt = stmt.getJSONArray("createStmt");

                    // Extract the entity type to determine function name
                    for (int k = 0; k < createStmt.length(); k++) {
                        JSONObject node = createStmt.getJSONObject(k);
                        if (node.has("identifier")) {
                            JSONArray identifiers = node.getJSONArray("identifier");
                            JSONObject identifier = identifiers.getJSONObject(0);
                            if (identifier.has("text")) {
                                String entityType = identifier.getString("text").toLowerCase();
                                if (entityType.equals("user")) {
                                    functionName = "create_user";
                                    break;
                                } else if (entityType.equals("person")) {
                                    functionName = "create_person";
                                    break;
                                }
                            }
                        }
                    }
                }
            }
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
                        // Skip internal processing keys
                        if (key.equals("_entityType")) {
                            if (attributes.getString(key).equals("user")) {
                                functionName = "create_user";
                            } else if (attributes.getString(key).equals("person")) {
                                functionName = "create_person";
                            }
                            continue;
                        }
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
        JSONObject currentExercise = null;

        for (int i = 0; i < exercisesStmt.length(); i++) {
            JSONObject stmt = exercisesStmt.getJSONObject(i);

            if (stmt.has("exerciseEntry")) {
                JSONArray entries = stmt.getJSONArray("exerciseEntry");

                for (int j = 0; j < entries.length(); j++) {
                    JSONObject entry = entries.getJSONObject(j);

                    // Create a new exercise when we find a name
                    if (entry.has("text") && !entry.getString("text").equals("{") &&
                            !entry.getString("text").equals("}")) {
                        currentExercise = new JSONObject();
                        currentExercise.put("name", entry.getString("text"));
                        exercises.put(currentExercise);
                    }

                    // Add parameters to the current exercise
                    if (entry.has("exerciseParams") && currentExercise != null) {
                        JSONArray params = entry.getJSONArray("exerciseParams");

                        for (int k = 0; k < params.length(); k++) {
                            JSONObject param = params.getJSONObject(k);
                            if (param.has("text")) {
                                String text = param.getString("text");

                                if (text.equals("Weight")) {
                                    // Look ahead for the value after the parenthesis
                                    if (k + 2 < params.length() && params.getJSONObject(k+2).has("text")) {
                                        String valueText = params.getJSONObject(k+2).getString("text");
                                        try {
                                            double value = Double.parseDouble(valueText);
                                            currentExercise.put("weight", value);
                                        } catch (NumberFormatException e) {
                                            currentExercise.put("weight", valueText);
                                        }
                                    }
                                } else if (text.equals("Sets")) {
                                    // Look ahead for the value after the parenthesis
                                    if (k + 2 < params.length() && params.getJSONObject(k+2).has("text")) {
                                        String valueText = params.getJSONObject(k+2).getString("text");
                                        try {
                                            double value = Double.parseDouble(valueText);
                                            currentExercise.put("sets", value);
                                        } catch (NumberFormatException e) {
                                            currentExercise.put("sets", valueText);
                                        }
                                    }
                                } else if (text.equals("Reps")) {
                                    // Look ahead for the value after the parenthesis
                                    if (k + 2 < params.length() && params.getJSONObject(k+2).has("text")) {
                                        String valueText = params.getJSONObject(k+2).getString("text");
                                        try {
                                            double value = Double.parseDouble(valueText);
                                            currentExercise.put("reps", value);
                                        } catch (NumberFormatException e) {
                                            currentExercise.put("reps", valueText);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return exercises;
    }

    private static JSONObject handleCreate(JSONArray createStmt) {
        JSONObject result = new JSONObject();

        // Track if we're currently parsing an attribute outside the attributeList
        boolean inDirectAttribute = false;
        String currentAttribute = "";

        // First pass: collect attributeList items
        for (int i = 0; i < createStmt.length(); i++) {
            JSONObject node = createStmt.getJSONObject(i);

            // Process attributes in attributeList
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

            // Process direct attributes (Weight, Height, etc.)
            if (node.has("text")) {
                String text = node.getString("text");

                // Start of a direct attribute
                if (text.equals("Weight") || text.equals("Height") ||
                        text.equals("Allergies") || text.equals("BusyTime")) {
                    inDirectAttribute = true;
                    currentAttribute = formatKey(text);

                    // Extract the value for this attribute
                    if (i + 2 < createStmt.length() && createStmt.getJSONObject(i+1).has("text") &&
                            createStmt.getJSONObject(i+1).getString("text").equals("(")) {

                        // Simple numeric value (Weight, Height)
                        if (text.equals("Weight") || text.equals("Height")) {
                            if (i + 3 < createStmt.length() && createStmt.getJSONObject(i+2).has("text")) {
                                String valueStr = createStmt.getJSONObject(i+2).getString("text");
                                try {
                                    result.put(currentAttribute, Double.parseDouble(valueStr));
                                } catch (NumberFormatException e) {
                                    result.put(currentAttribute, valueStr);
                                }
                            }
                        }
                        // Array values (Allergies, BusyTime)
                        else if (text.equals("Allergies") || text.equals("BusyTime")) {
                            JSONArray arrayValues = new JSONArray();

                            // Extract array elements
                            if (text.equals("Allergies")) {
                                // Find all string values between { and }
                                for (int j = i + 3; j < createStmt.length(); j++) {
                                    JSONObject arrayNode = createStmt.getJSONObject(j);
                                    if (arrayNode.has("text")) {
                                        String arrayText = arrayNode.getString("text");
                                        if (arrayText.equals("}")) break;
                                        if (arrayText.startsWith("\"") && arrayText.endsWith("\"")) {
                                            arrayValues.put(stripQuotes(arrayText));
                                        }
                                    }
                                }
                                result.put(currentAttribute, arrayValues);
                            }
                            else if (text.equals("BusyTime")) {
                                // Process time ranges
                                for (int j = i + 3; j < createStmt.length(); j++) {
                                    JSONObject arrayNode = createStmt.getJSONObject(j);
                                    if (arrayNode.has("text")) {
                                        String arrayText = arrayNode.getString("text");
                                        if (arrayText.equals("}")) break;
                                        if (arrayText.startsWith("\"") && arrayText.endsWith("\"")) {
                                            String timeRange = stripQuotes(arrayText);
                                            if (timeRange.contains("-")) {
                                                String[] times = timeRange.split("-");
                                                if (times.length == 2) {
                                                    JSONArray range = new JSONArray();
                                                    range.put(times[0].trim());
                                                    range.put(times[1].trim());
                                                    arrayValues.put(range);
                                                }
                                            }
                                        }
                                    }
                                }
                                result.put(currentAttribute, arrayValues);
                            }
                        }
                    }
                    inDirectAttribute = false;
                }
            }
        }

        // Second pass: Look for identifier that might determine entity type
        for (int i = 0; i < createStmt.length(); i++) {
            JSONObject node = createStmt.getJSONObject(i);

            if (node.has("identifier")) {
                JSONArray identifiers = node.getJSONArray("identifier");
                for (int j = 0; j < identifiers.length(); j++) {
                    JSONObject identifier = identifiers.getJSONObject(j);
                    if (identifier.has("text")) {
                        String text = identifier.getString("text");
                        if (text.equalsIgnoreCase("user")) {
                            result.put("_entityType", "user");
                        } else if (text.equalsIgnoreCase("person")) {
                            result.put("_entityType", "person");
                        } else if (text.equalsIgnoreCase("profile")) {
                            result.put("_entityType", "profile");
                        }
                    }
                }
            }
        }

        return result;
    }

    private static JSONObject handleUsing(JSONArray usingStmt) {
        JSONObject result = new JSONObject();
        String referenceValue = "";

        // Extract the reference part (person.ID)
        for (int i = 0; i < usingStmt.length(); i++) {
            JSONObject node = usingStmt.getJSONObject(i);

            // Build reference string from text elements
            if (node.has("text")) {
                String text = node.getString("text");
                if (!text.equals("using") && !text.equals("=")) {
                    if (text.equals(".")) {
                        referenceValue += text;
                    } else {
                        referenceValue += text + " ";
                    }
                }
            }

            // Handle identifier nodes
            if (node.has("identifier")) {
                JSONArray identArray = node.getJSONArray("identifier");
                for (int j = 0; j < identArray.length(); j++) {
                    JSONObject identObj = identArray.getJSONObject(j);
                    if (identObj.has("text")) {
                        referenceValue += identObj.getString("text") + " ";
                    }
                }
            }

            // Capture literal values
            if (node.has("literal")) {
                JSONArray literalArray = node.getJSONArray("literal");
                for (int j = 0; j < literalArray.length(); j++) {
                    JSONObject litObj = literalArray.getJSONObject(j);
                    if (litObj.has("text")) {
                        String valueStr = litObj.getString("text");
                        try {
                            // Try parsing as number
                            double doubleVal = Double.parseDouble(valueStr);
                            if (doubleVal == (int)doubleVal) {
                                result.put("value", (int)doubleVal);
                            } else {
                                result.put("value", doubleVal);
                            }
                        } catch (NumberFormatException e) {
                            // Otherwise store as string
                            result.put("value", stripQuotes(valueStr));
                        }
                    }
                }
            }
        }

        // Clean up and set the reference
        referenceValue = referenceValue.trim();
        if (referenceValue.contains("person . ID")) {
            result.put("reference", "person.ID");
        } else if (referenceValue.contains("ID")) {
            result.put("reference", "ID");
        } else {
            result.put("reference", referenceValue);
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