package com.electronicvotingsystem.exception;

public class PartyAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4782621680036106436L;



	public PartyAlreadyExistsException() {
	}

	public PartyAlreadyExistsException(String message) {
		super(message);
	}
}



