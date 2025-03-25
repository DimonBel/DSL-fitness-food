package com.example.dsl_backend;

import com.example.dsl_backend.dto.HelloRequest;
import com.example.dsl_backend.dto.HelloResponse;
import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorldController {

    // GET метод (как было)
    @GetMapping("/")
    public HelloResponse helloWorld() {
        System.out.println("GET request received");
        return new HelloResponse("Hello, World!", "success", 200);
    }

    // Новый POST метод
    @PostMapping("/greet")
    public HelloResponse greetUser(@RequestBody HelloRequest request) {
        System.out.println("POST request received for: " + request.getName());

        String greeting = "Hello, " + request.getName() + "!";
        String details = "You are " + request.getAge() + " years old.";

        return new HelloResponse(
                greeting,
                "success",
                200,
                details
        );
    }
}