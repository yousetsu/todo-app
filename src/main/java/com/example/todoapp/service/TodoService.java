package com.example.todoapp.service;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.dto.TodoCreateRequest;
import com.example.todoapp.dto.TodoResponse;
import com.example.todoapp.exception.ResourceNotFoundException;
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
    public TodoResponse create(TodoCreateRequest request) {

        Todo todo = new Todo(
                request.getTitle(),
                false
        );

        Todo saved = todoRepository.save(todo);

        return new TodoResponse(
                saved.getId(),
                saved.getTitle(),
                saved.isCompleted()
        );
    }
    public Todo update(Long id, Todo request) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());

        return todoRepository.save(todo);
    }
    public void delete(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        todoRepository.delete(todo);
    }

}
