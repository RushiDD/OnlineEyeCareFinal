package com.onlineeyecare.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlineeyecare.dao.IDoctorRepostiory;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.exceptions.DoctorIdNotFoundException;
@SpringBootTest
class IDoctorServiceTest {

	@Autowired
	IDoctorService doctorService;
	
	@MockBean
	IDoctorRepostiory doctorRepository;

	@Test
	void deleteDoctor() throws DoctorIdNotFoundException{
		
		Doctor d3 = new Doctor();
		d3.setDoctorId(16);
		d3.setDoctorMobile(985032807);
		d3.setDoctorAddress("sumeet_jain7");
		d3.setDoctorConsultationTime("7:00 AM");
		d3.setDoctorEmail("jainsumeet77@gmail.com");
		d3.setDoctorName("Pune");
		d3.setDoctorPassword("Sumeet@12");
		d3.setDoctorUsername("kushal");

	

		Optional<Doctor> d2=Optional.of(d3);

		Mockito.when(doctorRepository.findById(16)).thenReturn(d2);
		Mockito.when(doctorRepository.existsById(d3.getDoctorId())).thenReturn(false);
		assertFalse(doctorRepository.existsById(d3.getDoctorId()));
	
	}
	
	@Test
	void viewDoctorById() throws DoctorIdNotFoundException {
		{

			Doctor d4 = new Doctor();
			d4.setDoctorId(25);
			d4.setDoctorMobile(985003287);
			d4.setDoctorAddress("katraj");
			d4.setDoctorConsultationTime("2:00 PM");
			d4.setDoctorEmail("janss@gmail.com");
			d4.setDoctorName("summet");
			d4.setDoctorPassword("karan");
			d4.setDoctorUsername("karan1166");
			Optional<Doctor> d5=Optional.of(d4);

			Mockito.when(doctorRepository.findById(9)).thenReturn(d5);

			assertThat(doctorService.viewDoctor(9)).isEqualTo(d4);
		}
	}
}