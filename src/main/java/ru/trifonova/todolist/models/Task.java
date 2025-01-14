package ru.trifonova.todolist.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Класс, представляющий модель задачи.
 * Используется для хранения информации о задаче
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;
    private Long projectId;
    private String title;
    private String description;
    private LocalDate createdAt;
    private boolean completed;
    private LocalDate completedAt;
}