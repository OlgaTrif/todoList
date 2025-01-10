package ru.trifonova.todolist.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.trifonova.todolist.model.Task;
import ru.trifonova.todolist.repositories.TaskRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Серверный класс для управления задачами.
 * Обеспечивает взаимодействие между контроллерами и репозиториями для выполнения операций над задачами.
 * */

@Service
@AllArgsConstructor
public class TaskService {

    private TaskRepository taskRepository;

    /**
     * Метод для получения списка всех задач
     *
     * @return Список задач.
     * */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * Метод для получения задачи по уникальному идентификатору
     *
     * @param id уникальный идентификатор.
     * @return Задача с указанным идентификатором.
     * */
    public Task getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    /**
     * Метод для создания новой задачи.
     *
     * @param task Новая задача.
     * */
    public void createTask(Task task) {
        task.setCreateAt(LocalDate.now());
        task.setCompleted(false);
        task.setCompletedAt(null);
        taskRepository.save(task);
    }

    /**
     * Метод для обновления существующей задачи.
     *
     * @param task Задача, которую нужно изменить.
     * */
    public void updateTask(Task task) {
        taskRepository.update(task);
    }

    /**
     * Метод для удаления существующей задачи.
     *
     * @param id Задача, которую нужно удалить.
     * */
    public void deleteTask(Long id) {
        taskRepository.delete(id);
    }

    public void completeTask(Long id) {
        Task task = taskRepository.findById(id);
        if (task != null) {
            task.setCompleted(true);
            task.setCompletedAt(LocalDate.now());
            taskRepository.update(task);
        }
    }
}
