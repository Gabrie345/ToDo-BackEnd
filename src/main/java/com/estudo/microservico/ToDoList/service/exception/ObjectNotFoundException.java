package com.estudo.microservico.ToDoList.service.exception;

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -6693897915555383812L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjectNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	


}
