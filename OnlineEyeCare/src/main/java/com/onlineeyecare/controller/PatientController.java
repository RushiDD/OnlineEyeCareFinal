package com.onlineeyecare.controller;

import java.util.List;

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

import com.onlineeyecare.dto.Patient;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.service.IPatientService;

@RestController
@RequestMapping("/v1/patient")
public class PatientController {
	
	Log logger = LogFactory.getLog(PatientController.class);
		
		@Autowired
		IPatientService patientRepo;
		   
		@PostMapping("/addpatient")
		public Patient additionofPatient(@RequestBody Patient patient)
		{
			logger.info("addpatient successfully");
			return patientRepo.addPatient(patient);
		}
		
		@PostMapping("/addpatients")
		public List<Patient> addPatient(@RequestBody List<Patient> patient){
			List<Patient> lc= patientRepo.addPatients(patient);
			logger.info("addpatients successfully");
			return lc;
			
		}
				
		@PutMapping("/updatepatient")
		public Patient updatepatient(@RequestBody Patient patient)
		{
			logger.info("updatepatient successfully");
			return patientRepo.updatePatient(patient);
		}
				
		@DeleteMapping("/delete/{id}")
		public Patient deletePatient(@PathVariable int id) throws ResourceNotFoundException
		{
			logger.info("deleted successfully");
			return patientRepo.deletePatient(id);
		}
		
		@GetMapping("/viewpatientlist")
		public List<Patient>listpatientlist()
		{
			logger.info("viewpatientlist successfully");
			return patientRepo.viewPatientList();
		}
			
		@GetMapping("/viewpatient/{id}")
		public Patient viewPatient(@PathVariable int id) throws ResourceNotFoundException
		{
			logger.info("viewpatientbyId successfully");
			return patientRepo.viewPatient(id);
		}		
}

