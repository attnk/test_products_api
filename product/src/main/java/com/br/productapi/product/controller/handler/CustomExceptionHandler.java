package com.br.productapi.product.controller.handler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.br.productapi.product.exception.BusinessException;

@ControllerAdvice
public class CustomExceptionHandler {
	
	@ExceptionHandler(value = {BusinessException.class})
	public ResponseEntity<String> handleBusinessExceptions() {
		return new ResponseEntity<>(INTERNAL_SERVER_ERROR);
	}
	
}
