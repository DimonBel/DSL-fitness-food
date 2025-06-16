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
            string inputPath = "..\\input_test.json";
            string outputPath = "..\\output_test.json";
            
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
                case "find_meals_by_ingredient":
                    FindMealsByIngredient(root, outputPath);
                    break;
                case "find_optimal_times":
                    FindOptimalTimes(root, outputPath);
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

    static void FindMealsByIngredient(JsonElement root, string outputPath)
    {
        try
        {
            if (!root.TryGetProperty("ingredient", out var ingredientProp))
            {
                Console.WriteLine("Error: 'ingredient' property missing in input");
                return;
            }

            string ingredient = ingredientProp.GetString() ?? string.Empty;
            var meals = MealPlanGenerator.FindMealsByIngredient(ingredient);

            var result = new
            {
                status = "success",
                meals = meals.Select(m => new
                {
                    name = m.Name,
                    ingredients = m.Ingredients,
                    calories = m.Calories,
                    carbs = m.Carbs,
                    proteins = m.Proteins,
                    fats = m.Fats,
                    mealType = m.MealType
                }),
                count = meals.Count
            };

            string json = JsonSerializer.Serialize(result, new JsonSerializerOptions { WriteIndented = true });
            File.WriteAllText(outputPath, json);
            Console.WriteLine($"Found {meals.Count} meals with ingredient '{ingredient}'");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error finding meals by ingredient: {ex.Message}");
        }
    }

    static void FindOptimalTimes(JsonElement root, string outputPath)
    {
        try
        {
            if (!root.TryGetProperty("user", out var userProp))
            {
                Console.WriteLine("Error: 'user' property missing in input");
                return;
            }

            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                Converters = { new TimeSpanTupleConverter() }
            };

            var tempUser = JsonSerializer.Deserialize<TempUserWithStringTimes>(userProp.GetRawText(), options);
            if (tempUser == null)
            {
                Console.WriteLine("Error: Failed to deserialize user data");
                return;
            }

            var user = ConvertToUserProfile(tempUser);
            var optimalTimes = TimeSlotFinder.FindOptimalTimes(user);

            var result = new
            {
                status = "success",
                optimalTimes = new
                {
                    breakfast = optimalTimes["Breakfast"].ToString(@"hh\:mm"),
                    lunch = optimalTimes["Lunch"].ToString(@"hh\:mm"),
                    dinner = optimalTimes["Dinner"].ToString(@"hh\:mm"),
                    snack = optimalTimes["Snack"].ToString(@"hh\:mm"),
                    training = optimalTimes["Training"].ToString(@"hh\:mm")
                }
            };

            string json = JsonSerializer.Serialize(result, new JsonSerializerOptions { WriteIndented = true });
            File.WriteAllText(outputPath, json);
            Console.WriteLine("Optimal times calculated successfully");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error finding optimal times: {ex.Message}");
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

public static class TimeSlotFinder
{
    public static Dictionary<string, TimeSpan> FindOptimalTimes(User_Profile user)
    {
        var optimalTimes = new Dictionary<string, TimeSpan>();
        var availableSlots = FindAvailableSlots(user);

        optimalTimes["Breakfast"] = FindBestTime(availableSlots, new TimeSpan(7, 0, 0), new TimeSpan(9, 0, 0));
        optimalTimes["Lunch"] = FindBestTime(availableSlots, new TimeSpan(12, 0, 0), new TimeSpan(14, 0, 0));
        optimalTimes["Dinner"] = FindBestTime(availableSlots, new TimeSpan(18, 0, 0), new TimeSpan(20, 0, 0));
        optimalTimes["Snack"] = FindBestTime(availableSlots, new TimeSpan(15, 0, 0), new TimeSpan(17, 0, 0));
        optimalTimes["Training"] = FindBestTrainingTime(user, availableSlots);

        return optimalTimes;
    }

    private static List<(TimeSpan start, TimeSpan end)> FindAvailableSlots(User_Profile user)
    {
        var available = new List<(TimeSpan, TimeSpan)>();
        var busy = user.busyTime.OrderBy(t => t.start).ToList();

        TimeSpan lastEnd = TimeSpan.Zero;
        foreach (var interval in busy)
        {
            if (interval.start > lastEnd)
            {
                available.Add((lastEnd, interval.start));
            }
            lastEnd = interval.end > lastEnd ? interval.end : lastEnd;
        }

        if (lastEnd < TimeSpan.FromHours(23))
        {
            available.Add((lastEnd, TimeSpan.FromHours(23)));
        }

        return available;
    }

    private static TimeSpan FindBestTime(List<(TimeSpan start, TimeSpan end)> slots, 
                                       TimeSpan preferredStart, TimeSpan preferredEnd)
    {
        foreach (var slot in slots)
        {
            if (slot.start <= preferredStart && slot.end >= preferredEnd)
                return preferredStart;
            
            if (slot.start <= preferredStart && slot.end > preferredStart)
                return preferredStart;
            
            if (slot.start >= preferredStart && slot.end <= preferredEnd)
                return slot.start;
        }

        return slots.FirstOrDefault().start;
    }

    private static TimeSpan FindBestTrainingTime(User_Profile user, List<(TimeSpan start, TimeSpan end)> slots)
    {
        var workoutDuration = GetWorkoutDuration(user);
        var morning = FindBestTime(slots, new TimeSpan(6, 0, 0), new TimeSpan(9, 0, 0));
        var evening = FindBestTime(slots, new TimeSpan(17, 0, 0), new TimeSpan(20, 0, 0));

        var morningSlot = slots.FirstOrDefault(s => s.start <= morning && s.end >= morning.Add(workoutDuration));
        var eveningSlot = slots.FirstOrDefault(s => s.start <= evening && s.end >= evening.Add(workoutDuration));

        return (morningSlot.end - morningSlot.start) >= (eveningSlot.end - eveningSlot.start) 
            ? morning : evening;
    }

    private static TimeSpan GetWorkoutDuration(User_Profile user)
    {
        if (user.exercises.Count == 0) return TimeSpan.FromHours(1);
        double totalMinutes = user.exercises.Sum(e => e.sets * e.reps * 0.5);
        return TimeSpan.FromMinutes(Math.Clamp(totalMinutes, 30, 120));
    }
}