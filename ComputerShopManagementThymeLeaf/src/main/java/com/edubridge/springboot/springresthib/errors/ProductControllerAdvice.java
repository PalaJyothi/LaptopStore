package com.edubridge.springboot.springresthib.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<ProductError> handleException (ProductNotFoundException ex)
	{
		ProductError err = new ProductError();
		err.setStatus(HttpStatus.NOT_FOUND.value());
		err.setMessage(ex.getMessage());
		err.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<ProductError> (err, HttpStatus.NOT_FOUND);
	}

}
