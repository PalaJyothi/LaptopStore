package com.edubridge.springboot.springresthib.errors;

public class SellerNotFoundException extends RuntimeException{
	
	public SellerNotFoundException(String message)
	{
		super(message);
	}

}
