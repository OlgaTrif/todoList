package ru.trifonova.todolist.config;

/**
 * Конфигурационный класс для хранения SQL-запросов к БД.
 * Используется для вынесения запросов из кода в настройки приложения
 * */


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("database")
public class DatabaseConfig {
    //projects
    private String findAllProjectsSql;
    private String findProjectByIdSql;
    private String saveProjectSql;
    private String updateProjectSql;
    private String deleteProjectSql;
    //tasks
    private String findAllTasksSql;
    private String findTaskByIdSql;
    private String saveTaskSql;
    private String updateTaskSql;
    private String deleteTaskSql;
}
