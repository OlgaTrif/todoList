package ru.trifonova.todolist.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trifonova.todolist.models.Project;
import ru.trifonova.todolist.repositories.ProjectRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Серверный класс для управления проектами.
 * Обеспечивает взаимодействие между контроллерами и репозиториями для выполнения операций над проектами.
 * */

@Service
@AllArgsConstructor
public class ProjectService {

    private ProjectRepository projectRepository;

    /**
     * Метод для получения списка всех проектов
     *
     * @return Список проектов.
     * */
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    /**
     * Метод для создания нового проекта.
     *
     * @param project Новый проект.
     * */
    public void createProject(Project project) {
        project.setCreatedAt(LocalDate.now());
        project.setClosed(false);
        project.setClosedAt(null);
        projectRepository.save(project);
    }

    /**
     * Метод для получения проекта по уникальному идентификатору
     *
     * @param id уникальный идентификатор.
     * @return Проект с указанным идентификатором.
     * */
    public Project getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    /**
     * Метод для обновления существующего проекта.
     *
     * @param project Проект, который нужно изменить.
     * */
    public void updateProject(Project project) {
        projectRepository.update(project);
    }

    /**
     * Метод для удаления существующего проекта.
     *
     * @param id Идентификатор проекта, который нужно удалить.
     * */
    public void deleteProject(Long id) {
        projectRepository.delete(id);
    }

    /**
     * Метод для отметки проекта как закрытого/завершённого.
     *
     * @param id Идентификатор проекта, который нужно отметить.
     * */
    public void closeProject(Long id) {
        Project project = projectRepository.findById(id);
        if (project != null) {
            project.setClosed(true);
            project.setClosedAt(LocalDate.now());
            projectRepository.update(project);
        }
    }
}
