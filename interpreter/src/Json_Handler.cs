using System;
using System.IO;
using System.Text.Json;

namespace src;

public class JsonHandler
{
    public static void SaveUser(string filePath, User_Profile user)
    {
        string json = JsonSerializer.Serialize(user, new JsonSerializerOptions { WriteIndented = true });
        File.WriteAllText(filePath, json);
    }
}