package com.onlineeyecare.controller;
import java.util.*;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Appointment;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
import com.onlineeyecare.service.IAppointmentService;
import com.onlineeyecare.service.IDoctorService;
import com.onlineeyecare.service.ITestService;

@RestController
@RequestMapping("/onlineeyeclinic")
public class DoctorController {
	
	Log logger = LogFactory.getLog(DoctorController.class);
	
	  @Autowired
		IDoctorService doctorService;
	  
	  @Autowired
		ITestService testService;
	 
	  @Autowired
	  IAppointmentService appointmentService;
	  
	  /*
	   		addDoctor() -it is used to add Doctor into Doctor table
	  */
	  
	  @PostMapping("/adddoctor")
	  public Doctor addDoctor(@Valid @RequestBody Doctor doctor)
	  {
		  
	  	return doctorService.addDoctor(doctor);
	  }
	
	   /*
	    viewDoctorsList() - To display all the doctors details
	   */
	  
	  @GetMapping("/viewdoctorslist")
	  public List<Doctor>viewDoctorsList()
	  {
		  logger.info("viewdoctorslist successfully");
	  	return doctorService.viewDoctorsList();
	  }
	
		/* viewDoctor() - To display the doctor by Id  */
		
	
		@GetMapping("/viewdoctor/{id}")
		public Doctor viewDoctor(@PathVariable int id) throws DoctorIdNotFoundException
		{
			 logger.info("viewdoctor successfully");
			return doctorService.viewDoctor(id);
		}
	 
		/* deleteDoctor() -It is used to remove doctor by Id */
		
		@DeleteMapping("/deletedoctor/{id}")
		public Doctor deleteDoctor(@PathVariable int id) throws DoctorIdNotFoundException
		{
			  logger.info("deletedoctor successfully");
	
			return doctorService.deleteDoctor(id);
		}
		
		/* updateDoctor()- It is used to update doctor details into doctor table. */
		
		@PutMapping("/updatedoctor")
		public Doctor updateDoctor(@RequestBody Doctor doctor) throws DoctorIdNotFoundException
		{
			 logger.info("updatedoctor successfully");
			return doctorService.updateDoctor(doctor);
		}
		
		/* createTest()- It is used to add Test into test table */
		
		
		@PostMapping("/createTest")
		public TestModule createTest(@RequestBody TestModule test) {
			logger.info("createTest successfully");
			return testService.addTest(test);
		}
		
		/* viewAppointments() - To display all the appointments */
		
		@GetMapping("/viewAppointments")
		public List<Appointment> viewAllAppointments() {
			logger.info("viewAppointments successfully");
			return appointmentService.viewAllAppointments();
		}
	
}