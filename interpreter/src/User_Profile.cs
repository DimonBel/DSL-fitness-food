using System.Text.Json.Serialization;

namespace src;
public class User_Profile
{
    public int id { get; set; }
    [JsonPropertyName("name")]
    public string name { get; set; } = string.Empty;
    public float weight { get; set; }
    public float height { get; set; }
    public int age { get; set; }
    public string goal { get; set; } = "Maintenance";
    
    [JsonConverter(typeof(TimeSpanTupleConverter))]
    public List<(TimeSpan start, TimeSpan end)> busyTime { get; set; } = new();
    
    public string diet { get; set; } = "Balanced";
    public List<string> allergies { get; set; } = new();
    public List<Exercise> exercises { get; set; } = new();
    public float bmi { get; set; }
    public float caloriesPerDay { get; set; }
    public MealPlan MealPlan { get; set; } = new();
    public WeeklyTrainingSchedule TrainingSchedule { get; set; } = new();

    public bool ValidateBusyTimes()
    {
        if (busyTime == null || busyTime.Count == 0)
            return true;

        foreach (var interval in busyTime)
        {
            if (interval.start < TimeSpan.Zero || interval.start >= TimeSpan.FromHours(24) ||
                interval.end <= TimeSpan.Zero || interval.end > TimeSpan.FromHours(24))
            {
                Console.WriteLine($"Error: Time values must be between 00:00 and 24:00. Invalid interval: {interval.start}-{interval.end}");
                return false;
            }

            if (interval.start == interval.end)
            {
                Console.WriteLine($"Error: Busy time interval cannot be zero-length. Invalid interval: {interval.start}-{interval.end}");
                return false;
            }
        }

        for (int i = 0; i < busyTime.Count; i++)
        {
            for (int j = i + 1; j < busyTime.Count; j++)
            {
                if (TimeIntervalsOverlap(busyTime[i], busyTime[j]))
                {
                    Console.WriteLine($"Error: Busy time intervals overlap: {busyTime[i].start}-{busyTime[i].end} and {busyTime[j].start}-{busyTime[j].end}");
                    return false;
                }
            }
        }

        return true;
    }

    private bool TimeIntervalsOverlap((TimeSpan start, TimeSpan end) a, (TimeSpan start, TimeSpan end) b)
    {
        if (a.start > a.end) a = (a.start, a.end + TimeSpan.FromHours(24));
        if (b.start > b.end) b = (b.start, b.end + TimeSpan.FromHours(24));

        return a.start < b.end && b.start < a.end;
    }

    public bool IsTimeAvailable(TimeSpan startTime, TimeSpan endTime)
    {
        if (startTime >= endTime)
            return false;

        foreach (var busy in busyTime)
        {
            if (TimeIntervalsOverlap(busy, (startTime, endTime)))
                return false;
        }
        return true;
    }
}

public class Exercise
{
    private string _name = string.Empty;
    private float _weight;
    private int _sets;
    private int _reps;

    public string name 
    { 
        get => _name;
        set => _name = string.IsNullOrWhiteSpace(value) ? "Unnamed Exercise" : value;
    }
    
    public float weight 
    { 
        get => _weight; 
        set => _weight = Math.Max(0, value);
    }
    
    public int sets 
    { 
        get => _sets; 
        set => _sets = Math.Clamp(value, 1, 10);
    }
    
    public int reps 
    { 
        get => _reps; 
        set => _reps = Math.Clamp(value, 1, 50);
    }
}