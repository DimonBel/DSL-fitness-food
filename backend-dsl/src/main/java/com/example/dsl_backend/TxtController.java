package com.example.dsl_backend;

import com.example.dsl_backend.dto.CodeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/txt")
public class TxtController {

    private static final String FILE_NAME = "example.txt";

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveCodeToTxt(@RequestBody CodeRequest request) {
        try {
            String code = request.getCode();

            // Correct path: <project-root>/src/main/resources/example.txt
            String projectRoot = System.getProperty("user.dir");
            Path path = Paths.get(projectRoot, "src", "main", "resources", FILE_NAME);

            // Ensure parent directories exist
            Files.createDirectories(path.getParent());

            // Write to the file
            Files.writeString(path, code);

            return ResponseEntity.ok("{\"message\":\"Code saved to src/main/resources/" + FILE_NAME + "\"}");
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body("{\"error\":\"Failed to save code: " + e.getMessage() + "\"}");
        }
    }
}
