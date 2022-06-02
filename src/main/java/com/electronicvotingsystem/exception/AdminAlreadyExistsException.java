package com.electronicvotingsystem.exception;

public class AdminAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4160143266584293251L;

	public AdminAlreadyExistsException() {
	}

	public AdminAlreadyExistsException(String message) {
		super(message);
	}
}



