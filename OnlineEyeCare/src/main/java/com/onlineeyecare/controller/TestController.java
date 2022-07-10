package com.onlineeyecare.controller;

import java.util.List;

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

import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.TestIdNotFoundException;
import com.onlineeyecare.service.ITestService;

@RestController
@RequestMapping("/v1")
public class TestController {
	
	Log logger = LogFactory.getLog(TestController.class);
	
	@Autowired
	public ITestService tservice;
	
	@GetMapping("/alltests")
	public List<TestModule> viewAllTests(){
		logger.info("alltests successfully");
		return tservice.viewAllTests();
     }
   
     @PostMapping("/test/add")
     public TestModule add(@Valid @RequestBody TestModule test)  {
    	 logger.info("test add successfully");
		return tservice.addTest(test);
     }

 	
    @DeleteMapping("/test/remove/{testId}")
    public TestModule removeTest(@PathVariable int testId) throws TestIdNotFoundException  {
    	logger.info("remove test successfully");
		return tservice.removeTest(testId);
    }
   
    @PutMapping
    public TestModule updateTest(@RequestBody TestModule test) {
    	logger.info("updatetest successfully");
    	return tservice.updateTest(test);
    }
   
    @GetMapping("/test/viewtest/{testid}")  
    private TestModule viewTest(@PathVariable("testid") int testid) throws TestIdNotFoundException   
    {  
    	logger.info("viewtest successfully");
    	return tservice.viewTest(testid);
    }
}

