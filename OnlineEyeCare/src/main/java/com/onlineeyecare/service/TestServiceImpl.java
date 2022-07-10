package com.onlineeyecare.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineeyecare.dao.ITestRepository;
import com.onlineeyecare.dto.TestModule;
import com.onlineeyecare.exceptions.TestIdNotFoundException;

@Service
public class TestServiceImpl implements ITestService {
	
	@Autowired
	private ITestRepository repository;
	
	@Override
	public TestModule addTest(TestModule test) {

		return repository.saveAndFlush(test);
	}
	@Override
	public TestModule updateTest(TestModule test) {

		return repository.saveAndFlush(test);
	}
	
	@Override
	public TestModule removeTest(int testId) throws TestIdNotFoundException {

		Optional<TestModule> test = repository.findById(testId);
		if (test.isPresent()) {
			repository.deleteById(testId);
			return test.get();
		} else {
			throw new TestIdNotFoundException("Please Enter the id which is available");
		}
	}
	
	@Override
	public TestModule viewTest(int testId) throws TestIdNotFoundException {
		Optional<TestModule> test = repository.findById(testId);
		if (test.isPresent()) {
			return test.get();
		} else {
			throw new TestIdNotFoundException("Please Enter id which is available");
		}
	}

	@Override
	public List<TestModule> viewAllTests() {

		return repository.findAll();
	}

}
