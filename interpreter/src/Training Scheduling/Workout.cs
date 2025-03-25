namespace src;

public class Workout
{
    public string Name { get; set; } = string.Empty;
    public string Type { get; set; } = string.Empty; // e.g., Cardio, Strength, Yoga
    public int Duration { get; set; } // in minutes
    // duration in exercises, sets and reps
    public string Intensity { get; set; } = string.Empty; // e.g., Low, Medium, High
}