package com.example.todoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TodoController {

    @GetMapping("/todos")
    public List<Map<String, Object>> getTodos() {
        return List.of(
                Map.of(
                        "id", 1,
                        "title", "Spring Boot理解",
                        "completed", true
                ),
                Map.of(
                        "id", 2,
                        "title", "TODO API作成",
                        "completed", false
                )
        );
    }
}
