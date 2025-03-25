package com.example.dsl_backend.dto;

public class HelloResponse {
    private String message;
    private String status;
    private int code;
    private String details; // Новое поле

    public HelloResponse(String message, String status, int code) {
        this(message, status, code, null);
    }

    public HelloResponse(String message, String status, int code, String details) {
        this.message = message;
        this.status = status;
        this.code = code;
        this.details = details;
    }

    // Геттеры
    public String getMessage() { return message; }
    public String getStatus() { return status; }
    public int getCode() { return code; }
    public String getDetails() { return details; }
}