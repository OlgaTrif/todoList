package ru.trifonova.todolist.extra;

public class Extra {
    //forms
    public static final String NEW_TASK_FORM_REQUEST = "Запрос на отображение формы создания новой задачи.";
    public static final String EDIT_TASK_REQUEST_FORM = "Запрос на отображение формы редактирования задачи: id =%d.";

    //requests
    public static final String TASKS_LIST_REQUEST = "Запрос на отображение списка задач.";
    public static final String NEW_TASK_REQUEST = "Запрос на создание новой задачи: title = %s.";
    public static final String EDIT_TASK_REQUEST = "Запрос на редактирование задачи: id = %d.";
    public static final String DELETE_TASK_REQUEST = "Запрос на удаление задачи: id = %d.";
    public static final String COMPLETE_TASK_REQUEST = "Запрос на отметку задачи id = %d как выполненной.";

    //result info
    public static final String TASK_CREATED_INFO = "Создана новая задача: id = %s.";
    public static final String TASK_UPDATED_INFO = "Задача id = %d успешно отредактирована.";
    public static final String TASK_DELETED_INFO = "Задача id = %d успешно удалена.";
    public static final String REQUEST_FROM_BD_INFO = "Получено %d задач из БД.";
    public static final String COMPLETE_TASK_INFO = "Задача с id = %d отмечана как выполненная.";

    //direct
    public static final String TASK = "task";
    public static final String TASKS = "tasks";
    public static final String TASK_LIST = "task-list";
    public static final String NEW_TASK = "new-task";
    public static final String EDIT_TASK = "edit-task";
    public static final String REDIRECT_TO_TASKS = "redirect:/tasks";
}
