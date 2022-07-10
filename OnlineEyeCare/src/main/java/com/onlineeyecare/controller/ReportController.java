package com.onlineeyecare.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onlineeyecare.dto.Report;
import com.onlineeyecare.exceptions.ReportIdNotFoundException;
import com.onlineeyecare.exceptions.ResourceNotFoundException;
import com.onlineeyecare.service.IReportService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/v1")
public class ReportController {
	
	Log logger = LogFactory.getLog(ReportController.class);
	
	@Autowired
	IReportService Ireportservice;
	
	@GetMapping("/Welcome")
	public  String welcome()
	{
		logger.info("Welcome");
		return "Welcome to Report module";
	}
	
	@PostMapping("/addreport")
	public Report addReport(@RequestBody Report report)
	{
		logger.info("addreport successfully");
		return Ireportservice.addReport(report);
	}
	
	@PutMapping("/updatereport")
	public Report updateReport(@RequestBody Report report)throws  ResourceNotFoundException, ReportIdNotFoundException
	{
		logger.info("updated report successfully");
		return Ireportservice.updateReport(report);
	}
	
	@DeleteMapping("/delete/{id}")
	public Report delteReport(@PathVariable int id) throws  ResourceNotFoundException
	{
		logger.info("deleted successfully");
		return Ireportservice.removeReport(id);
	}
		
	@GetMapping("/allreportsbydate")
	public List<com.onlineeyecare.dto.Report> listallreportbydate(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date)
	{
		logger.info("allreportsbydate successfully");
		return Ireportservice.viewAllReport(date);
	}
}
