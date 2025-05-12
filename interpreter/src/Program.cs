using System;
using System.Collections.Generic;
using System.IO;
using System.Text.Json;
using System.Linq;
using System.Text.Json.Serialization;

namespace src;
class Program
{
    private class TempUserWithStringTimes
    {
        public int id { get; set; }
        [JsonPropertyName("name")]
        public string name { get; set; } = string.Empty;
        public float weight { get; set; }
        public float height { get; set; }
        public int age { get; set; }
        public string goal { get; set; } = "Maintenance";
        public List<string[]> busyTime { get; set; } = new();
        public string diet { get; set; } = "Balanced";
        public List<string> allergies { get; set; } = new();
        public List<Exercise> exercises { get; set; } = new();
    }

    static void Main()
    {
        if (!Directory.Exists("database"))
        {
            Directory.CreateDirectory("database");
        }

        if (!File.Exists(Path.Combine("database", "Meals.json")))
        {
            File.WriteAllText(Path.Combine("database", "Meals.json"), "{}");
        }

        if (!File.Exists(Path.Combine("database", "Ingredients.json")))
        {
            File.WriteAllText(Path.Combine("database", "Ingredients.json"), "{}");
        }

        if (!File.Exists(Path.Combine("database", "Users.json")))
        {
            File.WriteAllText(Path.Combine("database", "Users.json"), "{\"users\": []}");
        }

        try
        {
            //          string inputPath = "..\\input_test.json"
            //          string outputPath = "..\\output_test.json";
            string baseDirectory = AppDomain.CurrentDomain.BaseDirectory;
            string projectRoot = Path.GetFullPath(Path.Combine(baseDirectory, "../../../.."));
            string projectRootInput = Path.GetFullPath(Path.Combine(baseDirectory, "../../../../.."));


            string inputPath = Path.Combine(projectRootInput, "backend-dsl\\output.json");
            string outputPath = Path.Combine(projectRoot, "output_test.json");


            if (!File.Exists(inputPath))
            {
                Console.WriteLine($"Error: Input file not found at {inputPath}");
                return;
            }

            string json = File.ReadAllText(inputPath);
            using JsonDocument doc = JsonDocument.Parse(json);
            JsonElement root = doc.RootElement;

            if (!root.TryGetProperty("function", out var functionProp))
            {
                Console.WriteLine("Error: 'function' property missing in input");
                return;
            }

            string? function = functionProp.GetString();
            switch (function)
            {
                case "create_user":
                    CreateUser(root, outputPath);
                    break;
                case "modify_user":
                    ModifyUser(root, outputPath);
                    break;
                case "create_daily_meal_plan":
                    CreateDailyMealPlan(root, outputPath);
                    break;
                case "create_weekly_training_schedule":
                    CreateWeeklyTrainingSchedule(root, outputPath);
                    break;
                default:
                    Console.WriteLine($"Error: Unknown function '{function}'.");
                    break;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }

    static void CreateUser(JsonElement root, string outputPath)
    {
        try
        {
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                Converters = { new TimeSpanTupleConverter() }
            };

            var tempUser = JsonSerializer.Deserialize<TempUserWithStringTimes>(
                root.GetProperty("create_user").GetRawText(), options);
            
            if (tempUser == null)
            {
                Console.WriteLine("Error: Failed to deserialize user data.");
                return;
            }

            var user = ConvertToUserProfile(tempUser);

            if (!user.ValidateBusyTimes())
            {
                return;
            }

            Processor.ProcessUser(user);
            JsonHandler.SaveUser(outputPath, user);
            JsonHandler.AddUserToDatabase(user);
            Console.WriteLine($"User saved to '{outputPath}' and added to database.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error creating user: {ex.Message}");
        }
    }

    static void ModifyUser(JsonElement root, string outputPath)
    {
        try
        {
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                Converters = { new TimeSpanTupleConverter() }
            };

            var tempUser = JsonSerializer.Deserialize<TempUserWithStringTimes>(
                root.GetProperty("modify_user").GetRawText(), options);
            
            if (tempUser == null)
            {
                Console.WriteLine("Error: Failed to deserialize user data.");
                return;
            }

            var modifiedUser = ConvertToUserProfile(tempUser);

            if (!modifiedUser.ValidateBusyTimes())
            {
                return;
            }

            User_Profile? existingUser = JsonHandler.GetUserFromDatabase(modifiedUser.id);
            if (existingUser == null)
            {
                Console.WriteLine($"Error: User with ID {modifiedUser.id} not found.");
                return;
            }

            JsonHandler.UpdateUserInDatabase(modifiedUser);
            Processor.ProcessUser(modifiedUser);
            JsonHandler.SaveUser(outputPath, modifiedUser);
            Console.WriteLine($"User {modifiedUser.id} updated and saved to '{outputPath}'.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error modifying user: {ex.Message}");
        }
    }

    static User_Profile ConvertToUserProfile(TempUserWithStringTimes tempUser)
    {
        var user = new User_Profile
        {
            id = tempUser.id,
            name = tempUser.name,
            weight = tempUser.weight,
            height = tempUser.height,
            age = tempUser.age,
            goal = tempUser.goal,
            diet = tempUser.diet,
            allergies = tempUser.allergies,
            exercises = tempUser.exercises
        };

        foreach (var timePair in tempUser.busyTime)
        {
            if (timePair.Length == 2 && 
                TimeSpan.TryParse(timePair[0], out var start) && 
                TimeSpan.TryParse(timePair[1], out var end))
            {
                user.busyTime.Add((start, end));
            }
        }

        return user;
    }

    static void CreateDailyMealPlan(JsonElement root, string outputPath)
    {
        try
        {
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                Converters = { new TimeSpanTupleConverter() }
            };

            var tempUser = JsonSerializer.Deserialize<TempUserWithStringTimes>(
                root.GetProperty("user").GetRawText(), options);
            
            if (tempUser == null)
            {
                Console.WriteLine("Error: Failed to deserialize user data.");
                return;
            }

            var user = ConvertToUserProfile(tempUser);
            MealPlan mealPlan = MealPlanGenerator.GenerateMealPlan(user);
            string json = JsonSerializer.Serialize(mealPlan, new JsonSerializerOptions { WriteIndented = true });
            File.WriteAllText(outputPath, json);
            Console.WriteLine($"Daily meal plan saved to '{outputPath}'.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error creating meal plan: {ex.Message}");
        }
    }

    static void CreateWeeklyTrainingSchedule(JsonElement root, string outputPath)
    {
        try
        {
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                Converters = { new TimeSpanTupleConverter() }
            };

            var tempUser = JsonSerializer.Deserialize<TempUserWithStringTimes>(
                root.GetProperty("user").GetRawText(), options);
            
            if (tempUser == null)
            {
                Console.WriteLine("Error: Failed to deserialize user data.");
                return;
            }

            var user = ConvertToUserProfile(tempUser);
            WeeklyTrainingSchedule schedule = TrainingScheduleGenerator.GenerateTrainingSchedule(user);
            string json = JsonSerializer.Serialize(schedule, new JsonSerializerOptions { WriteIndented = true });
            File.WriteAllText(outputPath, json);
            Console.WriteLine($"Weekly training schedule saved to '{outputPath}'.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error creating training schedule: {ex.Message}");
        }
    }
}

public class TimeSpanTupleConverter : JsonConverter<List<(TimeSpan start, TimeSpan end)>>
{
    public override List<(TimeSpan start, TimeSpan end)> Read(
        ref Utf8JsonReader reader, 
        Type typeToConvert, 
        JsonSerializerOptions options)
    {
        var result = new List<(TimeSpan, TimeSpan)>();
        using (JsonDocument doc = JsonDocument.ParseValue(ref reader))
        {
            foreach (var array in doc.RootElement.EnumerateArray())
            {
                if (array.GetArrayLength() == 2)
                {
                    var start = TimeSpan.Parse(array[0].GetString());
                    var end = TimeSpan.Parse(array[1].GetString());
                    result.Add((start, end));
                }
            }
        }
        return result;
    }

    public override void Write(
        Utf8JsonWriter writer, 
        List<(TimeSpan start, TimeSpan end)> value, 
        JsonSerializerOptions options)
    {
        writer.WriteStartArray();
        foreach (var (start, end) in value)
        {
            writer.WriteStartArray();
            writer.WriteStringValue(start.ToString(@"hh\:mm"));
            writer.WriteStringValue(end.ToString(@"hh\:mm"));
            writer.WriteEndArray();
        }
        writer.WriteEndArray();
    }
}