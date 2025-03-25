package com.example.dsl_backend.dto;

public class HelloRequest {
    private String name;
    private int age;

    // Конструктор (нужен для десериализации)
    public HelloRequest() {}

    // Геттеры и сеттеры (обязательны)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}