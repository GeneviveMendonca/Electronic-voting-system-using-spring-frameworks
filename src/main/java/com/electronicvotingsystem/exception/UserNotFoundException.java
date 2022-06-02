package com.electronicvotingsystem.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8201022799897707481L;

	
	public UserNotFoundException() {
	}

	public UserNotFoundException(String message) {
		super(message);
	}
}



