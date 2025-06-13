namespace src;

public class User_Profile
{
    public int id { get; set; }
    public string name { get; set; } = string.Empty;
    public int age { get; set; }
    public float weight { get; set; }
    public float height { get; set; }
    public string goal { get; set; } = string.Empty;
    public List<string[]> busyTime { get; set; } = new();
    public string diet { get; set; } = string.Empty;
    public List<string> allergies { get; set; } = new();
    public List<Exercise> exercises { get; set; } = new();
    public float bmi { get; set; }
    public float caloriesPerDay { get; set; }
    
    [JsonPropertyName("mealPlan")]
    public MealPlan MealPlan { get; set; } = new();
    
    [JsonPropertyName("trainingSchedule")]
    public WeeklyTrainingSchedule TrainingSchedule { get; set; } = new();
}

public class Exercise
{
    public string name { get; set; } = string.Empty;
    public float weight { get; set; }
    public int sets { get; set; }
    public int reps { get; set; }
}