package com.example.todoapp.mapper;

import com.example.todoapp.domain.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

/**
 * MyBatisマッパーインターフェース
 */
@Mapper
public interface TodoMapper {

    /**
     * すべてのTODOを取得
     */
    List<Todo> findAll();

    /**
     * IDでTODOを取得
     */
    Optional<Todo> findById(Long id);

    /**
     * TODOを保存（挿入）
     */
    void insert(Todo todo);

    /**
     * TODOを更新
     */
    void update(Todo todo);

    /**
     * IDでTODOを削除
     */
    void deleteById(Long id);

    /**
     * すべてのTODOを削除（テスト用）
     */
    void deleteAll();

    /**
     * TODOの総数を取得
     */
    long count();
}
