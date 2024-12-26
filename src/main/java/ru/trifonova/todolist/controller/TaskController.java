package ru.trifonova.todolist.controller;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.trifonova.todolist.model.Task;
import ru.trifonova.todolist.service.TaskService;

import java.util.List;

import static ru.trifonova.todolist.extra.Extra.*;

/**
 * Контроллер для управления веб-интерфейсом задач в приложении
 * */

@Controller
@Log
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private TaskService taskService;

    /**
     * Метод для отображения списка задач
     *
     * @param model объект Model для передачи данных в представление.
     * @return Имя представления для отображения списка задач
     * */

    @GetMapping
    public String showTasks(Model model) {
        log.info(TASKS_LIST_REQUEST);
        List<Task> tasksList = taskService.getAllTasks();
        log.info(String.format(REQUEST_FROM_BD, tasksList.size()));
        model.addAttribute(TASKS, tasksList);
        return TASK_LIST;
    }

    /**
     * Метод для отображения формы создания новой задачи
     *
     * @param model объект Model для передачи данных в представление.
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
     * @param task создавыаемая задача
     * @return Редирект на страницу списка задач после создания задачи
     * */

    @PostMapping
    public String createTask(Task task){

    }

}
