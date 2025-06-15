package com.example.dsl_backend.dto;

public class CodeRequest {
    private String code;

    // Required default constructor for deserialization
    public CodeRequest() {}

    // Getter and setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
