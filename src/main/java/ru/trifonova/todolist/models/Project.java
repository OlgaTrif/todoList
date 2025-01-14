package ru.trifonova.todolist.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Класс, представляющий модель проекта.
 * Используется для хранения информации о проекте
 * */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;
    private String title;
    private String description;
    private LocalDate createdAt;
    private boolean closed;
    private LocalDate closedAt;
}
