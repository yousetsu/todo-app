package com.example.todoapp.dto;

public class TodoResponse {

    private Long id;
    private String title;
    private boolean completed;
    private String note;

    public TodoResponse(Long id, String title, boolean completed,String note) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public String getNote() {return note;}

}
