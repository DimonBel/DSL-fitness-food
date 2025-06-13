package com.example.dsl_backend.DSL;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonTreeTransformer {

    public static void writeToFile() throws IOException {
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
        boolean hasCreateStatement = false;

        // First pass to detect using statement and ID
        for (int i = 0; i < program.length(); i++) {
            JSONObject stmtWrapper = program.getJSONObject(i);

            // Check if this is a direct usingStmt at the top level
            // Check if this contains a statement with usingStmt
            if (stmtWrapper.has("statement")) {
                JSONArray statements = stmtWrapper.getJSONArray("statement");
                for (int k = 0; k < statements.length(); k++) {
                    JSONObject stmt = statements.getJSONObject(k);
                    if (stmt.has("usingStmt")) {
                        JSONObject using = handleUsing(stmt.getJSONArray("usingStmt"));
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
                }
            }

            JSONArray statements = stmtWrapper.optJSONArray("statement");
            if (statements == null) continue;

            for (int j = 0; j < statements.length(); j++) {
                JSONObject stmt = statements.getJSONObject(j);

                if (stmt.has("createStmt")) {
                    hasCreateStatement = true;
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
                    return result; // Return immediately for generate statements
                } else if (stmt.has("loopStmt")) {
                    JSONObject loop = handleLoop(stmt.getJSONArray("loopStmt"));
                    result.put("loop", loop);

                } else if (stmt.has("exercisesStmt")) {
                    // Handle Exercises block inside statement
                    JSONArray exercises = handleExercisesStmt(stmt.getJSONArray("exercisesStmt"));
                    createObject.put("exercises", exercises);
                } else if (stmt.has("findOptimalTimesStmt")) {
                    JSONObject findOptimal = handleFindOptimalTimes(stmt.getJSONArray("findOptimalTimesStmt"));
                    result.put("function", "find_optimal_times");
                    result.put("user", findOptimal.getJSONObject("user"));
                    return result; // Return immediately for find optimal times statements
                } else if (stmt.has("createWeeklyTrainingScheduleStmt")) {
                    JSONArray createWeeklyTrainingScheduleStmt = stmt.getJSONArray("createWeeklyTrainingScheduleStmt");
                    result = handleCreateWeeklyTrainingSchedule(createWeeklyTrainingScheduleStmt);

                    // Add the user data from createObject
                    if (!createObject.isEmpty()) {
                        // Set default values for missing properties
                        if (!createObject.has("allergies")) createObject.put("allergies", new JSONArray());
                        if (!createObject.has("busyTime")) createObject.put("busyTime", new JSONArray());
                        if (!createObject.has("exercises")) createObject.put("exercises", new JSONArray());
                        if (!createObject.has("name")) createObject.put("name", "");
                        if (!createObject.has("age")) createObject.put("age", 0);

                        result.put("user", createObject);
                    }
                    return result; // Return immediately for weekly training schedule statements

                } else if (stmt.has("createDailyMealPlanStmt")) {
                    JSONObject dailyMealPlan = handleCreateDailyMealPlan(stmt.getJSONArray("createDailyMealPlanStmt"));

                    // Add the user data from createObject
                    if (!createObject.isEmpty()) {
                        // Set default values for missing properties
                        if (!createObject.has("allergies")) createObject.put("allergies", new JSONArray());
                        if (!createObject.has("busyTime")) createObject.put("busyTime", new JSONArray());
                        if (!createObject.has("exercises")) createObject.put("exercises", new JSONArray());
                        if (!createObject.has("name")) createObject.put("name", "");
                        if (!createObject.has("age")) createObject.put("age", 0);

                        result.put("user", createObject);
                    }
                    result.put("function", "create_daily_meal_plan");
                    return result; // Return immediately for daily meal plan statements
                }
            }
        }

        // Only add create object if we actually found a create statement
        if (hasCreateStatement && !createObject.isEmpty()) {
            result.put("function", functionName);
            result.put(functionName, createObject);
        }

        return result;
    }

    private static JSONObject handleFindOptimalTimes(JSONArray findOptimalTimesStmt) {
        JSONObject result = new JSONObject();
        result.put("function", "find_optimal_times");

        // Parse the user specification
        JSONObject userObject = new JSONObject();

        for (int i = 0; i < findOptimalTimesStmt.length(); i++) {
            JSONObject node = findOptimalTimesStmt.getJSONObject(i);

            if (node.has("userSpec")) {
                JSONArray userSpec = node.getJSONArray("userSpec");
                userObject = parseUserSpec(userSpec);
                break;
            }
        }

        result.put("user", userObject);
        return result;
    }

    private static JSONObject handleCreateWeeklyTrainingSchedule(JSONArray createWeeklyTrainingScheduleStmt) {
        JSONObject result = new JSONObject();
        result.put("function", "create_weekly_training_schedule");

  /*      // Parse the user specification
        JSONObject userObject = new JSONObject();

        for (int i = 0; i < createWeeklyTrainingScheduleStmt.length(); i++) {
            JSONObject node = createWeeklyTrainingScheduleStmt.getJSONObject(i);

            if (node.has("userSpec")) {
                JSONArray userSpec = node.getJSONArray("userSpec");
                userObject = parseUserSpec(userSpec);
                break;
            }
        }

        userObject.put("busyTime", new JSONArray());
        userObject.put("allergies", new JSONArray());
        userObject.put("exercises", new JSONArray());
        userObject.put("bmi", 0.0);
        userObject.put("caloriesPerDay", 0.0);
        userObject.put("mealPlan", new JSONObject());
        userObject.put("trainingSchedule", new JSONObject());

        result.put("user", userObject);*/
        return result;
    }

    private static JSONObject handleCreateDailyMealPlan(JSONArray createDailyMealPlanStmt) {
        JSONObject result = new JSONObject();
        result.put("function", "create_daily_meal_plan");

        // Parse the user specification
        JSONObject userObject = new JSONObject();

        for (int i = 0; i < createDailyMealPlanStmt.length(); i++) {
            JSONObject node = createDailyMealPlanStmt.getJSONObject(i);

            if (node.has("userSpec")) {
                JSONArray userSpec = node.getJSONArray("userSpec");
                userObject = parseUserSpec(userSpec);
                break;
            }
        }

        result.put("user", userObject);
        return result;
    }

    private static JSONObject parseUserSpec(JSONArray userSpec) {
        JSONObject user = new JSONObject();

        for (int i = 0; i < userSpec.length(); i++) {
            JSONObject node = userSpec.getJSONObject(i);

            if (node.has("userPropertyList")) {
                JSONArray propertyList = node.getJSONArray("userPropertyList");

                for (int j = 0; j < propertyList.length(); j++) {
                    JSONObject propWrapper = propertyList.getJSONObject(j);

                    if (propWrapper.has("userProperty")) {
                        JSONArray userProperty = propWrapper.getJSONArray("userProperty");
                        parseUserProperty(userProperty, user);
                    }
                }
            }
        }

        return user;
    }

    private static void parseUserProperty(JSONArray userProperty, JSONObject user) {
        String propertyName = "";

        // Find property name
        // Find property name
        for (int i = 0; i < userProperty.length(); i++) {
            JSONObject node = userProperty.getJSONObject(i);
            if (node.has("text")) {
                String text = node.getString("text");
                if (text.equals("id") || text.equals("name") || text.equals("weight") ||
                        text.equals("height") || text.equals("age") || text.equals("goal") ||
                        text.equals("diet") || text.equals("allergies") || text.equals("busyTime") ||
                        text.equals("exercises")) {
                    propertyName = text;
                    break;
                }
            }
        }

        // Parse based on property type
        switch (propertyName) {
            case "id":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        try {
                            int id = Integer.parseInt(text);
                            user.put("id", id);
                            break;
                        } catch (NumberFormatException e) {
                            // Continue looking
                        }
                    }
                }
                break;

            case "busyTime":
                JSONArray busyTimeArray = new JSONArray();
                // Look for timeRangeArray
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("timeRangeArray")) {
                        JSONArray ranges = node.getJSONArray("timeRangeArray");
                        busyTimeArray = parseTimeRanges(ranges);
                        break;
                    }
                }
                user.put("busyTime", busyTimeArray);
                break;

            case "exercises":
                JSONArray exercisesArray = new JSONArray();
                // Look for exerciseArray
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("exerciseArray")) {
                        JSONArray exercises = node.getJSONArray("exerciseArray");
                        exercisesArray = parseExerciseArray(exercises);
                        break;
                    }
                }
                user.put("exercises", exercisesArray);
                break;

            case "name":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        if (text.startsWith("\"") && text.endsWith("\"")) {
                            user.put("name", stripQuotes(text));
                            break;
                        }
                    }
                }
                break;

            case "weight":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        try {
                            double weight = Double.parseDouble(text);
                            user.put("weight", weight);
                            break;
                        } catch (NumberFormatException e) {
                            // Continue looking
                        }
                    }
                }
                break;

            case "height":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        try {
                            double height = Double.parseDouble(text);
                            user.put("height", height);
                            break;
                        } catch (NumberFormatException e) {
                            // Continue looking
                        }
                    }
                }
                break;

            case "age":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        try {
                            int age = Integer.parseInt(text);
                            user.put("age", age);
                            break;
                        } catch (NumberFormatException e) {
                            // Continue looking
                        }
                    }
                }
                break;

            case "goal":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        if (text.startsWith("\"") && text.endsWith("\"")) {
                            user.put("goal", stripQuotes(text));
                            break;
                        }
                    }
                }
                break;

            case "diet":
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("text")) {
                        String text = node.getString("text");
                        if (text.startsWith("\"") && text.endsWith("\"")) {
                            user.put("diet", stripQuotes(text));
                            break;
                        }
                    }
                }
                break;

            case "allergies":
                JSONArray allergiesArray = new JSONArray();
                // Look for stringArray
                for (int i = 0; i < userProperty.length(); i++) {
                    JSONObject node = userProperty.getJSONObject(i);
                    if (node.has("stringArray")) {
                        JSONArray strings = node.getJSONArray("stringArray");
                        allergiesArray = parseStringArray(strings);
                        break;
                    }
                }
                user.put("allergies", allergiesArray);
                break;
        }
    }

    private static JSONArray parseTimeRanges(JSONArray timeRangeArray) {
        JSONArray result = new JSONArray();

        for (int i = 0; i < timeRangeArray.length(); i++) {
            JSONObject rangeWrapper = timeRangeArray.getJSONObject(i);
            if (rangeWrapper.has("timeRangePair")) {
                JSONArray timeRangePair = rangeWrapper.getJSONArray("timeRangePair");
                JSONArray range = new JSONArray();

                // Extract start and end times
                String startTime = "";
                String endTime = "";
                boolean foundFirst = false;

                for (int j = 0; j < timeRangePair.length(); j++) {
                    JSONObject node = timeRangePair.getJSONObject(j);
                    if (node.has("text")) {
                        String text = stripQuotes(node.getString("text"));
                        if (text.matches("\\d{2}:\\d{2}")) {
                            if (!foundFirst) {
                                startTime = text;
                                foundFirst = true;
                            } else {
                                endTime = text;
                                break;
                            }
                        }
                    }
                }

                if (!startTime.isEmpty() && !endTime.isEmpty()) {
                    range.put(startTime);
                    range.put(endTime);
                    result.put(range);
                }
            }
        }

        return result;
    }

    private static JSONArray parseExerciseArray(JSONArray exerciseArray) {
        JSONArray result = new JSONArray();

        for (int i = 0; i < exerciseArray.length(); i++) {
            JSONObject exerciseWrapper = exerciseArray.getJSONObject(i);
            if (exerciseWrapper.has("exerciseObject")) {
                JSONArray exerciseObject = exerciseWrapper.getJSONArray("exerciseObject");
                JSONObject exercise = new JSONObject();

                // Parse exercise properties
                for (int j = 0; j < exerciseObject.length(); j++) {
                    JSONObject node = exerciseObject.getJSONObject(j);
                    if (node.has("exercisePropertyList")) {
                        JSONArray propertyList = node.getJSONArray("exercisePropertyList");

                        for (int k = 0; k < propertyList.length(); k++) {
                            JSONObject propWrapper = propertyList.getJSONObject(k);
                            if (propWrapper.has("exerciseProperty")) {
                                JSONArray exerciseProperty = propWrapper.getJSONArray("exerciseProperty");
                                parseExerciseProperty(exerciseProperty, exercise);
                            }
                        }
                    }
                }

                if (exercise.length() > 0) {
                    result.put(exercise);
                }
            }
        }

        return result;
    }

    private static void parseExerciseProperty(JSONArray exerciseProperty, JSONObject exercise) {
        String propertyName = "";
        String propertyValue = "";

        for (int i = 0; i < exerciseProperty.length(); i++) {
            JSONObject node = exerciseProperty.getJSONObject(i);
            if (node.has("text")) {
                String text = node.getString("text");
                if (text.equals("name") || text.equals("sets") || text.equals("reps")) {
                    propertyName = text;
                } else if (!text.equals(":") && !propertyName.isEmpty()) {
                    propertyValue = text;
                    break;
                }
            }
        }

        if (!propertyName.isEmpty() && !propertyValue.isEmpty()) {
            if (propertyName.equals("name")) {
                exercise.put(propertyName, stripQuotes(propertyValue));
            } else {
                try {
                    exercise.put(propertyName, Integer.parseInt(propertyValue));
                } catch (NumberFormatException e) {
                    exercise.put(propertyName, propertyValue);
                }
            }
        }
    }

    private static JSONArray parseStringArray(JSONArray stringArray) {
        JSONArray result = new JSONArray();

        for (int i = 0; i < stringArray.length(); i++) {
            JSONObject node = stringArray.getJSONObject(i);
            if (node.has("text")) {
                String text = node.getString("text");
                if (text.startsWith("\"") && text.endsWith("\"")) {
                    result.put(stripQuotes(text));
                }
            }
        }

        return result;
    }

    private static JSONArray handleExercisesStmt(JSONArray exercisesStmt) {
        JSONArray exercises = new JSONArray();

        for (int i = 0; i < exercisesStmt.length(); i++) {
            JSONObject node = exercisesStmt.getJSONObject(i);

            if (node.has("exerciseEntry")) {
                JSONArray exerciseEntry = node.getJSONArray("exerciseEntry");
                JSONObject exercise = new JSONObject();
                String exerciseName = "";

                // Parse exercise entry
                for (int j = 0; j < exerciseEntry.length(); j++) {
                    JSONObject entryNode = exerciseEntry.getJSONObject(j);

                    if (entryNode.has("text")) {
                        String text = entryNode.getString("text");
                        // Exercise name is the first non-brace text
                        if (!text.equals("{") && !text.equals("}") && exerciseName.isEmpty()) {
                            exerciseName = text;
                            exercise.put("name", exerciseName);
                        }
                    }

                    if (entryNode.has("exerciseParams")) {
                        JSONArray params = entryNode.getJSONArray("exerciseParams");
                        String currentParam = "";

                        for (int k = 0; k < params.length(); k++) {
                            JSONObject paramNode = params.getJSONObject(k);

                            if (paramNode.has("text")) {
                                String text = paramNode.getString("text");

                                if (text.equals("Weight")) {
                                    currentParam = "weight";
                                } else if (text.equals("Sets")) {
                                    currentParam = "sets";
                                } else if (text.equals("Reps")) {
                                    currentParam = "reps";
                                } else if (text.equals("=")) {
                                    // Skip equals sign
                                } else if (text.equals(",")) {
                                    // Skip comma
                                } else if (!currentParam.isEmpty()) {
                                    // This should be the value
                                    try {
                                        double value = Double.parseDouble(text);
                                        // Convert to int if it's a whole number
                                        if (value == (int)value) {
                                            exercise.put(currentParam, (int)value);
                                        } else {
                                            exercise.put(currentParam, value);
                                        }
                                    } catch (NumberFormatException e) {
                                        exercise.put(currentParam, text);
                                    }
                                    currentParam = ""; // Reset for next parameter
                                }
                            }
                        }
                    }
                }

                if (!exerciseName.isEmpty()) {
                    exercises.put(exercise);
                }
            }
        }

        return exercises;
    }

    private static JSONObject handleCreate(JSONArray createStmt) {
        JSONObject result = new JSONObject();
        String currentAttribute = "";
        boolean expectingValue = false;
        boolean foundOpenParen = false;
        boolean inArrayValue = false;
        JSONArray currentArray = new JSONArray();

        for (int i = 0; i < createStmt.length(); i++) {
            JSONObject node = createStmt.getJSONObject(i);

            // Handle structured attributeList if present
            if (node.has("attributeList")) {
                JSONArray attributes = node.getJSONArray("attributeList");
                for (int j = 0; j < attributes.length(); j++) {
                    JSONObject attrWrapper = attributes.getJSONObject(j);
                    if (!attrWrapper.has("attribute")) continue;

                    JSONArray attr = attrWrapper.getJSONArray("attribute");
                    if (attr.length() == 0) continue;

                    String key = "";
                    if (attr.getJSONObject(0).has("identifier")) {
                        key = formatKey(attr.getJSONObject(0).getJSONArray("identifier").getJSONObject(0).getString("text"));
                    } else if (attr.getJSONObject(0).has("text")) {
                        key = formatKey(attr.getJSONObject(0).getString("text"));
                    }

                    if (key.isEmpty()) continue;

                    if (key.equals("goal") || key.equals("diet")) {
                        Object value = extractValue(attr);
                        if (value != null) {
                            result.put(key, value);
                        }
                    } else if (key.equals("exercises")) {
                        if (containsNestedAttributeList(attr)) {
                            result.put(key, extractExerciseList(attr));
                        } else {
                            Object value = extractValue(attr);
                            if (value != null) {
                                result.put(key, value);
                            }
                        }
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

            // Handle flat structure parsing for your specific parse tree format
            if (node.has("identifier")) {
                JSONArray identifiers = node.getJSONArray("identifier");
                for (int j = 0; j < identifiers.length(); j++) {
                    JSONObject identifier = identifiers.getJSONObject(j);
                    if (identifier.has("text")) {
                        String text = identifier.getString("text");

                        // Check for attribute names
                        if (isAttributeName(text)) {
                            // Finalize previous attribute if we were in array mode
                            if (inArrayValue && !currentAttribute.isEmpty()) {
                                result.put(currentAttribute, currentArray);
                                currentArray = new JSONArray();
                                inArrayValue = false;
                            }

                            currentAttribute = formatKey(text);
                            expectingValue = false;
                            foundOpenParen = false;

                            // Check if this is an array-type attribute
                            if (currentAttribute.equals("allergies") || currentAttribute.equals("busyTime")) {
                                inArrayValue = true;
                                currentArray = new JSONArray();
                            }
                        }
                        // Check for entity type
                        else if (text.equalsIgnoreCase("user")) {
                            result.put("_entityType", "user");
                        } else if (text.equalsIgnoreCase("person")) {
                            result.put("_entityType", "person");
                        }
                    }
                }
            }

            // Handle text nodes
            if (node.has("text")) {
                String text = node.getString("text");

                // Check for opening parenthesis after attribute name
                if (text.equals("(") && !currentAttribute.isEmpty()) {
                    expectingValue = true;
                    foundOpenParen = true;
                }
                // Check for closing parenthesis
                else if (text.equals(")") && foundOpenParen) {
                    // Finalize array attributes
                    if (inArrayValue && !currentAttribute.isEmpty()) {
                        result.put(currentAttribute, currentArray);
                        currentArray = new JSONArray();
                        inArrayValue = false;
                    }
                    expectingValue = false;
                    foundOpenParen = false;
                    currentAttribute = "";
                }
                // Check for opening brace for array/object values
                else if (text.equals("{") && expectingValue && (currentAttribute.equals("allergies") || currentAttribute.equals("busyTime"))) {
                    // Start collecting array items
                    inArrayValue = true;
                }
                // Check for closing brace
                else if (text.equals("}") && inArrayValue) {
                    // Finalize the array
                    if (!currentAttribute.isEmpty()) {
                        result.put(currentAttribute, currentArray);
                        currentArray = new JSONArray();
                        inArrayValue = false;
                    }
                }
                // Handle attribute values
                else if (expectingValue && !currentAttribute.isEmpty() &&
                        !text.equals("(") && !text.equals(")") &&
                        !text.equals("{") && !text.equals("}") &&
                        !text.equals(",")) {

                    if (inArrayValue) {
                        // Handle array values
                        if (currentAttribute.equals("allergies")) {
                            String cleanText = stripQuotes(text).trim();
                            if (!cleanText.isEmpty()) {
                                currentArray.put(cleanText);
                            }
                        } else if (currentAttribute.equals("busyTime")) {
                            String cleanText = stripQuotes(text).trim();
                            if (cleanText.contains("-")) {
                                // Handle time ranges like "09:00-17:00"
                                String[] times = cleanText.split("-");
                                if (times.length == 2) {
                                    JSONArray range = new JSONArray();
                                    range.put(times[0].trim());
                                    range.put(times[1].trim());
                                    currentArray.put(range);
                                }
                            } else if (!cleanText.isEmpty()) {
                                currentArray.put(cleanText);
                            }
                        }
                    } else {
                        // Handle single values
                        Object value = parseAttributeValue(text, currentAttribute);
                        if (value != null) {
                            result.put(currentAttribute, value);
                        }
                    }
                }
                // Check for attribute names in text nodes (fallback)
                else if (isAttributeName(text)) {
                    // Finalize previous attribute if we were in array mode
                    if (inArrayValue && !currentAttribute.isEmpty()) {
                        result.put(currentAttribute, currentArray);
                        currentArray = new JSONArray();
                        inArrayValue = false;
                    }

                    currentAttribute = formatKey(text);
                    expectingValue = false;
                    foundOpenParen = false;

                    // Check if this is an array-type attribute
                    if (currentAttribute.equals("allergies") || currentAttribute.equals("busyTime")) {
                        inArrayValue = true;
                        currentArray = new JSONArray();
                    }
                }
            }
        }

        // Finalize any remaining array attribute
        if (inArrayValue && !currentAttribute.isEmpty()) {
            result.put(currentAttribute, currentArray);
        }

        return result;
    }

    // Helper method to check if a string is an attribute name
    private static boolean isAttributeName(String text) {
        return text.equals("Goal") || text.equals("Diet") || text.equals("Weight") ||
                text.equals("Height") || text.equals("Name") || text.equals("Age") ||
                text.equals("Allergies") || text.equals("BusyTime") || text.equals("Exercises");
    }

    // Enhanced helper method to parse attribute values based on type
    private static Object parseAttributeValue(String text, String attributeName) {
        if (attributeName.equals("goal") || attributeName.equals("diet") || attributeName.equals("name")) {
            return stripQuotes(text);
        } else if (attributeName.equals("weight") || attributeName.equals("height")) {
            try {
                return Double.parseDouble(text);
            } catch (NumberFormatException e) {
                return stripQuotes(text);
            }
        } else if (attributeName.equals("age")) {
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                return stripQuotes(text);
            }
        }
        return stripQuotes(text);
    }

    // Enhanced extractArrayValue method
    private static JSONArray extractArrayValue(JSONArray attr) {
        JSONArray result = new JSONArray();

        for (int i = 0; i < attr.length(); i++) {
            JSONObject node = attr.getJSONObject(i);
            if (node.has("value")) {
                JSONObject valObj = node.getJSONArray("value").getJSONObject(0);
                if (valObj.has("literal")) {
                    String raw = valObj.getJSONArray("literal").getJSONObject(0).getString("text");

                    // Handle different array formats
                    if (raw.startsWith("{") && raw.endsWith("}")) {
                        // Handle {item1, item2, item3} format
                        raw = raw.substring(1, raw.length() - 1).trim();
                        if (!raw.isEmpty()) {
                            String[] entries = raw.split(",");
                            for (String entry : entries) {
                                entry = stripQuotes(entry.trim());
                                if (!entry.isEmpty()) {
                                    if (entry.contains("-")) {
                                        // Handle time ranges like "09:00-17:00"
                                        String[] times = entry.split("-");
                                        if (times.length == 2) {
                                            JSONArray timeRange = new JSONArray();
                                            timeRange.put(times[0].trim());
                                            timeRange.put(times[1].trim());
                                            result.put(timeRange);
                                        }
                                    } else {
                                        result.put(entry);
                                    }
                                }
                            }
                        }
                    } else {
                        // Handle single quoted values
                        String cleanValue = stripQuotes(raw);
                        if (!cleanValue.isEmpty()) {
                            if (cleanValue.contains("-")) {
                                // Handle time ranges
                                String[] times = cleanValue.split("-");
                                if (times.length == 2) {
                                    JSONArray timeRange = new JSONArray();
                                    timeRange.put(times[0].trim());
                                    timeRange.put(times[1].trim());
                                    result.put(timeRange);
                                }
                            } else {
                                result.put(cleanValue);
                            }
                        }
                    }
                } else if (valObj.has("array")) {
                    // Handle explicit array structures
                    JSONArray arrayValues = valObj.getJSONArray("array");
                    for (int j = 0; j < arrayValues.length(); j++) {
                        JSONObject item = arrayValues.getJSONObject(j);
                        if (item.has("value")) {
                            JSONObject itemVal = item.getJSONArray("value").getJSONObject(0);
                            if (itemVal.has("literal")) {
                                String entryText = stripQuotes(itemVal.getJSONArray("literal").getJSONObject(0).getString("text"));
                                if (entryText.contains("-")) {
                                    // Handle time ranges
                                    String[] times = entryText.split("-");
                                    if (times.length == 2) {
                                        JSONArray timeRange = new JSONArray();
                                        timeRange.put(times[0].trim());
                                        timeRange.put(times[1].trim());
                                        result.put(timeRange);
                                    }
                                } else {
                                    result.put(entryText);
                                }
                            }
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
                    return text.startsWith("{") && text.endsWith("}") || text.contains(",");
                } else if (valObj.has("array")) {
                    return true;
                }
            }
        }
        return false;
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