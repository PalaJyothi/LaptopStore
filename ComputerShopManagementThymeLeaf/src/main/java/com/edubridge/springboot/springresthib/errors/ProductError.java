package com.edubridge.springboot.springresthib.errors;

public class ProductError {
	

	//fields
	int status;
	String message;
	Long timeStamp;
	
	//generate constructor
	public ProductError()
	{
		
	}
	
	//generate constructor using fields
	public ProductError(int status, String message, Long timeStamp) {
		
		this.status = status;
		this.message = message;
		this.timeStamp = timeStamp;
		
	}
	//generate getters and setters

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

}
