package com.electronicvotingsystem.exception;

public class ScheduleAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1306157769950379297L;


	public ScheduleAlreadyExistsException() {
	}

	public ScheduleAlreadyExistsException(String message) {
		super(message);
	}
}



