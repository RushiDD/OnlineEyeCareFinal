package com.onlineeyecare.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.service.IAppointmentService;

	/*
	 It is a Controller class is used for the data flow into model object and 
	 updates the view whenever data changes
	*/

@RestController
@RequestMapping("/v1")
public class AppointmentController {
	
	Log logger = LogFactory.getLog(AppointmentController.class);
	
	@Autowired
	IAppointmentService appointmentService;
	
	/*
	 To book the appointment
	 It returns appointment details  in database
	 It maps the HttpRequest body to a transfer or domain object
	*/

	@PostMapping("/bookappointment")
	public Appointment bookAppointment(@Valid @RequestBody Appointment appointment) {
		logger.info("Get bookappointment successfully");
		return appointmentService.bookAppointment(appointment);
	}
	
	/*
	 It is used to update appointment details into appointment table
	*/
	
	@PutMapping("/updateappointment/{id}")
	public Appointment updateAppointment(@RequestBody Appointment appointment) throws Throwable {
		logger.info("Get updateappointment successfully");
		return appointmentService.updateAppointment(appointment);
	}
	
	/*
	 It is used to cancel appointment by giving the Id
	*/

	@DeleteMapping("/cancelappointment/{id}")
	public Appointment cancelAppointment(@PathVariable int id) throws Throwable {
		logger.info("Get cancelappointment successfully");
		return appointmentService.cancelAppointment(id);
	}
	
	/*
	 To display all the appointments
	*/
	
	@GetMapping("/viewallappointments")
	public List<Appointment> listallappointments() {
		logger.info("Get viewallappointments successfully");
		return appointmentService.viewAllAppointments();
	}
	
	/*
	 To display the appointment by Id (Primary key)
	*/
	 
	@GetMapping("/viewappointment/{id}")
	public Appointment viewAppointment(@PathVariable int id) throws Throwable {
		logger.info("Get viewappointment successfully");
		return appointmentService.viewAppointment(id);
	}
	
	/*
	 To display the appointment by date
	*/
	
	@GetMapping("/viewallappointmentbydate")
	public List<Appointment> listallappointments(@RequestParam(value="date")@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)LocalDate date) {
		logger.info("Get viewallappointmentbydate successfully");
		return appointmentService.viewAppointments(date);
	}

}


