package com.example.timeconversion.exception;

public class TimeInvalidException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TimeInvalidException(String message)
	{
		super(message);
	}

}
