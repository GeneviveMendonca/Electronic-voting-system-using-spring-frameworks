package com.electronicvotingsystem.exception;

public class CandidateAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2846518909142671298L;

	public CandidateAlreadyExistsException() {
	}

	public CandidateAlreadyExistsException(String message) {
		super(message);
	}
}



