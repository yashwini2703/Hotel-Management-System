package com.example.exceptionhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private String desc="description";
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,HttpStatus status,WebRequest request){
		Map<String,String> map=new HashMap<String,String>();
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldname=((FieldError) error).getField();
			String msg=error.getDefaultMessage();
			map.put(fieldname,msg);
		});
		
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException ex) {
		HttpHeaders header = new HttpHeaders();
		header.add(desc, "Trying to get Entity");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).headers(header).body(ex.getMessage());
	}
	
	

}

