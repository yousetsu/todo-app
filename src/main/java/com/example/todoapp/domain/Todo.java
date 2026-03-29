package com.example.todoapp.domain;

import java.time.LocalDateTime;

/**
 * TODOドメインモデル
 * MyBatis用Pojoクラス
 */
public class Todo {

    private Long id;
    private String title;
    private boolean completed;
    private String note;
    // private LocalDateTime createdAt;
    // private LocalDateTime updatedAt;

    public Todo() {
        // デフォルトコンストラクタ
    }

    public Todo(String title, boolean completed, String note) {
        this.title = title;
        this.completed = completed;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    // public LocalDateTime getCreatedAt() {
    //     return createdAt;
    // }

    // public void setCreatedAt(LocalDateTime createdAt) {
    //     this.createdAt = createdAt;
    // }

    // public LocalDateTime getUpdatedAt() {
    //     return updatedAt;
    // }

    // public void setUpdatedAt(LocalDateTime updatedAt) {
    //     this.updatedAt = updatedAt;
    // }
}
