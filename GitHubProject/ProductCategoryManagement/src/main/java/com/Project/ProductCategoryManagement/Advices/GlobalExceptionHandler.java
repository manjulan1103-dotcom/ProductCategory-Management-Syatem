package com.Project.ProductCategoryManagement.Advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Project.ProductCategoryManagement.service.Exception.EmptyListException;
import com.Project.ProductCategoryManagement.service.Exception.ResoureNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResoureNotFoundException.class)
	public ResponseEntity<String> handlerResourceNotFound(ResoureNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handlerInternalServer(ResoureNotFoundException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmptyListException.class)
	public ResponseEntity<String> handlerEmptyListNotFound(EmptyListException exception){
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}
	


}
