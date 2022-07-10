package com.onlineeyecare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.ResourceNotFoundException;

@Service
public interface IPatientService {

	Patient addPatient(Patient tempPatient);
	
	Patient updatePatient(Patient patient);
	Patient deletePatient(int patientId) throws ResourceNotFoundException;
	List<Patient> viewPatientList();
	Patient viewPatient(int patientId) throws ResourceNotFoundException;
	Appointment bookAppointment(Appointment appointment);
	Appointment viewAppointmentDetail(int appointmentid);
	Report viewReport(int patientId);
	List<Patient> addPatients(List<Patient> patient);
	
}


