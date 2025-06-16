namespace src;

public class Processor
{
    public static void ProcessUser(User_Profile user)
    {
        if (user == null)
        {
            Console.WriteLine("No user data to process.");
            return;
        }

        // Calculate BMI
        user.bmi = CalculateBMI(user.weight, user.height);

        // Calculate daily calories (using Mifflin-St Jeor Formula)
        user.caloriesPerDay = CalculateDailyCalories(user);

        // Generate plans
        user.MealPlan = MealPlanGenerator.GenerateMealPlan(user);
        user.TrainingSchedule = TrainingScheduleGenerator.GenerateTrainingSchedule(user);

        Console.WriteLine($"Processed User -> ID: {user.id}; BMI: {user.bmi:F2}; Calories/day: {user.caloriesPerDay:F0}");
    }

    private static float CalculateBMI(float weight, float height)
    {
        if (height <= 0 || weight <= 0)
            return 0;
        
        return weight / (height * height);
    }

    private static float CalculateDailyCalories(User_Profile user)
    {
        if (user == null) return 0;

        // Mifflin-St Jeor Formula
        float bmr = 10 * user.weight + 6.25f * (user.height * 100) - 5 * user.age + 5;
        
        // More precise activity factor based on workout duration
        float activityFactor = user.TrainingSchedule.Days.Values
            .Sum(day => day.Workouts.Sum(w => w.Duration)) switch
        {
            < 60 => 1.2f,    // Sedentary
            < 150 => 1.375f,  // Lightly active
            < 300 => 1.55f,   // Moderately active
            _ => 1.725f       // Very active
        };

        // Goal factors
        float goalFactor = user.goal.ToLower() switch
        {
            "weight loss" => 0.8f,
            "fat loss" => 0.85f,
            "maintenance" => 1.0f,
            "muscle gain" or "gain muscles" => 1.1f,
            "bulk" => 1.2f,
            _ => 1.0f
        };

        return bmr * activityFactor * goalFactor;
    }
    
}

