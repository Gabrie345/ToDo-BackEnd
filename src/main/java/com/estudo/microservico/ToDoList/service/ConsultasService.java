package com.estudo.microservico.ToDoList.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudo.microservico.ToDoList.domain.TodoDomain;
import com.estudo.microservico.ToDoList.repository.ToDoListRepository;
import com.estudo.microservico.ToDoList.service.exception.ObjectNotFoundException;



@Service
public class ConsultasService {
	
	@Autowired
	private ToDoListRepository repository;
	
	public TodoDomain findByID(Integer id){
		Optional<TodoDomain> response = repository.findById(id);
		return response.orElseThrow(() -> new ObjectNotFoundException("ID não encontrado:"+ id));
		
	}

	public List<TodoDomain> findByStatus(Boolean status) {
		
		List<TodoDomain> list = repository.findAll(); 
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).isFinalizado() == !status) {
				list.remove(i);
			}
		}
		return list;
	}

	public List<TodoDomain> findByTodos() {
		return repository.findAll();
	}

	public TodoDomain create(TodoDomain payload) {
		payload.setId(null);
		return repository.save(payload);
		
	}

	public void delete(Integer id) {
		repository.deleteById(id);
		return;
		
	}

	public TodoDomain update(Integer id, TodoDomain payload) {
		TodoDomain response = findByID(id);
		response.setDataParaFinalizar(payload.getDataParaFinalizar());
		response.setDescricao(payload.getDescricao());
		response.setFinalizado(payload.isFinalizado());
		response.setTitulo(payload.getTitulo());
		repository.save(response);
		return response;
	}
	

}
