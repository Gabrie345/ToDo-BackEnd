package com.estudo.microservico.ToDoList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndToDoListApplication implements CommandLineRunner{

	
	
	public static void main(String[] args) {
		SpringApplication.run(BackEndToDoListApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
