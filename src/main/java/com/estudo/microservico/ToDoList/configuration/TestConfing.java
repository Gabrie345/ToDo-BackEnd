package com.estudo.microservico.ToDoList.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudo.microservico.ToDoList.service.ToDoService;

@Configuration
@Profile("Test")
public class TestConfing {

	@Autowired
	private ToDoService service;

    @Bean
    boolean instancia() {
        this.service.instanciaBaseDeDados();
        return true;
    }
}
