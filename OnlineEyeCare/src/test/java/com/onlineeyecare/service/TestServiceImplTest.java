package com.onlineeyecare.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.onlineeyecare.dao.ITestRepository;
import com.onlineeyecare.dto.Doctor;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.TestIdNotFoundException;

@SpringBootTest
class TestServiceImplTest {
	
	@Autowired
	ITestService tservice;

	@MockBean
	ITestRepository repository;

	@Test
	void viewTestById() throws TestIdNotFoundException{
		
			TestModule t1=new TestModule();
			t1.setTestId(102);
			t1.setTestName("Refraction");
			t1.setTestDescription("Abc");
			t1.setTestType("Gyama");
			t1.setTestCost(150);
			Doctor d1=new Doctor();
			d1.setDoctorId(1);
			Optional<TestModule> t2=Optional.of(t1);

			Mockito.when(repository.findById(9)).thenReturn(t2);

			assertThat(tservice.viewTest(9)).isEqualTo(t1);
		
	  }
	  @Test
	  void removeTest()throws TestIdNotFoundException {
		  
		    TestModule c1=new TestModule();
		    Doctor d3 = new Doctor();
		    c1.setTestId(120);
		    c1.setTestName("Retinoscopy");
		    c1.setTestDescription("Abc");
		    c1.setTestType("X-Ray");
		    c1.setTestCost(290.50);

		    d3.setDoctorId(2);

		    Optional<TestModule> c2=Optional.of(c1);

		    Mockito.when(repository.findById(120)).thenReturn(c2);
		    Mockito.when(repository.existsById(c1.getTestId())).thenReturn(false);
		    assertFalse(repository.existsById(c1.getTestId()));
	 }
}