package com.onlineeyecare.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Doctor {
	
	@Id
	@GeneratedValue
	public Integer doctorId;
	private String doctorName;
	private String doctorConsultationTime;
	private long doctorMobile;
	private String doctorEmail;
	private String doctorUsername;
	private String doctorPassword;
	private String doctorAddress;
	
	@OneToMany(cascade = CascadeType.ALL) 
	@JoinColumn(name = "doctorId")
	public List<TestModule> tests;


	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public String getDoctorConsultationTime() {
		return doctorConsultationTime;
	}

	
	public void setDoctorConsultationTime(String doctorConsultationTime) {
		this.doctorConsultationTime = doctorConsultationTime;
	}


	public long getDoctorMobile() {
		return doctorMobile;
	}

	public void setDoctorMobile(long doctorMobile) {
		this.doctorMobile = doctorMobile;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}


	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public String getDoctorUsername() {
		return doctorUsername;
	}

	public void setDoctorUsername(String doctorUsername) {
		this.doctorUsername = doctorUsername;
	}

	public String getDoctorPassword() {
		return doctorPassword;
	}

		public void setDoctorPassword(String doctorPassword) {
		this.doctorPassword = doctorPassword;
	}

	
	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public Doctor() {
		super();
	}

	public Doctor(Integer doctorId, String doctorName, String doctorConsultationTime, long doctorMobile,
			String doctorEmail, String doctorUsername, String doctorPassword, String doctorAddress, List<TestModule> tests) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorConsultationTime = doctorConsultationTime;
		this.doctorMobile = doctorMobile;
		this.doctorEmail = doctorEmail;
		this.doctorUsername = doctorUsername;
		this.doctorPassword = doctorPassword;
		this.doctorAddress = doctorAddress;
		this.tests = tests;
	}


}
