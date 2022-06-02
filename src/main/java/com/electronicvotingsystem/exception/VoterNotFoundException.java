package com.electronicvotingsystem.exception;

public class VoterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6556924786172148055L;

	public VoterNotFoundException() {
	}

	public VoterNotFoundException(String message) {
		super(message);
	}
}



