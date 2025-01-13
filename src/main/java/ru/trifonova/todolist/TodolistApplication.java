package ru.trifonova.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.trifonova.todolist.config.DatabaseConfig;

@SpringBootApplication
@EnableConfigurationProperties(DatabaseConfig.class)
//@SpringBootApplication(exclude = {DatabaseConfig.class})
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
