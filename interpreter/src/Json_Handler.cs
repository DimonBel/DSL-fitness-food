using System.Text.Json;

namespace src;

public class JsonHandler
{
    public static void SaveUser(string filePath, User_Profile user)
    {
        try
        {
            var options = new JsonSerializerOptions { WriteIndented = true };
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
            var json = File.ReadAllText(path);
            var usersData = JsonSerializer.Deserialize<Dictionary<string, List<User_Profile>>>(json);
            
            usersData ??= new Dictionary<string, List<User_Profile>>();
            usersData["users"] ??= new List<User_Profile>();
            
            if (!usersData["users"].Any(u => u.id == newUser.id))
            {
                usersData["users"].Add(newUser);
                File.WriteAllText(path, 
                    JsonSerializer.Serialize(usersData, 
                    new JsonSerializerOptions { WriteIndented = true }));
            }
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
            string path = Path.Combine("database", "Users.json");
            var json = File.ReadAllText(path);
            var usersData = JsonSerializer.Deserialize<Dictionary<string, List<User_Profile>>>(json);
            
            return usersData?["users"]?.FirstOrDefault(u => u.id == userId);
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
            var json = File.ReadAllText(path);
            var usersData = JsonSerializer.Deserialize<Dictionary<string, List<User_Profile>>>(json);
            
            if (usersData == null || !usersData.ContainsKey("users"))
                return;

            var userList = usersData["users"];
            int index = userList.FindIndex(u => u.id == updatedUser.id);
            if (index >= 0)
            {
                userList[index] = updatedUser;
                File.WriteAllText(path, 
                    JsonSerializer.Serialize(usersData, 
                    new JsonSerializerOptions { WriteIndented = true }));
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error updating user in database: {ex.Message}");
        }
    }
}