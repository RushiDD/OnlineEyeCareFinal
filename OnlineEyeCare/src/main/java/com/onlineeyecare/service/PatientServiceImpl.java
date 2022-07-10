package com.onlineeyecare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dao.IPatientRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import java.util.Optional;


@Service
public  class PatientServiceImpl implements IPatientService{
	
	@Autowired
	IPatientRepository patientRepo;
	
	@Autowired
	IAppointmentRepository appointmentRepo;
	
	@Override
	public Patient addPatient(Patient patient) {

		return patientRepo.saveAndFlush(patient);

	}
	
	@Override
	public Patient updatePatient(Patient patient) {

		return patientRepo.save(patient);
		
	}	
	
	@Override
	public Patient deletePatient(int patientId) throws ResourceNotFoundException {

	Optional<Patient> result=patientRepo.findById(patientId);
		if(result.isPresent())
		{
			patientRepo.deleteById(patientId);
			return  result.get();
		}
		else
		{
			throw new ResourceNotFoundException("please enter valid patient id");
		}
	}
	
	
	@Override
	public List<Patient> viewPatientList() {

		return patientRepo.findAll();
	}
	
	@Override
	public Patient viewPatient(int patientId) throws ResourceNotFoundException {

		java.util.Optional<Patient> result=patientRepo.findById(patientId);
		if(result.isPresent())
		{
			patientRepo.findById(patientId);
			return  result.get();
		}
		else
		{
			throw new ResourceNotFoundException("please enter valid patient id");
		}
	}

	@Override
	public List<Patient> addPatients(List<Patient> patient) {

		return patientRepo.saveAllAndFlush(patient);
	}

	@Override
	public Appointment bookAppointment(Appointment appointment) {

		return null;
	}

	@Override
	public Appointment viewAppointmentDetail(int appointmentid) {

		return null;
	}

	@Override
	public Report viewReport(int patientId) {

		return null;
	}
}


