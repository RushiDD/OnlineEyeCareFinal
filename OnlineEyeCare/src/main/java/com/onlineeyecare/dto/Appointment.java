package com.onlineeyecare.dto;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

	/*
	  It is a entity class that provides the details of the appointment 
	*/

@Entity
public class Appointment {

	@Id
	private Integer appointmentId;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateOfAppointment;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern="hh:mm:ss a")
	LocalTime timeOfAppointment;
	Double consultationFee;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="doctor_Id")
	Doctor doctor_Id;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="patient_Id")
	@JsonIgnore
	Patient patient_Id;
	
	/*
	  It is used to initialize the empty constructor	
	*/
	
	public Appointment() {
		super();
	}
	
	/*
	  It is used to initialize the parameterized constructor
	*/
	
	public Appointment(Integer appointmentId, LocalDate dateOfAppointment, LocalTime timeOfAppointment,
			Double consultationFee, Doctor doctorId, Patient patientId) {
		super();
		this.appointmentId = appointmentId;
		this.dateOfAppointment = dateOfAppointment;
		this.timeOfAppointment = timeOfAppointment;
		this.consultationFee = consultationFee;
		this.doctor_Id = doctorId;
		this.patient_Id = patientId;
	}
	
	/*
	  It is used to get the appointment Id by getter method
	*/

	public Integer getAppointmentId() {
		return appointmentId;
	}
	
	/*
	  It is used to set the appointment Id by setter method
	*/

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	/*
	  It is used to get the appointment date by getter method
	*/

	public LocalDate getDateOfAppointment() {
		return dateOfAppointment;
	}
	
	/*
	  It is used to set the appointment date by setter method
	*/

	public void setDateOfAppointment(LocalDate dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}
	
	/*
	  It is used to get the appointment time by getter method
	*/
	
	public LocalTime getTimeOfAppointment() {
		return timeOfAppointment;
	}
	
	/*
	  It is used to set the appointment time by setter method
	*/

	public void setTimeOfAppointment(LocalTime timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}
	
	/*
	  It is used to get the consultant fee  by getter method
	*/

	public Double getConsultationFee() {
		return consultationFee;
	}
	
	/*
	  It is used to set the consultant fee by setter method
	*/

	public void setConsultationFee(Double consultationFee) {
		this.consultationFee = consultationFee;
	}

	public Doctor getDoctor_Id() {
		return doctor_Id;
	}

	public void setDoctor_Id(Doctor doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public Patient getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(Patient patient_Id) {
		this.patient_Id = patient_Id;
	}

	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", dateOfAppointment=" + dateOfAppointment
				+ ", timeOfAppointment=" + timeOfAppointment + ", consultationFee=" + consultationFee + ", doctor_Id="
				+ doctor_Id + ", patient_Id=" + patient_Id + "]";
	}

	
}
