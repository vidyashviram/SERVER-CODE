package com.mro.drc.workflow.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CustomException.class)
	public final ResponseEntity<Map<String,String>> handleAllExceptions(CustomException ex) {    
		Map<String,String> res=new HashMap<String, String>();
		CustomException exceptionResponse = new CustomException(ex.getMessage(), ex.getDetails());
		res.put("message", exceptionResponse.getMessage());
		res.put("details", exceptionResponse.getDetails());
		return new ResponseEntity<Map<String,String>>(res, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}