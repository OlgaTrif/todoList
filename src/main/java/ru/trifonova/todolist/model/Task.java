package ru.trifonova.todolist.model;

public class Task {

    private Long id;
    private String title;

    public void setCompletedAt(Boolean completedAt) {
        this.completedAt = completedAt;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private String description;
    private Boolean completed;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public Boolean getCompletedAt() {
        return completedAt;
    }

    private Boolean completedAt;

    public String getTitle() {
        return title;
    }
}
