package com.onlineeyecare.service;

import java.time.LocalDate;
import java.util.List;

import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.PatientIdNotFoundException;
import com.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;

public interface IReportService {
	
	Report addReport(Report report);

	Report updateReport(Report report)throws ResourceNotFoundException, ReportIdNotFoundException;

	Report removeReport(int reportId)throws ResourceNotFoundException;

	Report viewReport(int reportId, int patientId)throws ResourceNotFoundException, ReportIdNotFoundException, PatientIdNotFoundException;

	List<Report> viewAllReport(LocalDate date);

}
