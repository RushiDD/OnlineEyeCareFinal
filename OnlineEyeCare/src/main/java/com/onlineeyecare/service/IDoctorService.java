package com.onlineeyecare.service;

import java.util.List;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;

public interface IDoctorService {

	Doctor addDoctor(Doctor doctor);
	public Doctor viewDoctor(int doctorId)throws DoctorIdNotFoundException;
	public List<Doctor> viewDoctorsList();
	public TestModule createTest(TestModule test);
	public Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException;
	Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException;
	List<Appointment> viewAllAppointments();
	
}
