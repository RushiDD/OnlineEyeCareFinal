package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.IAppointmentRepository;
import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.exceptions.ResourceNotFoundException;

	/*
	  It is a test service implementation class that defines the methods
      mentioned in its interface	
	*/

@Service
public class AppointmentServiceImpl implements IAppointmentService{
	
	@Autowired
	IAppointmentRepository appointmentRepo;

	/*
	  It is used to book appointment into appointment table
	*/
	
	@Override
	public Appointment bookAppointment(Appointment appointment) {
		
		
		return appointmentRepo.save(appointment);
	}
	
	/*
	  It is used to update appointment details into appointment table
	*/

	@Override
	public Appointment updateAppointment(Appointment appointment) throws ResourceNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointment.getAppointmentId());
		if(result.isPresent())
		{
			return appointmentRepo.save(appointment);
		}
		else
		{
			throw new ResourceNotFoundException("Appointment Id is not present in database");
		}
	}
	
	/*
	  It is used to cancel appointment
	*/

	@Override
	public Appointment cancelAppointment(int appointmentId) throws ResourceNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointmentId);
		if(result.isPresent())
		{
			appointmentRepo.deleteById(appointmentId);
			return result.get();
		}
		else
		{
			throw new ResourceNotFoundException("please enter valid appointment id");
		}
		
	}
	
	/*
	  To display the appointment by Id (Primary key)
	*/

	@Override
	public Appointment viewAppointment(int appointmentId) throws ResourceNotFoundException {
		
		Optional<Appointment> result=appointmentRepo.findById(appointmentId);
		if(result.isPresent())
		{
			appointmentRepo.findById(appointmentId);
			return result.get();
		}
		else
		{
			throw new ResourceNotFoundException("Appointment is not present with given Id");
		}
	}
	
	/*
	  To display all the appointments
	*/

	@Override
	public List<Appointment> viewAllAppointments() {
		
		return appointmentRepo.findAll();
	}
	
	/*
	  To display the appointment by date
	*/

	@Override
	public List<Appointment> viewAppointments(LocalDate date) {
	
		return appointmentRepo.findAll().stream().filter(app->(date.compareTo(app.getDateOfAppointment())==0)).collect(Collectors.toList());
	}

	@Override
	public Appointment bookAppointment(IAppointmentService tempAppointment) {

		return null;
	}
}
