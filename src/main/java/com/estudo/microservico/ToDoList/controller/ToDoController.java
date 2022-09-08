package com.estudo.microservico.ToDoList.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudo.microservico.ToDoList.domain.TodoDomain;
import com.estudo.microservico.ToDoList.service.ConsultasService;


@RestController
@RequestMapping(value = "/ToDo")
public class ToDoController {
	
	@Autowired
	private ConsultasService service;
	
	@GetMapping(value= "/{id}")
	public ResponseEntity<TodoDomain> findById(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findByID(id));
		
	}
	@GetMapping(value= "/listar")
	public ResponseEntity<List<TodoDomain>> listar(){
		return ResponseEntity.ok().body(service.findByTodos());

	}
	
	@GetMapping(value= "/listar/{status}")
	public ResponseEntity<List<TodoDomain>> listarStatus(@PathVariable String status){
		boolean statusBoolean = status.equals("ativo");
		return ResponseEntity.ok().body(service.findByStatus(statusBoolean));

	}
	@PostMapping(value= "/create")
	public ResponseEntity<TodoDomain> create(@RequestBody TodoDomain payload){
		
		TodoDomain response = service.create(payload);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.getId()).toUri();
		
		return ResponseEntity.created(uri).body(response);

	}
	@DeleteMapping(value= "/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();

	}
	@PutMapping(value= "/update/{id}")
	public ResponseEntity<TodoDomain> update(@RequestBody TodoDomain payload, @PathVariable Integer id){
		return ResponseEntity.ok().body(service.update(id, payload));

	}

}
