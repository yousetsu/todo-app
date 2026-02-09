package com.example.todoapp.controller;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.dto.TodoCreateRequest;
import com.example.todoapp.dto.TodoResponse;
import com.example.todoapp.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/todos/{id}")
    public ResponseEntity<Todo> updateTodo(
            @PathVariable Long id,
            @RequestBody Todo todoRequest) {

        Todo updated = todoService.update(id, todoRequest);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }


}
