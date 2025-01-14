package ru.trifonova.todolist.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.trifonova.todolist.models.Project;
import ru.trifonova.todolist.models.Task;
import ru.trifonova.todolist.services.ProjectService;

import java.util.List;

import static ru.trifonova.todolist.extra.Extra.*;

/**
 * Контроллер для управления веб-интерфейсом проектов в приложении
 * */

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectController {

    private ProjectService projectService;

    /**
     * Метод для отображения списка проектов
     *
     * @param model объект Model для передачи данных в представление
     * @return Имя представления для отображения списка проектов
     * */

    @GetMapping
    public String showProjects(Model model) {
        log.info(PROJECTS_LIST_REQUEST);
        List<Task> tasksList = projectService.getAllProjects();
        log.info(String.format(REQUEST_PROJ_FROM_BD_INFO, tasksList.size()));
        model.addAttribute(PROJECTS, tasksList);
        return PROJECT_LIST;
    }

    /**
     * Метод для отображения формы создания нового проекта
     *
     * @param model объект Model для передачи данных в представление
     * @return Имя представления для создания нового проекта
     * */

    @GetMapping("/new")
    public String createProject(Model model) {
        log.info(NEW_PROJECT_FORM_REQUEST);
        model.addAttribute(PROJECT, new Task());
        return NEW_PROJECT;
    }

    /**
     * Метод для обработки запроса на создание нового проекта
     *
     * @param project создаваемый проект
     * @return Редирект на страницу списка проектов после создания задачи
     * */

    @PostMapping
    public String createProject(Project project) {
        log.info(String.format(NEW_PROJECT_REQUEST, project.getTitle()));
        projectService.createProject(project);
        log.info(String.format(PROJECT_CREATED_INFO, project.getTitle()));
        return REDIRECT_TO_PROJECTS;
    }

    /**
     * Метод для отображения формы редактирования проекта
     *
     * @param id уникальный номер проекта для редактирования
     * @param model объект Model для передачи данных в представление
     * @return Имя представления для редактирования проекта
     * */

    @GetMapping("/{id}/edit")
    public String showEditTaskForm(@PathVariable("id") Long id, Model model) {
        log.info(String.format(EDIT_PROJECT_REQUEST_FORM, id));
        Project project = projectService.getProjectById(id);
        model.addAttribute(PROJECT, project);
        return EDIT_PROJECT;
    }

    /**
     * Метод для обработки запроса на редактирование проекта
     *
     * @param id уникальный номер проекта для редактирования
     * @param editProject проект с обновленными данными
     * @return Редирект на страницу списка проектов после создания задачи
     * */

    @PostMapping("/{id}/edit")
    public String editProject(@PathVariable("id") Long id, @ModelAttribute Project editProject) {
        log.info(String.format(EDIT_PROJECT_REQUEST, id));
        Project project = projectService.getProjectById(id);
        project.setTitle(editProject.getTitle());
        project.setDescription(editProject.getDescription());
        project.setClosed(editProject.isClosed());
        project.setClosedAt(editProject.getClosedAt());
        projectService.updateProject(project);
        log.info(String.format(PROJECT_UPDATED_INFO, id));
        return REDIRECT_TO_PROJECTS;
    }

    /**
     * Метод для обработки запроса на удаление проекта
     *
     * @param id уникальный номер проекта для удаления
     * @return Редирект на страницу списка проектов после создания проекта
     * */

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable("id") Long id) {
        log.info(String.format(DELETE_PROJECT_REQUEST, id));
        projectService.deleteProject(id);
        log.info(String.format(PROJECT_DELETED_INFO,id));
        return REDIRECT_TO_PROJECTS;
    }

    /**
     * Метод для обработки запроса на отметку проекта закрытым/завершённым
     *
     * @param id уникальный номер проекта для отметки
     * @return Редирект на страницу списка проектов после отметки проекта закрытым/завершённым
     * */

    @PostMapping("/{id}/complete")
    public String completeTask(@PathVariable("id") Long id) {
        log.info(String.format(CLOSE_PROJECT_REQUEST, id));
        projectService.closeProject(id);
        log.info(String.format(CLOSE_PROJECT_INFO, id));
        return REDIRECT_TO_PROJECTS;
    }
}

