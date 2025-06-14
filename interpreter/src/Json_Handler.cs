using System.Text.Json;
using System.Text.Json.Serialization;

namespace src;

public class JsonHandler
{
    public static void SaveUser(string filePath, User_Profile user)
    {
        try
        {
            var options = new JsonSerializerOptions { 
                WriteIndented = true,
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            };
            string json = JsonSerializer.Serialize(user, options);
            File.WriteAllText(filePath, json);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error saving user: {ex.Message}");
        }
    }

    public static void AddUserToDatabase(User_Profile newUser)
    {
        try
        {
            string path = Path.Combine("database", "Users.json");
            List<User_Profile> users = GetAllUsersFromDatabase();
            
            // Check if user exists
            if (users.Any(u => u.id == newUser.id))
            {
                Console.WriteLine($"User with ID {newUser.id} already exists.");
                return;
            }

            users.Add(newUser);
            
            var options = new JsonSerializerOptions { 
                WriteIndented = true,
                PropertyNamingPolicy = JsonNamingPolicy.CamelCase
            };
            
            File.WriteAllText(path, JsonSerializer.Serialize(users, options));
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error adding user to database: {ex.Message}");
        }
    }

    public static User_Profile? GetUserFromDatabase(int userId)
    {
        try
        {
            var users = GetAllUsersFromDatabase();
            return users.FirstOrDefault(u => u.id == userId);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error getting user from database: {ex.Message}");
            return null;
        }
    }

    public static void UpdateUserInDatabase(User_Profile updatedUser)
    {
        try
        {
            string path = Path.Combine("database", "Users.json");
            var users = GetAllUsersFromDatabase();
            
            int index = users.FindIndex(u => u.id == updatedUser.id);
            if (index >= 0)
            {
                users[index] = updatedUser;
                
                var options = new JsonSerializerOptions { 
                    WriteIndented = true,
                    PropertyNamingPolicy = JsonNamingPolicy.CamelCase
                };
                
                File.WriteAllText(path, JsonSerializer.Serialize(users, options));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error updating user in database: {ex.Message}");
        }
    }

    private static List<User_Profile> GetAllUsersFromDatabase()
    {
        try
        {
            string path = Path.Combine("database", "Users.json");
            if (!File.Exists(path))
            {
                return new List<User_Profile>();
            }

            var json = File.ReadAllText(path);
            var options = new JsonSerializerOptions
            {
                PropertyNameCaseInsensitive = true,
                Converters = { new TimeSpanTupleConverter() }
            };
            
            return JsonSerializer.Deserialize<List<User_Profile>>(json, options) 
                   ?? new List<User_Profile>();
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error reading users database: {ex.Message}");
            return new List<User_Profile>();
        }
    }
}