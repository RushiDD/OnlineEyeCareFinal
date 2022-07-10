package com.onlineeyecare.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.TestIdNotFoundException;

@Service
public interface ITestService {
	TestModule addTest(TestModule test);

	TestModule updateTest(TestModule test);

	TestModule removeTest(int testId) throws TestIdNotFoundException;

	TestModule viewTest(int testId)throws TestIdNotFoundException;

	List<TestModule> viewAllTests();
}
