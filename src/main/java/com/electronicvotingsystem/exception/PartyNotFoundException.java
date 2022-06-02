package com.electronicvotingsystem.exception;

public class PartyNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7581164399025851182L;

	
	public PartyNotFoundException() {
	}

	public PartyNotFoundException(String message) {
		super(message);
	}
}



