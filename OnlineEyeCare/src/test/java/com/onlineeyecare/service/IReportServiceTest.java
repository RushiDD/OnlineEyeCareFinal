package com.onlineeyecare.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;


@SpringBootTest
class IReportServiceTest {
	@Autowired
	private ReportServiceImpl iReportService;

	@Test 
	void removeReportTest() throws ReportIdNotFoundException
	{
		try {
			assertEquals(10,iReportService.removeReport(10).getReportId());
		} catch (ResourceNotFoundException e) {

			e.printStackTrace();
		}
		
	}

}