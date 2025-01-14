package ru.trifonova.todolist.repositories;

import org.springframework.jdbc.core.RowMapper;
import ru.trifonova.todolist.models.Project;
import ru.trifonova.todolist.models.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Реализация интерфейса RowMapper для маппинга строк из ResultSet в объект Project.
 * Используется при выполнении SQL-запросов с использованием JdbcTemplate.
 * */

public class ProjectRowMapper implements RowMapper<Project> {

    /**
     * Метод для маппинга строк из ResultSet в объект Project.
     *
     * @param rs ResultSet представляющий строку результата SQL-запроса
     * @param rowNum номер текущей строки в результате запроса
     * @return объект Project, маппированный из ResultSet
     * @throws SQLException при ошибке с ResultSe
     * */
    @Override
    public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
        Project project = new Project();
        project.setId(rs.getLong("id"));
        project.setTitle(rs.getString("title"));
        project.setDescription(rs.getString("description"));
        project.setCreatedAt(rs.getObject("createdAt", LocalDate.class));
        project.setClosedAt(rs.getObject("closedAt", LocalDate.class));
        project.setClosed(rs.getBoolean("closed"));
        return project;
    }
}
