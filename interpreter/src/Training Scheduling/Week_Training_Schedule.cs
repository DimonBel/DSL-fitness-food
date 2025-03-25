using System.Collections.Generic;

namespace src;

public class WeeklyTrainingSchedule
{
    public List<Workout> Monday { get; set; } = new();
    public List<Workout> Tuesday { get; set; } = new();
    public List<Workout> Wednesday { get; set; } = new();
    public List<Workout> Thursday { get; set; } = new();
    public List<Workout> Friday { get; set; } = new();
    public List<Workout> Saturday { get; set; } = new();
    public List<Workout> Sunday { get; set; } = new();
}