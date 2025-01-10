package ru.trifonova.todolist.config;

/**
 * Конфигурационный класс для хранения SQL-запросов к БД.
 * Используется для вынесения запросов из кода в настройки приложения
 * */


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties
public class DatabaseConfig {
    private String findAllTasksSql;
    private String findTaskByIdSql;
    private String saveTaskSql;
    private String updateTaskSql;
    private String deleteTaskSql;

    //TODO: урок 6 41:25
}
