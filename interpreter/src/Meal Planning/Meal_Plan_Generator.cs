using System.Text.Json;
using System.Text.Json.Serialization;

namespace src;

public static class MealPlanGenerator
{
    private static Dictionary<string, Dictionary<string, Dictionary<string, Dictionary<string, Meal>>>>? _mealsData;

    public static MealPlan GenerateMealPlan(User_Profile user)
    {
        LoadMealsData();
        var mealPlan = new MealPlan();

        if (_mealsData == null)
        {
            Console.WriteLine("Error: Failed to load meals data");
            return mealPlan;
        }

        // Find matching diet (case-insensitive)
        if (!_mealsData.TryGetValue("DietTypes", out var dietTypes))
        {
            Console.WriteLine("Error: 'DietTypes' not found in meals data");
            return mealPlan;
        }

        var dietKey = dietTypes.Keys.FirstOrDefault(k => 
            k.Equals(user.diet, StringComparison.OrdinalIgnoreCase));
        
        if (string.IsNullOrEmpty(dietKey))
        {
            Console.WriteLine($"Error: No meals found for diet '{user.diet}'");
            return mealPlan;
        }

        // Get all meals for the diet, filtered by allergies
        var dietMeals = dietTypes[dietKey];
        
        // Filter meals by allergies and assign to meal plan
        mealPlan.Breakfast = FilterMeals(dietMeals["Breakfast"], user.allergies);
        mealPlan.Lunch = FilterMeals(dietMeals["Lunch"], user.allergies);
        mealPlan.Dinner = FilterMeals(dietMeals["Dinner"], user.allergies);
        mealPlan.Snacks = FilterMeals(dietMeals["Snacks"], user.allergies);

        if (mealPlan.Breakfast.Count == 0 && 
            mealPlan.Lunch.Count == 0 && 
            mealPlan.Dinner.Count == 0 && 
            mealPlan.Snacks.Count == 0)
        {
            Console.WriteLine("Warning: No meals available after filtering for allergies");
        }

        return mealPlan;
    }

    private static List<Meal> FilterMeals(Dictionary<string, Meal> meals, List<string> allergies)
    {
        return meals.Values
            .Where(meal => !allergies.Any(allergy => 
                meal.Ingredients.Any(ingredient => 
                    ingredient.Contains(allergy, StringComparison.OrdinalIgnoreCase))))
            .ToList();
    }

    private static void LoadMealsData()
    {
        try
        {
            string path = Path.Combine("database", "Meals.json");
            if (!File.Exists(path))
            {
                Console.WriteLine($"Error: Meals.json not found at {path}");
                return;
            }

            string json = File.ReadAllText(path);
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                AllowTrailingCommas = true
            };
            _mealsData = JsonSerializer.Deserialize<
                Dictionary<string, Dictionary<string, Dictionary<string, Dictionary<string, Meal>>>>>(json, options);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error loading meals data: {ex.Message}");
        }
    }

    public static void PrintMealPlan(MealPlan mealPlan)
    {
        Console.WriteLine("=== Meal Plan ===");
        PrintMeals("Breakfast", mealPlan.Breakfast);
        PrintMeals("Lunch", mealPlan.Lunch);
        PrintMeals("Dinner", mealPlan.Dinner);
        PrintMeals("Snacks", mealPlan.Snacks);
        
        Console.WriteLine($"\nTotal Calories: {mealPlan.TotalCalories}");
        Console.WriteLine($"Total Proteins: {mealPlan.TotalProteins}g");
        Console.WriteLine($"Total Carbs: {mealPlan.TotalCarbs}g");
        Console.WriteLine($"Total Fats: {mealPlan.TotalFats}g");
    }

    private static void PrintMeals(string mealType, List<Meal> meals)
    {
        Console.WriteLine($"\n{mealType}:");
        if (!meals.Any())
        {
            Console.WriteLine("No meals selected");
            return;
        }
        
        foreach (var meal in meals)
        {
            Console.WriteLine($"- {meal.Name} ({meal.Calories} kcal)");
            Console.WriteLine($"  Ingredients: {string.Join(", ", meal.Ingredients)}");
            Console.WriteLine($"  Macros: P{meal.Proteins}g C{meal.Carbs}g F{meal.Fats}g");
        }
        Console.WriteLine($"Total: {meals.Sum(m => m.Calories)} calories");
    }
}