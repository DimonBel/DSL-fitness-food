public class WeeklyTrainingSchedule
{
    // Individual day properties
    public List<Workout> Monday { get; set; } = new();
    public List<Workout> Tuesday { get; set; } = new();
    public List<Workout> Wednesday { get; set; } = new();
    public List<Workout> Thursday { get; set; } = new();
    public List<Workout> Friday { get; set; } = new();
    public List<Workout> Saturday { get; set; } = new();
    public List<Workout> Sunday { get; set; } = new();

    // Days property for Processor compatibility
    public Dictionary<string, List<Workout>> Days
    {
        get
        {
            return new Dictionary<string, List<Workout>>
            {
                { "Monday", Monday },
                { "Tuesday", Tuesday },
                { "Wednesday", Wednesday },
                { "Thursday", Thursday },
                { "Friday", Friday },
                { "Saturday", Saturday },
                { "Sunday", Sunday }
            };
        }
        set
        {
            // Allow setting individual days through the Days property
            if (value.ContainsKey("Monday")) Monday = value["Monday"];
            if (value.ContainsKey("Tuesday")) Tuesday = value["Tuesday"];
            if (value.ContainsKey("Wednesday")) Wednesday = value["Wednesday"];
            if (value.ContainsKey("Thursday")) Thursday = value["Thursday"];
            if (value.ContainsKey("Friday")) Friday = value["Friday"];
            if (value.ContainsKey("Saturday")) Saturday = value["Saturday"];
            if (value.ContainsKey("Sunday")) Sunday = value["Sunday"];
        }
    }

    public void AddWorkout(string day, Workout workout)
    {
        var dayProperty = GetDayProperty(day);
        dayProperty?.Add(workout);
    }

    private List<Workout>? GetDayProperty(string day)
    {
        return day.ToLower() switch
        {
            "monday" => Monday,
            "tuesday" => Tuesday,
            "wednesday" => Wednesday,
            "thursday" => Thursday,
            "friday" => Friday,
            "saturday" => Saturday,
            "sunday" => Sunday,
            _ => null
        };
    }

    public int GetTotalWorkouts()
    {
        return Monday.Count + Tuesday.Count + Wednesday.Count + Thursday.Count + 
               Friday.Count + Saturday.Count + Sunday.Count;
    }

    public int GetEstimatedWeeklyCalories()
    {
        var allWorkouts = new List<Workout>();
        allWorkouts.AddRange(Monday);
        allWorkouts.AddRange(Tuesday);
        allWorkouts.AddRange(Wednesday);
        allWorkouts.AddRange(Thursday);
        allWorkouts.AddRange(Friday);
        allWorkouts.AddRange(Saturday);
        allWorkouts.AddRange(Sunday);

        return allWorkouts.Sum(w => w.CaloriesBurned);
    }

    public List<string> GetWorkoutDays()
    {
        var workoutDays = new List<string>();
        
        if (Monday.Any()) workoutDays.Add("Monday");
        if (Tuesday.Any()) workoutDays.Add("Tuesday");
        if (Wednesday.Any()) workoutDays.Add("Wednesday");
        if (Thursday.Any()) workoutDays.Add("Thursday");
        if (Friday.Any()) workoutDays.Add("Friday");
        if (Saturday.Any()) workoutDays.Add("Saturday");
        if (Sunday.Any()) workoutDays.Add("Sunday");

        return workoutDays;
    }
}

public class Workout
{
    public string Name { get; set; } = string.Empty;
    public string Type { get; set; } = string.Empty;
    public int Duration { get; set; }
    public string Intensity { get; set; } = string.Empty;
    public string Difficulty { get; set; } = string.Empty;
    public int CaloriesBurned { get; set; }
    public TimeSpan ScheduledTime { get; set; }
}

public class Exercise
{
    public string name { get; set; } = string.Empty;
    public int sets { get; set; }
    public int reps { get; set; }
}