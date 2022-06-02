package com.electronicvotingsystem.exception;

public class ElectionAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7113416298129467894L;

	



	public ElectionAlreadyExistsException() {
	}

	public ElectionAlreadyExistsException(String message) {
		super(message);
	}
}



