package com.user.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionalHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails>handelResourceNotFoundException( ResourceNotFoundException exception,WebRequest webRequest){
		ErrorDetails errorDetails =new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"USER_NOT_FOUND"
				); 
		return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails>handelEmailAlreadyExistException( EmailAlreadyExistsException exception,WebRequest webRequest){
		ErrorDetails errorDetails =new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"USER_EMAIL_ALRADY_EXIST"
				); 
		return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails>handelGlobalException(Exception exception,WebRequest webRequest){
		ErrorDetails errorDetails =new ErrorDetails(
				LocalDateTime.now(),
				exception.getMessage(),
				webRequest.getDescription(false),
				"INTERNAL SERVER ERROR"
				); 
		return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

}
