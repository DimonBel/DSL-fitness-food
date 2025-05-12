namespace src;

public class Workout
{
    public string Name { get; set; } = string.Empty;
    public string Type { get; set; } = string.Empty;
    public int Duration { get; set; } // in minutes
    public string Intensity { get; set; } = "Medium";
    public string Difficulty { get; set; } = "Medium";
}

public class WorkoutDay
{
    public List<Workout> Workouts { get; set; } = new();
    
    public int TotalDuration => Workouts.Sum(w => w.Duration);
    public bool HasWorkout => Workouts.Any();
}