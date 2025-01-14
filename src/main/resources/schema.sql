CREATE TABLE if NOT EXISTS database.tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    project_id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    createdAt DATE NOT NULL,
    completed BOOLEAN NOT NULL,
    completedAt DATE
    );
CREATE INDEX `task_idx` ON database.tasks (`id`);

CREATE TABLE if NOT EXISTS database.projects (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    createdAt DATE NOT NULL,
    closed BOOLEAN NOT NULL,
    closedAt DATE
    );
CREATE INDEX `project_idx` ON database.projects (`id`);
ALTER TABLE database.tasks ADD CONSTRAINT `task_to_project` FOREIGN KEY (`project_id`)
REFERENCES database.projects (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

-- insert into projects
INSERT INTO database.projects (title, description, createdAt, closed, closedAt)
VALUES ('Проект 1', 'Описание проекта 1', CURDATE(), 0, NULL);

INSERT INTO database.projects (title, description, createdAt, closed, closedAt)
VALUES ('Проект 2', 'Описание проекта 2', CURDATE(), 0, NULL);

INSERT INTO database.projects (title, description, createdAt, closed, closedAt)
VALUES ('Проект 3', 'Описание проекта 3', CURDATE(), 1, CURDATE());

select * from database.projects;

-- insert into tasks
INSERT INTO database.tasks (project_id, title, description, createdAt, completed, completedAt)
VALUES(1, 'Задача 1', 'Описание задачи 1', CURDATE(), 0, NULL);

INSERT INTO database.tasks (project_id, title, description, createdAt, completed, completedAt)
VALUES(2, 'Задача 2', 'Описание задачи 2', CURDATE(), 0, NULL);

INSERT INTO database.tasks (project_id, title, description, createdAt, completed, completedAt)
VALUES(3, 'Задача 3', 'Описание задачи 3', CURDATE(), 1, CURDATE());

INSERT INTO database.tasks (project_id, title, description, createdAt, completed, completedAt)
VALUES(1, 'Задача 4', 'Описание задачи 4', CURDATE(), 1, CURDATE());

select * from database.tasks;