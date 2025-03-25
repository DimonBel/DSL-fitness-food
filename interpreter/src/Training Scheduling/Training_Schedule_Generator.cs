namespace src;

public static class TrainingScheduleGenerator
{
    public static WeeklyTrainingSchedule GenerateTrainingSchedule(User_Profile user)
    {
        var schedule = new WeeklyTrainingSchedule();
        // To Modify
        if (user.goal == "Weight Loss")
        {
            schedule.Monday.Add(new Workout { Name = "Running", Type = "Cardio", Duration = 30, Intensity = "High" });
            schedule.Wednesday.Add(new Workout { Name = "Cycling", Type = "Cardio", Duration = 45, Intensity = "Medium" });
            schedule.Friday.Add(new Workout { Name = "Yoga", Type = "Flexibility", Duration = 60, Intensity = "Low" });
        }
        else if (user.goal == "Muscle Gain")
        {
            schedule.Monday.Add(new Workout { Name = "Deadlifts", Type = "Strength", Duration = 60, Intensity = "High" });
            schedule.Wednesday.Add(new Workout { Name = "Bench Press", Type = "Strength", Duration = 60, Intensity = "High" });
            schedule.Friday.Add(new Workout { Name = "Squats", Type = "Strength", Duration = 60, Intensity = "High" });
        }
        return schedule;
    }
}