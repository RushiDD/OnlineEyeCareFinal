package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dao.IDoctorRepostiory;
import com.onlineeyecare.dao.ITestRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorRepostiory doctorRepository;
	
	@Autowired
	private ITestRepository testRepository;
	
	@Autowired
	private IAppointmentRepository appointmentrepo;
		
	@Override
	public Doctor addDoctor(Doctor doctor) {

		return doctorRepository.saveAndFlush(doctor);
	}
		
	@Override
	public Doctor deleteDoctor(int doctorId) throws DoctorIdNotFoundException {

	Optional<Doctor> result=doctorRepository.findById(doctorId);
		if(result.isPresent())
		{
			doctorRepository.deleteById(doctorId);
			return result.get();
		}
		else
		{
			throw new DoctorIdNotFoundException("please enter valid doctor id");
		}
	}

	@Override
	public List<Doctor> viewDoctorsList() {
		return doctorRepository.findAll();
	}

	@Override
	public Doctor viewDoctor(int doctorId) throws DoctorIdNotFoundException {
		java.util.Optional<Doctor> result = doctorRepository.findById(doctorId); 
		if(result.isPresent()) {
			doctorRepository.findById(doctorId);
			return result.get();
		}
		else {
			throw new DoctorIdNotFoundException("please enter valid doctor id");
		}
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) throws DoctorIdNotFoundException {

		Optional<Doctor> result=doctorRepository.findById(doctor.getDoctorId());
		if(result.isPresent())
		{
			return doctorRepository.saveAndFlush(doctor);
		}
		else
		{
			throw new DoctorIdNotFoundException("please enter valid doctor id");
		}
	}
	
	@Override
	public List<Appointment> viewAllAppointments() {

		return appointmentrepo.findAll();
	}
	
	@Override
	public TestModule createTest(TestModule test) {
		return testRepository.saveAndFlush(test);
		
	}
	

}
