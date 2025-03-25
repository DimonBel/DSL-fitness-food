using System.Collections.Generic;

namespace src;

public class MealPlan
{
    public List<Meal> Breakfast { get; set; } = new();
    public List<Meal> Lunch { get; set; } = new();
    public List<Meal> Dinner { get; set; } = new();
    public List<Meal> Snacks { get; set; } = new();

    public float TotalCalories()
    {
        return Breakfast.Sum(m => m.Calories) +
               Lunch.Sum(m => m.Calories) +
               Dinner.Sum(m => m.Calories) +
               Snacks.Sum(m => m.Calories);
    }
}