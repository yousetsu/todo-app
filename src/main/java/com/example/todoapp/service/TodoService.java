package com.example.todoapp.service;

import com.example.todoapp.domain.Todo;
import com.example.todoapp.dto.TodoCreateRequest;
import com.example.todoapp.dto.TodoResponse;
// postgre ins start
import com.example.todoapp.dto.TodoUpdateRequest;
import org.springframework.transaction.annotation.Transactional;
// postgre ins end
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
/*
  1.todoRepository.findAll() がList を返す
  2.その List に対して .stream()
  3.map(...) で DTO へ変換
  4.toList() で List に戻す
 */
// postgre ins start
@Transactional(readOnly = true)
// postgre ins end
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
/* 同じ処理
//    List<Todo> todos = todoRepository.findAll();   // DBからTodoの一覧を取得
//
//    List<TodoResponse> responses = new java.util.ArrayList<>();
//    for (Todo todo : todos) {                      // 1件ずつ取り出す
//        responses.add(new TodoResponse(
//                todo.getId(),
//                todo.getTitle(),
//                todo.isCompleted()
//        ));
//    }
//    return responses;
 */
// postgre ins start
@Transactional
// postgre ins end
    public void createSampleTodosIfEmpty() {
        if (todoRepository.count() == 0) {
            todoRepository.save(new Todo("H2に保存されたTODO", false));
            todoRepository.save(new Todo("DB連携を理解する", true));
        }
    }
    // postgre ins start
    @Transactional
    // postgre ins end
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
   // postgre upd start
//    public Todo update(Long id, Todo request) {
//
//        Todo todo = todoRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));
//
//        todo.setTitle(request.getTitle());
//        todo.setCompleted(request.isCompleted());
//
//        return todoRepository.save(todo);
//    }
@Transactional
public TodoResponse update(Long id, TodoUpdateRequest request) {
    Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

    todo.setTitle(request.getTitle());
    todo.setCompleted(request.isCompleted());

    Todo saved = todoRepository.save(todo);

    return new TodoResponse(saved.getId(), saved.getTitle(), saved.isCompleted());
}
    // postgre upd end
    // postgre ins start
    @Transactional
    // postgre ins end
    public void delete(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo not found"));

        todoRepository.delete(todo);
    }

}
