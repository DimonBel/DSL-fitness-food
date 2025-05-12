using System.Text.Json;

namespace src;

public static class TrainingScheduleGenerator
{
    private static Dictionary<string, Dictionary<string, List<Workout>>>? _workoutsData;
    private static readonly Random _random = new();

    public static WeeklyTrainingSchedule GenerateTrainingSchedule(User_Profile user)
    {
        LoadWorkoutsData();
        var schedule = new WeeklyTrainingSchedule();
        
        if (_workoutsData == null || user.exercises.Count == 0)
            return schedule;

        var goalWorkouts = GetGoalSpecificWorkouts(user.goal);
        DistributeWorkouts(schedule, goalWorkouts, user);

        return schedule;
    }

    private static Dictionary<string, List<Workout>> GetGoalSpecificWorkouts(string goal)
    {
        if (_workoutsData == null)
            return new Dictionary<string, List<Workout>>();

        var normalizedGoal = goal.ToLower() switch
        {
            var g when g.Contains("loss") => "Weight Loss",
            var g when g.Contains("gain") || g.Contains("muscle") => "Muscle Gain",
            _ => "Maintenance"
        };

        return _workoutsData.TryGetValue(normalizedGoal, out var workouts) 
            ? workouts 
            : _workoutsData["Maintenance"];
    }

    private static void LoadWorkoutsData()
    {
        try
        {
            string path = Path.Combine("database", "Workouts.json");
            if (!File.Exists(path))
            {
                Console.WriteLine("Workouts database not found");
                return;
            }

            string json = File.ReadAllText(path);
            _workoutsData = JsonSerializer.Deserialize<Dictionary<string, Dictionary<string, List<Workout>>>>(json);
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Error loading workouts data: {ex.Message}");
        }
    }

    private static void DistributeWorkouts(
        WeeklyTrainingSchedule schedule,
        Dictionary<string, List<Workout>> goalWorkouts,
        User_Profile user)
    {
        var availableDays = GetAvailableDays(user);
        int workoutDays = CalculateWorkoutDays(user.goal, user.exercises.Count);
        
        var selectedDays = SelectRandomDays(availableDays, workoutDays);

        foreach (var day in selectedDays)
        {
            string workoutType = SelectWorkoutType(user.goal);
            AddWorkoutToSchedule(schedule, goalWorkouts, day, workoutType, user);
        }
    }

    private static List<string> GetAvailableDays(User_Profile user)
    {
        var allDays = new List<string> { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        
        // Filter days where user has at least 2 hours of continuous free time
        return allDays.Where(day => HasMinimumFreeTime(user, day, TimeSpan.FromHours(2))).ToList();
    }

    private static bool HasMinimumFreeTime(User_Profile user, string day, TimeSpan requiredTime)
    {
        // Get all busy intervals for the day (currently user.busyTime doesn't track days)
        // For now, we'll assume all busy times could apply to any day
        // In a real implementation, you'd want to track busy times per day
        
        if (user.busyTime.Count == 0)
            return true;

        // Sort busy intervals by start time
        var busyIntervals = user.busyTime.OrderBy(i => i.start).ToList();

        // Check free time between busy intervals and day boundaries
        TimeSpan previousEnd = TimeSpan.Zero;
        foreach (var interval in busyIntervals)
        {
            TimeSpan freeTime = interval.start - previousEnd;
            if (freeTime >= requiredTime)
                return true;

            previousEnd = interval.end;
        }

        // Check after last busy interval
        if (TimeSpan.FromHours(24) - previousEnd >= requiredTime)
            return true;

        return false;
    }

    private static int CalculateWorkoutDays(string goal, int exerciseExperience)
    {
        return goal.ToLower() switch
        {
            var g when g.Contains("loss") => Math.Min(5, 3 + exerciseExperience / 2),
            var g when g.Contains("gain") || g.Contains("muscle") => Math.Min(6, 3 + exerciseExperience),
            _ => 3 // Maintenance
        };
    }

    private static List<string> SelectRandomDays(List<string> availableDays, int requiredDays)
    {
        if (availableDays.Count <= requiredDays)
            return availableDays;

        return availableDays.OrderBy(d => _random.Next()).Take(requiredDays).ToList();
    }

    private static string SelectWorkoutType(string goal)
    {
        int roll = _random.Next(100);
        
        return goal.ToLower() switch
        {
            var g when g.Contains("loss") => roll < 70 ? "Cardio" : roll < 90 ? "Strength" : "Flexibility",
            var g when g.Contains("gain") || g.Contains("muscle") => roll < 70 ? "Strength" : roll < 90 ? "Cardio" : "Flexibility",
            _ => roll < 40 ? "Cardio" : roll < 80 ? "Strength" : "Flexibility" // Maintenance
        };
    }

    private static void AddWorkoutToSchedule(
        WeeklyTrainingSchedule schedule,
        Dictionary<string, List<Workout>> goalWorkouts,
        string day,
        string workoutType,
        User_Profile user)
    {
        if (!goalWorkouts.TryGetValue(workoutType, out var workouts))
            return;

        var suitableWorkouts = workouts
            .Where(w => IsWorkoutSuitable(w, user))
            .ToList();

        if (suitableWorkouts.Count == 0)
            return;

        var selectedWorkout = suitableWorkouts[_random.Next(suitableWorkouts.Count)];
        selectedWorkout.Duration = AdjustWorkoutDuration(selectedWorkout.Duration, user.exercises.Count);
        
        schedule.AddWorkout(day, selectedWorkout);
    }

    private static int AdjustWorkoutDuration(int baseDuration, int exerciseExperience)
    {
        return baseDuration + (exerciseExperience / 2) * 5; // Add 5 minutes per 2 exercises known
    }

    private static bool IsWorkoutSuitable(Workout workout, User_Profile user)
    {
        // Placeholder for equipment check - would need to be implemented based on user profile
        bool hasEquipment = true;
        
        bool difficultyOK = user.exercises.Count switch
        {
            < 3 => workout.Difficulty != "Hard",
            < 5 => workout.Difficulty != "Very Hard",
            _ => true
        };

        return hasEquipment && difficultyOK;
    }
}