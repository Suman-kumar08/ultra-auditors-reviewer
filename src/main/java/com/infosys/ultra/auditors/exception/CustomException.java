package com.infosys.ultra.auditors.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

	public final ResponseEntity<Object> handleAllException(Exception ex , WebRequest wb){
		ErrorMessage errormessage = new ErrorMessage(new Date(),ex.getMessage(),wb.getDescription(true));
		return new ResponseEntity<Object>(errormessage,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
}
