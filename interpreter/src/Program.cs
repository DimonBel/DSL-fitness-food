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
            // string inputPath = "..\\input_test.json";
            // string outputPath = "..\\output_test.json";

            string baseDirectory = AppDomain.CurrentDomain.BaseDirectory;
            string projectRoot = Path.GetFullPath(Path.Combine(baseDirectory, "../.."));
            string projectRootInput = Path.GetFullPath(Path.Combine(baseDirectory, "../../.."));

            string inputPath = Path.Combine(projectRootInput, "backend-dsl\\output.json");
            string outputPath = Path.Combine(projectRoot, "output_test.json");

            Console.WriteLine($"Reading from: {inputPath}");
            Console.WriteLine($"Writing to: {outputPath}");


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

            // Preserve the existing TrainingSchedule structure from the database
            modifiedUser.TrainingSchedule = existingUser.TrainingSchedule;

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

            // Add this line to print the meal plan to console
            // MealPlanGenerator.PrintMealPlan(mealPlan);

            string json = JsonSerializer.Serialize(mealPlan, new JsonSerializerOptions
            {
                WriteIndented = true
            });
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

            if (!user.ValidateBusyTimes())
            {
                Console.WriteLine("Error: Invalid busy times provided.");
                return;
            }

            WeeklyTrainingSchedule schedule = TrainingScheduleGenerator.GenerateTrainingSchedule(user);

            // Create output structure
            var output = new
            {
                status = "success",
                user = new
                {
                    id = user.id,
                    name = user.name,
                    goal = user.goal,
                    exerciseExperience = user.exercises.Count
                },
                weeklySchedule = new
                {
                    totalWorkouts = schedule.GetTotalWorkouts(),
                    estimatedWeeklyCalories = schedule.GetEstimatedWeeklyCalories(),
                    workoutDays = schedule.GetWorkoutDays(),
                    schedule = new
                    {
                        Monday = schedule.Monday,
                        Tuesday = schedule.Tuesday,
                        Wednesday = schedule.Wednesday,
                        Thursday = schedule.Thursday,
                        Friday = schedule.Friday,
                        Saturday = schedule.Saturday,
                        Sunday = schedule.Sunday
                    }
                },
                recommendations = GenerateRecommendations(user, schedule)
            };

            string json = JsonSerializer.Serialize(output, new JsonSerializerOptions
            {
                WriteIndented = true,
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            });

            File.WriteAllText(outputPath, json);
            Console.WriteLine($"Weekly training schedule saved to '{outputPath}'.");
            Console.WriteLine($"Generated {schedule.GetTotalWorkouts()} workouts for the week.");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error creating training schedule: {ex.Message}");

            // Write error to output file
            var errorOutput = new
            {
                status = "error",
                message = ex.Message,
                timestamp = DateTime.Now
            };

            string errorJson = JsonSerializer.Serialize(errorOutput, new JsonSerializerOptions { WriteIndented = true });
            File.WriteAllText(outputPath, errorJson);
        }
    }

    private static List<string> GenerateRecommendations(User_Profile user, WeeklyTrainingSchedule schedule)
    {
        var recommendations = new List<string>();

        int totalWorkouts = schedule.GetTotalWorkouts();

        if (totalWorkouts < 3)
        {
            recommendations.Add("Consider adding more workout days for better results");
        }

        if (user.goal.ToLower().Contains("loss") && totalWorkouts < 4)
        {
            recommendations.Add("For weight loss, aim for 4-5 workout days per week");
        }

        if (user.exercises.Count < 3)
        {
            recommendations.Add("Start with basic exercises and gradually increase intensity");
        }

        if (user.busyTime.Count > 2)
        {
            recommendations.Add("Consider morning or evening workouts to fit your busy schedule");
        }

        recommendations.Add("Remember to stay hydrated and maintain proper form during exercises");
        recommendations.Add("Allow rest days between intense workouts for muscle recovery");

        return recommendations;
    }

    static void FindMealsByIngredient(JsonElement root, string outputPath)
    {
        try
        {
            // Check for required properties
            if (!root.TryGetProperty("ingredients", out var ingredientsProp))
            {
                Console.WriteLine("Error: 'ingredients' property missing in input");
                return;
            }

            // Parse ingredients (support both single string and array)
            List<string> ingredients = new();
            if (ingredientsProp.ValueKind == JsonValueKind.Array)
            {
                foreach (var item in ingredientsProp.EnumerateArray())
                {
                    ingredients.Add(item.GetString() ?? string.Empty);
                }
            }
            else
            {
                ingredients.Add(ingredientsProp.GetString() ?? string.Empty);
            }

            // Default to "any" match if not specified
            bool matchAll = false;
            if (root.TryGetProperty("match", out var matchProp))
            {
                matchAll = matchProp.GetString()?.ToLower() == "all";
            }

            // Get optional filters
            string? dietType = null;
            string? mealType = null;

            if (root.TryGetProperty("diet", out var dietProp))
            {
                dietType = dietProp.GetString();
            }

            if (root.TryGetProperty("mealType", out var mealTypeProp))
            {
                mealType = mealTypeProp.GetString();
            }

            // Find matching meals
            var meals = ingredients.Count > 1
                ? MealPlanGenerator.FindMealsByIngredients(ingredients, matchAll)
                : MealPlanGenerator.FindMealsByIngredient(ingredients[0], dietType, mealType);

            // Prepare and save results
            var result = new
            {
                status = "success",
                parameters = new
                {
                    ingredients,
                    match = matchAll ? "all" : "any",
                    diet = dietType,
                    mealType
                },
                meals = meals.Select(m => new
                {
                    name = m.Name,
                    diet = m.MealType.Split('.').FirstOrDefault(),
                    mealType = m.MealType.Split('.').LastOrDefault(),
                    ingredients = m.Ingredients,
                    nutrition = new
                    {
                        calories = m.Calories,
                        carbs = m.Carbs,
                        proteins = m.Proteins,
                        fats = m.Fats
                    }
                }),
                count = meals.Count
            };

            string json = JsonSerializer.Serialize(result, new JsonSerializerOptions { WriteIndented = true });
            File.WriteAllText(outputPath, json);
            Console.WriteLine($"Found {meals.Count} meals matching the criteria");
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

            // First find optimal meal times
            var optimalTimes = TimeSlotFinder.FindOptimalTimes(user);

            // Then find training time considering meal buffers
            var trainingTime = FindOptimalTrainingTime(user, optimalTimes);
            optimalTimes["Training"] = trainingTime;

            var result = new
            {
                status = "success",
                optimalTimes = new
                {
                    breakfast = optimalTimes["Breakfast"].ToString(@"hh\:mm"),
                    lunch = optimalTimes["Lunch"].ToString(@"hh\:mm"),
                    dinner = optimalTimes["Dinner"].ToString(@"hh\:mm"),
                    snack = optimalTimes["Snack"].ToString(@"hh\:mm"),
                    training = optimalTimes["Training"].ToString(@"hh\:mm"),
                    notes = trainingTime == TimeSpan.Zero
                        ? "No suitable training time found with meal buffers"
                        : "Training scheduled with meal time consideration"
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

    private static TimeSpan FindOptimalTrainingTime(User_Profile user, Dictionary<string, TimeSpan> mealTimes)
    {
        // Get all meal times with buffers
        var protectedSlots = new List<(TimeSpan start, TimeSpan end)>();

        foreach (var meal in mealTimes)
        {
            if (meal.Value != TimeSpan.Zero)
            {
                protectedSlots.Add((
                    meal.Value.Subtract(TimeSpan.FromHours(1)),
                    meal.Value.Add(TimeSpan.FromHours(1))
                ));
            }
        }

        // Find available slots that don't overlap with protected meal times
        var availableSlots = TimeSlotFinder.FindAvailableSlots(user)
            .Where(slot => !protectedSlots.Any(mealSlot =>
                TimeIntervalsOverlap(slot, mealSlot)))
            .ToList();

        if (!availableSlots.Any())
        {
            // If no ideal slots, fall back to original time without considering meals
            var fallbackTimes = TimeSlotFinder.FindOptimalTimes(user);
            return fallbackTimes["Training"];
        }

        // Find best time considering workout duration
        var workoutDuration = TimeSlotFinder.GetWorkoutDuration(user);
        var preferredMorning = new TimeSpan(6, 0, 0);
        var preferredEvening = new TimeSpan(17, 0, 0);

        // Try to find a slot that fits the workout duration
        foreach (var slot in availableSlots.OrderBy(s =>
                 Math.Min(
                     Math.Abs((s.start - preferredMorning).Ticks),
                     Math.Abs((s.start - preferredEvening).Ticks)
                 )))
        {
            if (slot.end - slot.start >= workoutDuration)
            {
                return slot.start;
            }
        }

        // If no slot fits full duration, return the largest available slot
        var largestSlot = availableSlots.OrderByDescending(s => s.end - s.start).First();
        return largestSlot.start;
    }

    private static bool TimeIntervalsOverlap((TimeSpan start, TimeSpan end) a, (TimeSpan start, TimeSpan end) b)
    {
        if (a.start > a.end) a = (a.start, a.end + TimeSpan.FromHours(24));
        if (b.start > b.end) b = (b.start, b.end + TimeSpan.FromHours(24));
        return a.start < b.end && b.start < a.end;
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

    public static List<(TimeSpan start, TimeSpan end)> FindAvailableSlots(User_Profile user)
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

    public static TimeSpan GetWorkoutDuration(User_Profile user)
    {
        if (user.exercises.Count == 0) return TimeSpan.FromHours(1);
        double totalMinutes = user.exercises.Sum(e => e.sets * e.reps * 0.5);
        return TimeSpan.FromMinutes(Math.Clamp(totalMinutes, 30, 120));
    }
}