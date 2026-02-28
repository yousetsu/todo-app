package com.example.todoapp.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private boolean completed;

    @Column(nullable = false)
    private String note;

    protected Todo() {
        // JPA用（必須）
    }

    public Todo(String title, boolean completed,String note) {
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

    public String getNote() {
        return note;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setNote(String note) {this.title = note;}
}
