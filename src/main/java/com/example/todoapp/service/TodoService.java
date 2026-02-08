package com.example.todoapp.service;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.dto.TodoResponse;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(todo ->
                        new TodoResponse(
                                todo.getId(),
                                todo.getTitle(),
                                todo.isCompleted()
                        )
                )
                .toList();
    }

    public void createSampleTodosIfEmpty() {
        if (todoRepository.count() == 0) {
            todoRepository.save(new Todo("H2に保存されたTODO", false));
            todoRepository.save(new Todo("DB連携を理解する", true));
        }
    }
}
