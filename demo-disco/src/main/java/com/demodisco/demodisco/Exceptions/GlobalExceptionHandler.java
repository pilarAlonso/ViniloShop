package com.demodisco.demodisco.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NotFound.class)
	public ResponseEntity handleNotFound(Exception exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity handleBadRequest(Exception exception){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
	}
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity handleConflictException(Exception exception){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
	}
}
