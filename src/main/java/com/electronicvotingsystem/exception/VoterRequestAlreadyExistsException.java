package com.electronicvotingsystem.exception;

public class VoterRequestAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496618203289377503L;

	public VoterRequestAlreadyExistsException() {
	}

	public VoterRequestAlreadyExistsException(String message) {
		super(message);
	}
}



