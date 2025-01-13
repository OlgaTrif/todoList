CREATE TABLE if NOT EXISTS tasks (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    createdAt DATE NOT NULL,
    completed BOOLEAN NOT NULL,
    completedAt DATE
    );

--Заполним таблицу тестовыми значениями
INSERT INTO tasks (title, description, createdAt, completed, completedAt)
VALUES('Задача 1', 'Тестовая задача 1', CURDATE(), 0, NULL)

INSERT INTO tasks (title, description, createdAt, completed, completedAt)
VALUES('Задача 2', 'Тестовая задача 2', CURDATE(), 0, NULL)

INSERT INTO tasks (title, description, createdAt, completed, completedAt)
VALUES('Задача 3', 'Тестовая задача 3', CURDATE(), 1, CURDATE())

INSERT INTO tasks (title, description, createdAt, completed, completedAt)
VALUES('Задача 4', 'Тестовая задача 4', CURDATE(), 1, CURDATE())