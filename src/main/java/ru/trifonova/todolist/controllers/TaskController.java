package ru.trifonova.todolist.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.trifonova.todolist.models.Task;
import ru.trifonova.todolist.services.TaskService;

import java.util.List;

import static ru.trifonova.todolist.extra.Extra.*;

/**
 * Контроллер для управления веб-интерфейсом задач в приложении
 * */

@Controller
@Slf4j
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    /**
     * Метод для отображения списка задач
     *
     * @param model объект Model для передачи данных в представление
     * @return Имя представления для отображения списка задач
     * */

    @GetMapping
    public String showTasks(Model model) {
        log.info(TASKS_LIST_REQUEST);
        List<Task> tasksList = taskService.getAllTasks();
        log.info(String.format(REQUEST_FROM_BD_INFO, tasksList.size()));
        model.addAttribute(TASKS, tasksList);
        return TASK_LIST;
    }

    /**
     * Метод для отображения формы создания новой задачи
     *
     * @param model объект Model для передачи данных в представление
     * @return Имя представления для создания новой задачи
     * */

    @GetMapping("/new")
    public String createTask(Model model) {
        log.info(NEW_TASK_FORM_REQUEST);
        model.addAttribute(TASK, new Task());
        return NEW_TASK;
    }

    /**
     * Метод для обработки запроса на создание новой задачи
     *
     * @param task создаваемая задача
     * @return Редирект на страницу списка задач после создания задачи
     * */

    @PostMapping
    public String createTask(Task task) {
        log.info(String.format(NEW_TASK_REQUEST, task.getTitle()));
        taskService.createTask(task);
        log.info(String.format(TASK_CREATED_INFO, task.getTitle()));
        return REDIRECT_TO_TASKS;
    }

    /**
     * Метод для отображения формы редактирования задачи
     *
     * @param id уникальный номер задачи для редактирования
     * @param model объект Model для передачи данных в представление
     * @return Имя представления для редактирования задачи
     * */

    @GetMapping("/{id}/edit")
    public String showEditTaskForm(@PathVariable("id") Long id, Model model) {
        log.info(String.format(EDIT_TASK_REQUEST_FORM, id));
        Task task = taskService.getTaskById(id);
        model.addAttribute("task", task);
        return EDIT_TASK;
    }

    /**
     * Метод для обработки запроса на редактирование задачи
     *
     * @param id уникальный номер задачи для редактирования
     * @param editTask задача с обновленными данными
     * @return Редирект на страницу списка задач после создания задачи
     * */

    @PostMapping("/{id}/edit")
    public String editTask(@PathVariable("id") Long id, @ModelAttribute Task editTask) {
        log.info(String.format(EDIT_TASK_REQUEST, id));
        Task task = taskService.getTaskById(id);
        task.setTitle(editTask.getTitle());
        task.setProjectId(editTask.getProjectId());
        task.setDescription(editTask.getDescription());
        task.setCompleted(editTask.isCompleted());
        task.setCompletedAt(editTask.getCompletedAt());
        taskService.updateTask(task);
        log.info(String.format(TASK_UPDATED_INFO, id));
        return REDIRECT_TO_TASKS;
    }

    /**
     * Метод для обработки запроса на удаление задачи
     *
     * @param id уникальный номер задачи для удаления
     * @return Редирект на страницу списка задач после создания задачи
     * */

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable("id") Long id) {
        log.info(String.format(DELETE_TASK_REQUEST, id));
        taskService.deleteTask(id);
        log.info(String.format(TASK_DELETED_INFO,id));
        return REDIRECT_TO_TASKS;
    }

    /**
     * Метод для обработки запроса на отметку задачи как выполненной
     *
     * @param id уникальный номер задачи для удаления
     * @return Редирект на страницу списка задач после создания задачи
     * */

    @PostMapping("/{id}/complete")
    public String completeTask(@PathVariable("id") Long id) {
        log.info(String.format(COMPLETE_TASK_REQUEST, id));
        taskService.completeTask(id);
        log.info(String.format(COMPLETE_TASK_INFO, id));
        return REDIRECT_TO_TASKS;
    }
}
