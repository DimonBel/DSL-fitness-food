using System;
using System.Collections.Generic;

namespace src;

public class Processor
{
    public static void ProcessUser(User_Profile user)
{
    if (user == null)
    { Console.WriteLine("No user data to process."); return; }
    user.bmi = user.weight / (user.height * user.height);
    user.caloriesPerDay = (13.397f * user.weight) + (4.799f * user.height * 100) - (5.677f * 25) + 88.362f; // Age assumed as 25
    user.MealPlan = MealPlanGenerator.GenerateMealPlan(user);
    user.TrainingSchedule = TrainingScheduleGenerator.GenerateTrainingSchedule(user);
    Console.WriteLine($"Processed User -> ID: {user.id}, BMI: {user.bmi:F2}, Calories/day: {user.caloriesPerDay:F0}");
}
}
