package com.electronicvotingsystem.exception;

public class ElectoralOfficerAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4761281991081770754L;

	

	public ElectoralOfficerAlreadyExistsException() {
	}

	public ElectoralOfficerAlreadyExistsException(String message) {
		super(message);
	}
}



