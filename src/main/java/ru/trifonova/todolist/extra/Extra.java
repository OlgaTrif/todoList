package ru.trifonova.todolist.extra;

public class Extra {
    //forms
    public static final String NEW_PROJECT_FORM_REQUEST = "Запрос на отображение формы создания нового проекта.";
    public static final String EDIT_PROJECT_REQUEST_FORM = "Запрос на отображение формы редактирования проекта: id =%d.";

    public static final String NEW_TASK_FORM_REQUEST = "Запрос на отображение формы создания новой задачи.";
    public static final String EDIT_TASK_REQUEST_FORM = "Запрос на отображение формы редактирования задачи: id =%d.";

    //requests
    public static final String PROJECTS_LIST_REQUEST = "Запрос на отображение списка проектов.";
    public static final String NEW_PROJECT_REQUEST = "Запрос на создание нового проекта: title = %s.";
    public static final String EDIT_PROJECT_REQUEST = "Запрос на редактирование проекта: id = %d.";
    public static final String DELETE_PROJECT_REQUEST = "Запрос на удаление проекта: id = %d.";
    public static final String CLOSE_PROJECT_REQUEST = "Запрос на отметку проекта id = %d как закрытого.";

    public static final String TASKS_LIST_REQUEST = "Запрос на отображение списка задач.";
    public static final String NEW_TASK_REQUEST = "Запрос на создание новой задачи: title = %s.";
    public static final String EDIT_TASK_REQUEST = "Запрос на редактирование задачи: id = %d.";
    public static final String DELETE_TASK_REQUEST = "Запрос на удаление задачи: id = %d.";
    public static final String COMPLETE_TASK_REQUEST = "Запрос на отметку задачи id = %d как выполненной.";

    //result info
    public static final String REQUEST_PROJ_FROM_BD_INFO = "Получено %d проектов из БД.";
    public static final String CLOSE_PROJECT_INFO = "Проект с id = %d отмечен как закрытый.";
    public static final String PROJECT_CREATED_INFO = "Создан новый проект: title = %s.";
    public static final String PROJECT_UPDATED_INFO = "Проект id = %d успешно отредактирован.";
    public static final String PROJECT_DELETED_INFO = "Проект id = %d успешно удален.";

    public static final String TASK_CREATED_INFO = "Создана новая задача: title = %s.";
    public static final String TASK_UPDATED_INFO = "Задача id = %d успешно отредактирована.";
    public static final String TASK_DELETED_INFO = "Задача id = %d успешно удалена.";
    public static final String REQUEST_TASK_FROM_BD_INFO = "Получено %d задач из БД.";
    public static final String COMPLETE_TASK_INFO = "Задача с id = %d отмечена как выполненная.";

    //direct
    public static final String PROJECT = "project";
    public static final String PROJECTS = "projects";
    public static final String PROJECT_LIST = "project-list";
    public static final String NEW_PROJECT = "new-project";
    public static final String EDIT_PROJECT = "edit-project";
    public static final String REDIRECT_TO_PROJECTS = "redirect:/projects";

    public static final String TASK = "task";
    public static final String TASKS = "tasks";
    public static final String TASK_LIST = "task-list";
    public static final String NEW_TASK = "new-task";
    public static final String EDIT_TASK = "edit-task";
    public static final String REDIRECT_TO_TASKS = "redirect:/tasks";
}
