package ru.vsu.cs.v72.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.cs.v72.Task.service.PlayerService;

import java.io.IOException;

@SpringBootApplication
public class TaskPlayersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskPlayersApplication.class, args);
	}
}
