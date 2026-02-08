package com.example.todoapp.controller;

import com.example.todoapp.dto.TodoCreateRequest;
import com.example.todoapp.dto.TodoResponse;
import com.example.todoapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<TodoResponse> getTodos() {
        return todoService.findAll();
    }
    @PostMapping("/todos")
    public TodoResponse createTodo(
            @RequestBody @Valid TodoCreateRequest request
    ) {
        return todoService.create(request);
    }
}
