package com.onlineeyecare.dto;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Patient {

	@Id
	private int patientId;
	private String patientName;
	private int patientAge;
	private long patientMobile;
	private String patientEmail;
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate patientDOB;
	private String patientUserName;
	private String patientPassword;
	private String address;
	
	@OneToMany(mappedBy="patient_Id")
	private List<Appointment> appointment;
	
	public Patient() {
		super();
	}

	
	public Patient(int patientId, String patientName, int patientAge, long patientMobile, String patientEmail,
			LocalDate patientDOB, String patientUserName, String patientPassword, String address) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientDOB = patientDOB;
		this.patientUserName = patientUserName;
		this.patientPassword = patientPassword;
		this.address = address;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public String getPatientName() {
		return patientName;
	}
	
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	
	public int getPatientAge() {
		return patientAge;
	}
	
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	
	public long getPatientMobile() {
		return patientMobile;
	}
	
	public void setPatientMobile(long patientMobile) {
		this.patientMobile = patientMobile;
	}

	public String  getPatientEmail() {
		return patientEmail;
	}
	
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	
	public LocalDate getPatientDOB() {
		return patientDOB;
	}

	public void setPatientDOB(LocalDate patientDOB) {
		this.patientDOB = patientDOB;
	}
	
	public String getPatientUserName() {
		return patientUserName;
	}
	
	public void setPatientUserName(String patientUserName) {
		this.patientUserName = patientUserName;
	}
	
	public String getPatientPassword() {
		return patientPassword;
	}
	
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientAge=" + patientAge
				+ ", patientMobile=" + patientMobile + ", patientEmail=" + patientEmail + ", patientDOB=" + patientDOB
				+ ", patientUserName=" + patientUserName + ", patientPassword=" + patientPassword + ", address="
				+ address + "]";
	}

	public Patient get(int i) {

		return null;
	}
	
}