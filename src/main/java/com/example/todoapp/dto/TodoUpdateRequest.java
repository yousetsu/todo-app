package com.example.todoapp.dto;

import jakarta.validation.constraints.NotBlank;

// postgre ins start
public class TodoUpdateRequest {

    @NotBlank
    private String title;

    private boolean completed;

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
}
// postgre ins end