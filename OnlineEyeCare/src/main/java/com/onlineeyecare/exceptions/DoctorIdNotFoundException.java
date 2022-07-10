package com.onlineeyecare.exceptions;

public class DoctorIdNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DoctorIdNotFoundException(){
		super();
	}
	public DoctorIdNotFoundException(String message) {
		super(message);
	}
}
