package com.onlineeyecare.exceptions;

public class PatientIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
		
	public PatientIdNotFoundException() {

	}
	
	public PatientIdNotFoundException(String message) {
		super(message);
	}
}
