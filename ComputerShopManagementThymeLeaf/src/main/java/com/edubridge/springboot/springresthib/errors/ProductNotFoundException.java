package com.edubridge.springboot.springresthib.errors;

public class ProductNotFoundException extends RuntimeException{
	
	public ProductNotFoundException(String message)
	{
		super(message);
	}

}
