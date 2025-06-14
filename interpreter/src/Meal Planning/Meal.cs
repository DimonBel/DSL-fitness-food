using System.Text.Json.Serialization;

namespace src;

public class Meal
{
    [JsonPropertyName("Name")]
    public string Name { get; set; } = string.Empty;

    [JsonPropertyName("Ingredients")]
    public List<string> Ingredients { get; set; } = new();

    [JsonPropertyName("Calories")]
    public float Calories { get; set; }

    [JsonPropertyName("Carbs")]
    public float Carbs { get; set; }

    [JsonPropertyName("Proteins")]
    public float Proteins { get; set; }

    [JsonPropertyName("Fats")]
    public float Fats { get; set; }

    [JsonPropertyName("MealType")]
    public string MealType { get; set; } = "General";
}