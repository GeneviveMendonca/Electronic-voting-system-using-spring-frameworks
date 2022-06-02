package com.electronicvotingsystem.exception;

public class VoterAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8400408927970006550L;


	public VoterAlreadyExistsException() {
	}

	public VoterAlreadyExistsException(String message) {
		super(message);
	}
}



