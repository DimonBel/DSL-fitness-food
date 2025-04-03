using System;
using System.Text.Json;
using src;

class Program
{
    static void Main()
    {
        string baseDirectory = AppDomain.CurrentDomain.BaseDirectory;
        string projectRoot = Path.GetFullPath(Path.Combine(baseDirectory, "../../../.."));
        string projectRootInput = Path.GetFullPath(Path.Combine(baseDirectory, "../../../../.."));

        //\DSL\DSL-fitness-food\DSL\output.json
        //\DSL\DSL-fitness-food\interpreter\input_test.json


        string inputPath = Path.Combine(projectRootInput, "DSL\\output.json");
        string outputPath = Path.Combine(projectRoot, "output_test.json");

        Console.WriteLine($"Reading from: {inputPath}");
        Console.WriteLine($"Writing to: {outputPath}");



        string json = File.ReadAllText(inputPath);
        using JsonDocument doc = JsonDocument.Parse(json);
        JsonElement root = doc.RootElement;
        string? function = root.GetProperty("function").GetString();
        switch (function)
        {
            case "create_user": CreateUser(root, outputPath); break;
            case "create_daily_meal_plan": CreateDailyMealPlan(root, outputPath); break;
            case "create_weekly_training_schedule": CreateWeeklyTrainingSchedule(root, outputPath); break;
            default: Console.WriteLine($"Error: Unknown function '{function}'."); break;
        }
    }

    static void CreateUser(JsonElement root, string outputPath)
    {
        User_Profile? user = JsonSerializer.Deserialize<User_Profile>(root.GetProperty("create_user").GetRawText());
        if (user == null)
        { Console.WriteLine("Error: Failed to deserialize user data."); return; }
        Processor.ProcessUser(user);
        JsonHandler.SaveUser(outputPath, user);
        Console.WriteLine($"User saved to '{outputPath}'.");
    }

    static void CreateDailyMealPlan(JsonElement root, string outputPath)
    {
        User_Profile? user = JsonSerializer.Deserialize<User_Profile>(root.GetProperty("create_user").GetRawText());
        if (user == null)
        { Console.WriteLine("Error: Failed to deserialize user data."); return; }
        MealPlan mealPlan = MealPlanGenerator.GenerateMealPlan(user);
        string json = JsonSerializer.Serialize(mealPlan, new JsonSerializerOptions { WriteIndented = true });
        File.WriteAllText(outputPath, json);
        Console.WriteLine($"Daily meal plan saved to '{outputPath}'.");
    }

    static void CreateWeeklyTrainingSchedule(JsonElement root, string outputPath)
    {
        User_Profile? user = JsonSerializer.Deserialize<User_Profile>(root.GetProperty("create_user").GetRawText());
        if (user == null)
        { Console.WriteLine("Error: Failed to deserialize user data."); return; }
        WeeklyTrainingSchedule schedule = TrainingScheduleGenerator.GenerateTrainingSchedule(user);
        string json = JsonSerializer.Serialize(schedule, new JsonSerializerOptions { WriteIndented = true });
        File.WriteAllText(outputPath, json);
        Console.WriteLine($"Weekly training schedule saved to '{outputPath}'.");
    }
}