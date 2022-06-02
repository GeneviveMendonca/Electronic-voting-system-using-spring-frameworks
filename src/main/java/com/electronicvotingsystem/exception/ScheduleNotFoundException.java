package com.electronicvotingsystem.exception;

public class ScheduleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8765999424362627007L;

	
	public ScheduleNotFoundException() {
	}

	public ScheduleNotFoundException(String message) {
		super(message);
	}
}



