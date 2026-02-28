package com.example.todoapp.dto;

import jakarta.validation.constraints.NotBlank;

public class TodoCreateRequest {

    @NotBlank
    private String title;
    private String note;
    public String getTitle() {
        return title;
    }
    public String getNote() {
        return note;
    }

    // ★これが必要
    public void setTitle(String title) {
        this.title = title;
    }

    public void setNote(String note) {this.note = note;}
}