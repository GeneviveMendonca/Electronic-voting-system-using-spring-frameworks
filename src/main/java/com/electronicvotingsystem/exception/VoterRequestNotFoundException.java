package com.electronicvotingsystem.exception;

public class VoterRequestNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8022014790957841576L;
	

	public VoterRequestNotFoundException() {
	}

	public VoterRequestNotFoundException(String message) {
		super(message);
	}
}



