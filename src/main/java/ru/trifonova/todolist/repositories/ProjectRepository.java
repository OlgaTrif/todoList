package ru.trifonova.todolist.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.trifonova.todolist.config.DatabaseConfig;
import ru.trifonova.todolist.models.Project;

import java.util.List;

/**
 * Репозиторий для взаимодействия с сущностью Project и БД.
 * Используется для выполнения CRUD-операций с задачами.
 * */

@Repository
public class ProjectRepository {

    private JdbcTemplate jdbcTemplate;

    private String findAllProjectsSql;
    private String findProjectByIdSql;
    private String saveProjectSql;
    private String updateProjectSql;
    private String deleteProjectSql;

    /**
     * Конструктор класса.
     * Инициализирует JdbcTemplate и SQL-запросы из объекта DatabaseConfig
     *
     * @param jdbcTemplate Объект JdbcTemplate для выполнения SQL-запросов
     * @param databaseConfig Конфигурационный объект для хранения SQL-запросов.
     * */
    public ProjectRepository(JdbcTemplate jdbcTemplate, DatabaseConfig databaseConfig) {
        this.jdbcTemplate = jdbcTemplate;
        this.findAllProjectsSql = databaseConfig.getFindAllProjectsSql();
        this.findProjectByIdSql = databaseConfig.getFindProjectByIdSql();
        this.saveProjectSql = databaseConfig.getSaveProjectSql();
        this.updateProjectSql = databaseConfig.getUpdateProjectSql();
        this.deleteProjectSql = databaseConfig.getDeleteProjectSql();
    }

    /**
     * Метод для получения списка всех проектов из БД
     *
     * @return список проектов
     * */
    public List<Project> findAll(){
        return jdbcTemplate.query(findAllProjectsSql, new ProjectRowMapper());
    }

    /**
     * Метод для нахождения проекта по его уникальному номеру
     *
     * @param id Уникальный идентификатор задачи
     * @return Проект с уникальным идентификатором
     * */
    public Project findById(Long id){
        return jdbcTemplate.queryForObject(findProjectByIdSql, new ProjectRowMapper());
    }

    /**
     * Метод для сохранения нового проекта в БД
     *
     * @param project Проект для сохранения
     * */
    public void save(Project project){
        jdbcTemplate.update(saveProjectSql, project.getTitle(), project.getDescription(), project.getCreatedAt(),
                project.isClosed(),project.getClosedAt());
    }

    /**
     * Метод для обновления существующего проекта в БД
     *
     * @param project Проект для обновления
     * */
    public void update(Project project){
        jdbcTemplate.update(updateProjectSql, project.getTitle(), project.getDescription(), project.getCreatedAt(),
                project.isClosed(),project.getClosedAt(), project.getId());
    }

    /**
     * Метод для удаления проекта из БД
     *
     * @param id Идентификатор проекта для удаления
     * */
    public void delete(Long id){
        jdbcTemplate.update(deleteProjectSql, id);
    }
}
