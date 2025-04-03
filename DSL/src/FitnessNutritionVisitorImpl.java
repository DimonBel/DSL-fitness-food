import org.json.JSONArray;
import org.json.JSONObject;

public class FitnessNutritionVisitorImpl extends FitnessNutritionBaseVisitor<Void> {
    private JSONArray busyTime = new JSONArray();
    private JSONArray allergies = new JSONArray();
    private JSONArray exercises = new JSONArray();

    private int userId = 1;
    private double weight = 70.5;
    private double height = 1.75;
    private String goal = "Weight Loss";
    private String diet = "Vegetarian";

    public FitnessNutritionVisitorImpl() {
        // Initialize default busy times
        addBusyTime("09:00", "17:00");
        addBusyTime("19:00", "21:00");

        // Initialize default allergies
        allergies.put("Nuts");
        allergies.put("Gluten");

        // Initialize default exercises
        addExercise("Squat", 60, 3, 5);
        addExercise("Bench Press", 45, 4, 8);
        addExercise("Crunches", -10, 3, 12);
    }

    private void addBusyTime(String start, String end) {
        JSONArray timeSlot = new JSONArray();
        timeSlot.put(start);
        timeSlot.put(end);
        busyTime.put(timeSlot);
    }

    private void addExercise(String name, double weight, int sets, int reps) {
        JSONObject exercise = new JSONObject();
        exercise.put("name", name);
        exercise.put("weight", weight);
        exercise.put("sets", sets);
        exercise.put("reps", reps);
        exercises.put(exercise);
    }

    public JSONObject getJson() {
        JSONObject createUser = new JSONObject();
        createUser.put("id", userId);
        createUser.put("weight", weight);
        createUser.put("height", height);
        createUser.put("goal", goal);
        createUser.put("busyTime", busyTime);
        createUser.put("diet", diet);
        createUser.put("allergies", allergies);
        createUser.put("exercises", exercises);

        JSONObject finalJson = new JSONObject();
        finalJson.put("function", "create_user");
        finalJson.put("create_user", createUser);
        return finalJson;
    }

    @Override
    public Void visitUsingStmt(FitnessNutritionParser.UsingStmtContext ctx) {
        if (ctx.reference() != null && ctx.reference().getText().equals("person.ID")) {
            if (ctx.literal() != null) {
                userId = Integer.parseInt(ctx.literal().getText());
            }
        } else if (ctx.identifier() != null && ctx.literal() != null) {
            // Handle "using identifier = literal" case
            String id = ctx.identifier(0).getText() + "." + ctx.identifier(1).getText();
            if (id.equals("person.ID")) {
                userId = Integer.parseInt(ctx.literal().getText());
            }
        }
        return null;
    }

    @Override
    public Void visitCreateStmt(FitnessNutritionParser.CreateStmtContext ctx) {
        for (FitnessNutritionParser.AttributeContext attrCtx : ctx.attributeList().attribute()) {
            String key = attrCtx.identifier().getText();
            String value = attrCtx.value() != null ? attrCtx.value().getText() : "";

            switch (key) {
                case "Goal":
                    goal = cleanString(value);
                    break;
                case "Diet":
                    diet = cleanString(value);
                    break;
                case "Weight":
                    weight = Double.parseDouble(value);
                    break;
                case "Height":
                    height = Double.parseDouble(value);
                    break;
                case "Allergies":
                    processAllergies(value);
                    break;
                case "BusyTime":
                    processBusyTime(value);
                    break;
            }
        }
        return null;
    }

    private String cleanString(String value) {
        return value.replaceAll("^[\"']|[\"']$", "");
    }

    private void processAllergies(String value) {
        // Clear default allergies if new ones are provided
        allergies = new JSONArray();

        String[] items = value.replaceAll("[{}\"]", "").split(",\\s*");
        for (String item : items) {
            if (!item.trim().isEmpty()) {
                allergies.put(item.trim());
            }
        }
    }

    private void processBusyTime(String value) {
        // Clear default busy times if new ones are provided
        busyTime = new JSONArray();

        // Remove everything except the content between curly braces
        String timesContent = value.replaceAll(".*\\{", "").replaceAll("}.*", "");

        // Split into individual time ranges
        String[] ranges = timesContent.split(",\\s*");

        for (String range : ranges) {
            // Clean each range by removing quotes and whitespace
            range = range.trim().replaceAll("\"", "");
            System.out.println("Raw BusyTime value: " + value);
            // Split into start and end times
            String[] times = range.split("-");
            if (times.length == 2) {
                JSONArray timeSlot = new JSONArray();
                timeSlot.put(times[0].trim());
                timeSlot.put(times[1].trim());
                busyTime.put(timeSlot);
            }
        }
    }

    @Override
    public Void visitExercisesStmt(FitnessNutritionParser.ExercisesStmtContext ctx) {
        // Clear default exercises if new ones are provided
        exercises = new JSONArray();

        for (FitnessNutritionParser.ExerciseEntryContext entry : ctx.exerciseEntry()) {
            JSONObject exercise = new JSONObject();
            exercise.put("name", entry.IDENTIFIER().getText());

            FitnessNutritionParser.ExerciseParamsContext params = entry.exerciseParams();
            if (params != null) {
                for (int i = 0; i < params.getChildCount(); i++) {
                    String paramText = params.getChild(i).getText();
                    if (paramText.equals("Weight") && i + 2 < params.getChildCount()) {
                        exercise.put("weight", Double.parseDouble(params.getChild(i + 2).getText()));
                    } else if (paramText.equals("Sets") && i + 2 < params.getChildCount()) {
                        exercise.put("sets", Integer.parseInt(params.getChild(i + 2).getText()));
                    } else if (paramText.equals("Reps") && i + 2 < params.getChildCount()) {
                        exercise.put("reps", Integer.parseInt(params.getChild(i + 2).getText()));
                    }
                }
            }
            exercises.put(exercise);
        }
        return null;
    }

    // Other methods can remain empty as they're not used
    @Override public Void visitGenerateStmt(FitnessNutritionParser.GenerateStmtContext ctx) { return null; }
    @Override public Void visitOutputStmt(FitnessNutritionParser.OutputStmtContext ctx) { return null; }
    @Override public Void visitForeachStmt(FitnessNutritionParser.ForeachStmtContext ctx) { return null; }
}