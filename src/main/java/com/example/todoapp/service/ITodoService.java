package com.example.todoapp.service;

import com.example.todoapp.dto.TodoCreateRequest;
import com.example.todoapp.dto.TodoResponse;
import com.example.todoapp.dto.TodoUpdateRequest;

import java.util.List;

/**
 * TODOサービスのインターフェース
 */
public interface ITodoService {

    /**
     * すべてのTODOを取得
     */
    List<TodoResponse> findAll();

    /**
     * 新規TODOを作成
     */
    TodoResponse create(TodoCreateRequest request);

    /**
     * TODOを更新
     */
    TodoResponse update(Long id, TodoUpdateRequest request);

    /**
     * TODOを削除
     */
    void delete(Long id);

    /**
     * サンプルTODOを初期化（テスト用）
     */
    void createSampleTodosIfEmpty();
}
