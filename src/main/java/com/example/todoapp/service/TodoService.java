package com.example.todoapp.service;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.dto.TodoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    public List<TodoResponse> findAll() {
        List<Todo> todos = List.of(
                new Todo(1L, "DTOとService理解", true),
                new Todo(2L, "現場っぽい構成にする", false)
        );

        return todos.stream()
                .map(todo ->
                        new TodoResponse(
                                todo.getId(),
                                todo.getTitle(),
                                todo.isCompleted()
                        )
                )
                .toList();
    }
}
