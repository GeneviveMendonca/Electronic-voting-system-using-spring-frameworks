package com.electronicvotingsystem.exception;

public class ElectionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3196021386402422805L;


	public ElectionNotFoundException() {
	}

	public ElectionNotFoundException(String message) {
		super(message);
	}
}



