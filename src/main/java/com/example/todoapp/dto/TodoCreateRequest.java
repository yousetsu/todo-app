package com.example.todoapp.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoCreateRequest {

    @NotBlank
    private String title;

    public String getTitle() {
        return title;
    }

    // ★これが必要
    public void setTitle(String title) {
        this.title = title;
    }
}