package com.example.dsl_backend;

import java.io.*;
import java.nio.file.*;

public class Main {
    public static void interpret(){
        try {
            // Get the project root directory
            Path projectRoot = Paths.get("").toAbsolutePath();

            Path exePath = projectRoot
                    .getParent() // Go up to DSL-fitness-food
                    .resolve("interpreter") // Go to interpreter folder
                    .resolve("src")
                    .resolve("publish")
                    .resolve("Program.exe");

            System.out.println("Attempting to run: " + exePath);

            // Verify the file exists
            if (!Files.exists(exePath)) {
                throw new FileNotFoundException("C# executable not found at: " + exePath);
            }

            // Create and start the process
            Process process = new ProcessBuilder(exePath.toString()).start();

            // Set up communication streams
            try (BufferedReader outputReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));
                 BufferedReader errorReader = new BufferedReader(
                         new InputStreamReader(process.getErrorStream()))) {

                // Read output
                String line;
                while ((line = outputReader.readLine()) != null) {
                    System.out.println("C# Output: " + line);
                }

                // Read errors
                while ((line = errorReader.readLine()) != null) {
                    System.err.println("C# Error: " + line);
                }
            }

            int exitCode = process.waitFor();
            System.out.println("C# Process exited with code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        interpret();
    }
}