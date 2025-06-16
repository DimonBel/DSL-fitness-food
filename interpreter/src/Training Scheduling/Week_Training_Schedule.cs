namespace src;

public class WeeklyTrainingSchedule
{
    public Dictionary<string, WorkoutDay> Days { get; set; } = new()
    {
        ["Monday"] = new(),
        ["Tuesday"] = new(),
        ["Wednesday"] = new(),
        ["Thursday"] = new(),
        ["Friday"] = new(),
        ["Saturday"] = new(),
        ["Sunday"] = new()
    };

    public void AddWorkout(string day, Workout workout)
    {
        if (Days.ContainsKey(day))
        {
            Days[day].Workouts.Add(workout);
        }
    }
}