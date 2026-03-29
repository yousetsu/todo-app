package com.example.todoapp.service;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.dto.TodoCreateRequest;
import com.example.todoapp.dto.TodoResponse;
import com.example.todoapp.dto.TodoUpdateRequest;
import com.example.todoapp.exception.ResourceNotFoundException;
import com.example.todoapp.mapper.TodoMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * TODOサービスの実装クラス
 */
@Service
public class TodoServiceImpl implements ITodoService {

    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoResponse> findAll() {
        return todoMapper.findAll()
                .stream()
                .map(todo ->
                        new TodoResponse(
                                todo.getId(),
                                todo.getTitle(),
                                todo.isCompleted(),
                                todo.getNote()
                        )
                )
                .toList();
    }

    @Override
    @Transactional
    public TodoResponse create(TodoCreateRequest request) {
        Todo todo = new Todo(
                request.getTitle(),
                false,
                request.getNote()
        );

        todoMapper.insert(todo);

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted(),
                todo.getNote()
        );
    }

    @Override
    @Transactional
    public TodoResponse update(Long id, TodoUpdateRequest request) {
        Todo todo = todoMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        todo.setTitle(request.getTitle());
        todo.setCompleted(request.isCompleted());
        todoMapper.update(todo);

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isCompleted(),
                todo.getNote()
        );
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Todo todo = todoMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
        todoMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void createSampleTodosIfEmpty() {
        if (todoMapper.count() == 0) {
            todoMapper.insert(new Todo("MyBatisに保存されたTODO", false, "note1"));
            todoMapper.insert(new Todo("DB連携を理解する", true, "note2"));
        }
    }
}
