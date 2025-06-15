using System.Text.Json;
using System.Text.Json.Serialization;

namespace src;

public static class MealPlanGenerator
{
    private static Dictionary<string, Dictionary<string, Dictionary<string, Dictionary<string, Meal>>>>? _mealsData;

    private static string GetDatabasePath()
    {
        string baseDirectory = AppDomain.CurrentDomain.BaseDirectory;
        string projectRoot = Path.GetFullPath(Path.Combine(baseDirectory, "../.."));
        return Path.Combine(projectRoot, "src", "database");
    }

    public static MealPlan GenerateMealPlan(User_Profile user)
    {
        string path = Path.Combine(GetDatabasePath(), "Meals.json");
        if (!File.Exists(path))
        {
            Console.WriteLine("Meals database not found at: " + path);
            return new MealPlan();
        }

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

        // Get all meals for the diet
        var dietMeals = dietTypes[dietKey];

        // Get ALL meals (including those with allergies) and categorize them
        mealPlan.Breakfast = GetAllMealsWithAllergyInfo(dietMeals["Breakfast"], user.allergies);
        mealPlan.Lunch = GetAllMealsWithAllergyInfo(dietMeals["Lunch"], user.allergies);
        mealPlan.Dinner = GetAllMealsWithAllergyInfo(dietMeals["Dinner"], user.allergies);
        mealPlan.Snacks = GetAllMealsWithAllergyInfo(dietMeals["Snacks"], user.allergies);

        if (mealPlan.Breakfast.Count == 0 &&
            mealPlan.Lunch.Count == 0 &&
            mealPlan.Dinner.Count == 0 &&
            mealPlan.Snacks.Count == 0)
        {
            Console.WriteLine("Warning: No meals found for the specified diet");
        }

        return mealPlan;
    }

    private static List<Meal> GetAllMealsWithAllergyInfo(Dictionary<string, Meal> meals, List<string> allergies)
    {
        var result = new List<Meal>();

        foreach (var mealPair in meals)
        {
            var meal = new Meal
            {
                Name = mealPair.Key,
                Ingredients = mealPair.Value.Ingredients,
                Calories = mealPair.Value.Calories,
                Carbs = mealPair.Value.Carbs,
                Proteins = mealPair.Value.Proteins,
                Fats = mealPair.Value.Fats
            };

            // Check if meal contains allergens
            bool hasAllergens = allergies.Any(allergy =>
                meal.Ingredients.Any(ingredient =>
                    ingredient.Contains(allergy, StringComparison.OrdinalIgnoreCase)));

            // Add a note to the meal name if it contains allergens
            if (hasAllergens)
            {
                meal.Name += " ⚠️ (Contains allergens)";
            }

            result.Add(meal);
        }

        return result;
    }

    // Alternative method: Get only safe meals (original behavior)
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
            string path = Path.Combine(GetDatabasePath(), "Meals.json");
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

    public static List<Meal> FindMealsByIngredient(string ingredient, string? dietType = null, string? mealType = null)
    {
        LoadMealsData();
        var foundMeals = new List<Meal>();

        if (_mealsData == null || !_mealsData.ContainsKey("DietTypes"))
        {
            Console.WriteLine("Error: Meals data not loaded properly");
            return foundMeals;
        }

        var dietsToSearch = dietType != null
            ? _mealsData["DietTypes"].Where(d => d.Key.Equals(dietType, StringComparison.OrdinalIgnoreCase))
            : _mealsData["DietTypes"].AsEnumerable();

        foreach (var diet in dietsToSearch)
        {
            var mealTypesToSearch = mealType != null
                ? diet.Value.Where(m => m.Key.Equals(mealType, StringComparison.OrdinalIgnoreCase))
                : diet.Value.AsEnumerable();

            foreach (var mealCategory in mealTypesToSearch)
            {
                foreach (var meal in mealCategory.Value)
                {
                    if (meal.Value.Ingredients.Any(i =>
                        i.Contains(ingredient, StringComparison.OrdinalIgnoreCase)))
                    {
                        foundMeals.Add(new Meal
                        {
                            Name = meal.Key,
                            Ingredients = meal.Value.Ingredients,
                            Calories = meal.Value.Calories,
                            Carbs = meal.Value.Carbs,
                            Proteins = meal.Value.Proteins,
                            Fats = meal.Value.Fats,
                            MealType = mealCategory.Key
                        });
                    }
                }
            }
        }

        return foundMeals;
    }

    public static List<Meal> FindMealsByIngredients(List<string> ingredients, bool matchAll = false)
    {
        LoadMealsData();
        var foundMeals = new List<Meal>();

        if (_mealsData == null || !_mealsData.ContainsKey("DietTypes"))
        {
            Console.WriteLine("Error: Meals data not loaded properly");
            return foundMeals;
        }

        foreach (var diet in _mealsData["DietTypes"])
        {
            foreach (var mealCategory in diet.Value)
            {
                foreach (var meal in mealCategory.Value)
                {
                    bool containsIngredients = matchAll
                        ? ingredients.All(ing => meal.Value.Ingredients.Any(
                            mIng => mIng.Contains(ing, StringComparison.OrdinalIgnoreCase)))
                        : ingredients.Any(ing => meal.Value.Ingredients.Any(
                            mIng => mIng.Contains(ing, StringComparison.OrdinalIgnoreCase)));

                    if (containsIngredients)
                    {
                        foundMeals.Add(new Meal
                        {
                            Name = meal.Key,
                            Ingredients = meal.Value.Ingredients,
                            Calories = meal.Value.Calories,
                            Carbs = meal.Value.Carbs,
                            Proteins = meal.Value.Proteins,
                            Fats = meal.Value.Fats,
                            MealType = mealCategory.Key
                        });
                    }
                }
            }
        }

        return foundMeals;
    }
}