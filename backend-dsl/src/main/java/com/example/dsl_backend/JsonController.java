
package com.example.dsl_backend;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.example.dsl_backend.Main.interpret;


@RestController
public class JsonController {

    // Relative path from project root
    private static final String JSON_FILE_PATH = "../interpreter/output_test.json";


    @PostMapping(value = "/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJsonData() throws IOException {
        interpret();

        // Get the project root directory
        String projectRoot = System.getProperty("user.dir");
        Path filePath = Paths.get(projectRoot, JSON_FILE_PATH);

        if (!Files.exists(filePath)) {
            return ResponseEntity.status(404)
                    .body("{\"error\":\"Output file not found at: " + filePath + "\"}");
        }

        try {
            String content = Files.readString(filePath);
            return ResponseEntity.ok(content);
        } catch (IOException e) {
            return ResponseEntity.status(500)
                    .body("{\"error\":\"Error reading file: " + e.getMessage() + "\"}");
        }
    }
}
