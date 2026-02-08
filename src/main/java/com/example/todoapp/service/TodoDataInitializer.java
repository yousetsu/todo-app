package com.example.todoapp.service;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoDataInitializer {

    @Bean
    ApplicationRunner init(TodoService todoService) {
        return args -> todoService.createSampleTodosIfEmpty();
    }
}
