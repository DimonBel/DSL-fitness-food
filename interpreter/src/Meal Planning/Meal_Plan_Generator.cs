namespace src;

public static class MealPlanGenerator
{
    public static MealPlan GenerateMealPlan(User_Profile user)
    {
        var mealPlan = new MealPlan();
        // ETo Modify
        if (user.diet == "Vegetarian")
        {
            mealPlan.Breakfast.Add(new Meal { Name = "Oatmeal", Calories = 300, Carbs = 50, Proteins = 10, Fats = 5 });
            mealPlan.Lunch.Add(new Meal { Name = "Vegetable Stir Fry", Calories = 400, Carbs = 60, Proteins = 15, Fats = 10 });
            mealPlan.Dinner.Add(new Meal { Name = "Lentil Soup", Calories = 350, Carbs = 40, Proteins = 20, Fats = 8 });
        }
        else
        {
            mealPlan.Breakfast.Add(new Meal { Name = "Scrambled Eggs", Calories = 350, Carbs = 10, Proteins = 20, Fats = 25 });
            mealPlan.Lunch.Add(new Meal { Name = "Grilled Chicken Salad", Calories = 450, Carbs = 20, Proteins = 30, Fats = 15 });
            mealPlan.Dinner.Add(new Meal { Name = "Salmon with Quinoa", Calories = 500, Carbs = 40, Proteins = 35, Fats = 20 });
        }
        return mealPlan;
    }
}