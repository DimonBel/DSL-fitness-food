using System.Collections.Generic;
using System.Linq;

namespace src;

public class MealPlan
{
    public List<Meal> Breakfast { get; set; } = new();
    public List<Meal> Lunch { get; set; } = new();
    public List<Meal> Dinner { get; set; } = new();
    public List<Meal> Snacks { get; set; } = new();

    public float TotalCalories => 
        Breakfast.Sum(m => m.Calories) +
        Lunch.Sum(m => m.Calories) +
        Dinner.Sum(m => m.Calories) +
        Snacks.Sum(m => m.Calories);

    public float TotalProteins =>
        Breakfast.Sum(m => m.Proteins) +
        Lunch.Sum(m => m.Proteins) +
        Dinner.Sum(m => m.Proteins) +
        Snacks.Sum(m => m.Proteins);

    public float TotalCarbs =>
        Breakfast.Sum(m => m.Carbs) +
        Lunch.Sum(m => m.Carbs) +
        Dinner.Sum(m => m.Carbs) +
        Snacks.Sum(m => m.Carbs);

    public float TotalFats =>
        Breakfast.Sum(m => m.Fats) +
        Lunch.Sum(m => m.Fats) +
        Dinner.Sum(m => m.Fats) +
        Snacks.Sum(m => m.Fats);
}