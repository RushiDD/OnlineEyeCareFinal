package com.onlineeyecare.exceptions;

public class AppointmentIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AppointmentIdNotFoundException() {
		super();
	}
		
	public AppointmentIdNotFoundException(String message) {
		super(message);
	}
}
