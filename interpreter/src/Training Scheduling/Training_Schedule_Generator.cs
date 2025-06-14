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
        
        if (_workoutsData == null)
        {
            Console.WriteLine("No workouts data available");
            return schedule;
        }

        var goalWorkouts = GetGoalSpecificWorkouts(user.goal);
        if (!goalWorkouts.Any())
        {
            Console.WriteLine($"No workouts found for goal: {user.goal}");
            return schedule;
        }

        DistributeWorkouts(schedule, goalWorkouts, user);
        AssignWorkoutTimes(schedule, user);

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
            : _workoutsData.Values.FirstOrDefault() ?? new Dictionary<string, List<Workout>>();
    }

    private static void LoadWorkoutsData()
    {
        try
        {
            string path = Path.Combine("database", "Workouts.json");
            if (!File.Exists(path))
            {
                Console.WriteLine("Workouts database not found at: " + path);
                return;
            }

            string json = File.ReadAllText(path);
            _workoutsData = JsonSerializer.Deserialize<Dictionary<string, Dictionary<string, List<Workout>>>>(json);
            
            if (_workoutsData != null)
            {
                Console.WriteLine($"Loaded workout data for {_workoutsData.Count} goals");
            }
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
        
        if (availableDays.Count == 0)
        {
            Console.WriteLine("No available days found for workouts");
            return;
        }

        var selectedDays = SelectRandomDays(availableDays, workoutDays);
        Console.WriteLine($"Selected {selectedDays.Count} workout days: {string.Join(", ", selectedDays)}");

        foreach (var day in selectedDays)
        {
            string workoutType = SelectWorkoutType(user.goal);
            AddWorkoutToSchedule(schedule, goalWorkouts, day, workoutType, user);
        }
    }

    private static List<string> GetAvailableDays(User_Profile user)
    {
        var allDays = new List<string> { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        
        // If no busy times specified, all days are available
        if (user.busyTime.Count == 0)
            return allDays;

        // Filter days where user has at least 1 hour of continuous free time
        return allDays.Where(day => HasMinimumFreeTime(user, day, TimeSpan.FromHours(1))).ToList();
    }

    private static bool HasMinimumFreeTime(User_Profile user, string day, TimeSpan requiredTime)
    {
        if (user.busyTime.Count == 0)
            return true;

        // Sort busy intervals by start time
        var busyIntervals = user.busyTime.OrderBy(i => i.start).ToList();

        // Check free time at start of day
        if (busyIntervals[0].start >= requiredTime)
            return true;

        // Check free time between busy intervals
        for (int i = 0; i < busyIntervals.Count - 1; i++)
        {
            TimeSpan freeTime = busyIntervals[i + 1].start - busyIntervals[i].end;
            if (freeTime >= requiredTime)
                return true;
        }

        // Check free time at end of day
        var lastInterval = busyIntervals.Last();
        if (TimeSpan.FromHours(24) - lastInterval.end >= requiredTime)
            return true;

        return false;
    }

    private static int CalculateWorkoutDays(string goal, int exerciseExperience)
    {
        int baseDays = goal.ToLower() switch
        {
            var g when g.Contains("loss") => 4,
            var g when g.Contains("gain") || g.Contains("muscle") => 5,
            _ => 3 // Maintenance
        };

        // Adjust based on experience (more exercises = more experience)
        int experienceBonus = Math.Min(2, exerciseExperience / 3);
        return Math.Min(6, baseDays + experienceBonus); // Max 6 days per week
    }

    private static List<string> SelectRandomDays(List<string> availableDays, int requiredDays)
    {
        if (availableDays.Count <= requiredDays)
            return availableDays;

        // Ensure we don't schedule consecutive days for beginners
        return availableDays.OrderBy(d => _random.Next()).Take(requiredDays).ToList();
    }

    private static string SelectWorkoutType(string goal)
    {
        int roll = _random.Next(100);
        
        return goal.ToLower() switch
        {
            var g when g.Contains("loss") => roll < 60 ? "Cardio" : roll < 85 ? "Strength" : "Flexibility",
            var g when g.Contains("gain") || g.Contains("muscle") => roll < 65 ? "Strength" : roll < 85 ? "Cardio" : "Flexibility",
            _ => roll < 40 ? "Cardio" : roll < 70 ? "Strength" : "Flexibility" // Maintenance
        };
    }

    private static void AddWorkoutToSchedule(
        WeeklyTrainingSchedule schedule,
        Dictionary<string, List<Workout>> goalWorkouts,
        string day,
        string workoutType,
        User_Profile user)
    {
        if (!goalWorkouts.TryGetValue(workoutType, out var workouts) || !workouts.Any())
        {
            Console.WriteLine($"No {workoutType} workouts available for {user.goal}");
            return;
        }

        var suitableWorkouts = workouts
            .Where(w => IsWorkoutSuitable(w, user))
            .ToList();

        if (!suitableWorkouts.Any())
        {
            // If no suitable workouts, use any available workout
            suitableWorkouts = workouts;
        }

        var selectedWorkout = suitableWorkouts[_random.Next(suitableWorkouts.Count)];
        
        // Create a copy to avoid modifying the original
        var workoutCopy = new Workout
        {
            Name = selectedWorkout.Name,
            Type = selectedWorkout.Type,
            Duration = AdjustWorkoutDuration(selectedWorkout.Duration, user.exercises.Count),
            Intensity = selectedWorkout.Intensity,
            Difficulty = selectedWorkout.Difficulty,
            CaloriesBurned = selectedWorkout.CaloriesBurned
        };
        
        schedule.AddWorkout(day, workoutCopy);
        Console.WriteLine($"Added {workoutCopy.Name} ({workoutCopy.Type}) to {day}");
    }

    private static int AdjustWorkoutDuration(int baseDuration, int exerciseExperience)
    {
        // Beginners get shorter workouts, experienced users get longer
        int adjustment = (exerciseExperience / 2) * 5; // Add 5 minutes per 2 exercises known
        return Math.Max(15, Math.Min(90, baseDuration + adjustment)); // Between 15-90 minutes
    }

    private static bool IsWorkoutSuitable(Workout workout, User_Profile user)
    {
        // Check difficulty based on user's exercise experience
        bool difficultyOK = user.exercises.Count switch
        {
            < 2 => workout.Difficulty != "Hard" && workout.Difficulty != "Very Hard",
            < 4 => workout.Difficulty != "Very Hard",
            _ => true
        };

        // Check duration isn't too long for beginners
        bool durationOK = user.exercises.Count < 3 ? workout.Duration <= 45 : true;

        return difficultyOK && durationOK;
    }

    private static void AssignWorkoutTimes(WeeklyTrainingSchedule schedule, User_Profile user)
    {
        var optimalTimes = TimeSlotFinder.FindOptimalTimes(user);
        var trainingTime = optimalTimes.TryGetValue("Training", out var time) ? time : new TimeSpan(7, 0, 0);

        // Assign the optimal training time to all workouts
        var allDays = new[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
        
        foreach (var day in allDays)
        {
            var dayWorkouts = GetWorkoutsForDay(schedule, day);
            foreach (var workout in dayWorkouts)
            {
                workout.ScheduledTime = trainingTime;
            }
        }
    }

    private static List<Workout> GetWorkoutsForDay(WeeklyTrainingSchedule schedule, string day)
    {
        return day.ToLower() switch
        {
            "monday" => schedule.Monday,
            "tuesday" => schedule.Tuesday,
            "wednesday" => schedule.Wednesday,
            "thursday" => schedule.Thursday,
            "friday" => schedule.Friday,
            "saturday" => schedule.Saturday,
            "sunday" => schedule.Sunday,
            _ => new List<Workout>()
        };
    }
}