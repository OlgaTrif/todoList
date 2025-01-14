package ru.trifonova.todolist.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.trifonova.todolist.config.DatabaseConfig;
import ru.trifonova.todolist.models.Task;

import java.util.List;

/**
 * Репозиторий для взаимодействия с сущностью Task и БД.
 * Используется для выполнения CRUD-операций с задачами.
 * */

@Repository
public class TaskRepository {

    private JdbcTemplate jdbcTemplate;

    private String findAllTasksSql;
    private String findTasksByIdSql;
    private String saveTaskSql;
    private String updateTaskSql;
    private String deleteTaskSql;

    /**
     * Конструктор класса.
     * Инициализирует JdbcTemplate и SQL-запросы из объекта DatabaseConfig
     *
     * @param jdbcTemplate Объект JdbcTemplate для выполнения SQL-запросов
     * @param databaseConfig Конфигурационный объект для хранения SQL-запросов.
     * */
    public TaskRepository(JdbcTemplate jdbcTemplate, DatabaseConfig databaseConfig) {
        this.jdbcTemplate = jdbcTemplate;
        this.findAllTasksSql = databaseConfig.getFindAllTasksSql();
        this.findTasksByIdSql = databaseConfig.getFindTaskByIdSql();
        this.saveTaskSql = databaseConfig.getSaveTaskSql();
        this.updateTaskSql = databaseConfig.getUpdateTaskSql();
        this.deleteTaskSql = databaseConfig.getDeleteTaskSql();
    }

    /**
     * Метод для получения списка всех задач из БД
     *
     * @return список задач
     * */
    public List<Task> findAll(){
        return jdbcTemplate.query(findAllTasksSql, new TaskRowMapper());
    }

    /**
     * Метод для нахождения задачи по её уникальному номеру
     *
     * @param id Уникальный идентификатор задачи
     * @return Задача с уникальным идентификатором
     * */
    public Task findById(Long id){
        return jdbcTemplate.queryForObject(findTasksByIdSql, new TaskRowMapper());
    }

    /**
     * Метод для сохранения новой задачи в БД
     *
     * @param task Задача для сохранения
     * */
    public void save(Task task){
        jdbcTemplate.update(saveTaskSql, task.getTitle(), task.getDescription(), task.getCreatedAt(),
                task.isCompleted(),task.getCompletedAt());
    }

    /**
     * Метод для обновления существующей задачи в БД
     *
     * @param task Задача для обновления
     * */
    public void update(Task task){
        jdbcTemplate.update(updateTaskSql, task.getTitle(), task.getDescription(), task.getCreatedAt(),
                task.isCompleted(),task.getCompletedAt(), task.getId());
    }

    /**
     * Метод для удаления задачи из БД
     *
     * @param id Идентификатор задачи для удаления
     * */
    public void delete(Long id){
        jdbcTemplate.update(deleteTaskSql, id);
    }
}
