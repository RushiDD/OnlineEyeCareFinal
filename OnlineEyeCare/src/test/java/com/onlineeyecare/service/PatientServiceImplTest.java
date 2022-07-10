package com.onlineeyecare.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineeyecare.dto.Patient;

@SpringBootTest
class PatientServiceImplTest {

	@Autowired
	   private PatientServiceImpl patientservice;
	   @Test
	   public void addPatientTest() {
	    Patient tempPatient=new Patient(102,"Vishal", 39,8308619997l, "vishal@gmail.com",LocalDate.now(),"nvish@54","Vish54","Pune");
	     assertEquals(102,patientservice.addPatient(tempPatient).getPatientId());
	   }
	   
	   @Test
		void viewAllPatientTest()
		{
			assertEquals(101,patientservice.viewPatientList().get(0).getPatientId());
		}
}