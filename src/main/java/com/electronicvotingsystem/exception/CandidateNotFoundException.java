package com.electronicvotingsystem.exception;

public class CandidateNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9112727252019489979L;

	
	public CandidateNotFoundException() {
	}

	public CandidateNotFoundException(String message) {
		super(message);
	}
}



