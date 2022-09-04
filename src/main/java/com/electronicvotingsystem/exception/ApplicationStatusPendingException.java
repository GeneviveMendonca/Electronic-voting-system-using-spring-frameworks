package com.electronicvotingsystem.exception;

public class ApplicationStatusPendingException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 632432802415360599L;

	public ApplicationStatusPendingException() {
	}

	public ApplicationStatusPendingException(String message) {
		super(message);
	}
}



