package com.example.todoapp.dto;
import jakarta.validation.constraints.NotBlank;

// postgre ins start
public class TodoUpdateRequest {

    @NotBlank
    private String title;
    private String note;

    private boolean completed;

    public String getTitle() {
        return title;
    }

    public String getNote() {
        return note;
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

    public void setNote(String note) {
        this.note = note;
    }
}
// postgre ins end