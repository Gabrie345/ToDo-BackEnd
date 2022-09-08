package com.estudo.microservico.ToDoList.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.microservico.ToDoList.domain.TodoDomain;
import com.estudo.microservico.ToDoList.repository.ToDoListRepository;

@Service
public class ToDoService {
	
	@Autowired
	private ToDoListRepository repository;
	
	public void instanciaBaseDeDados(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		TodoDomain t1 = new TodoDomain(null, "estudar", "estudar Java", LocalDateTime.parse("25/03/2022 10:40",formatter), false);
		TodoDomain t2 = new TodoDomain(null, "estudar", "estudar Angular", LocalDateTime.parse("23/07/2022 10:40",formatter), true);
		TodoDomain t3 = new TodoDomain(null, "estudar", "estudar Pt", LocalDateTime.parse("24/06/2022 10:40",formatter), false);
		TodoDomain t4 = new TodoDomain(null, "estudar", "estudar Ux", LocalDateTime.parse("28/05/2022 10:40",formatter), true);
		repository.saveAll(Arrays.asList(t1,t2,t3,t4));
	}

}
