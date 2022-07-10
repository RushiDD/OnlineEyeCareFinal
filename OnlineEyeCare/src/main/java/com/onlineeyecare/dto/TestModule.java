package com.onlineeyecare.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class TestModule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotNull(message="Id is Mandatory")
	private int testId;
	
	@NotNull(message="Name is Mandatory")
	@Size(min=4, message="Name should be atlist 4 Char")
	private String testName;
	
	
	private String testType;
	@NotEmpty(message="Test description is required")
	private String testDescription;
	
	//@Size(min=100,message="Cost should be more than 100")
	private double testCost;
	
	public TestModule() {
		super();
	}
	
	public TestModule(int testId, String testName, String testType, String testDescription, double testCost) {
		super();
		this.testId=testId;
		this.testName=testName;
		this.testType=testType;
		this.testDescription=testDescription;
		this.testCost=testCost;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public String getTestType() {
		return testType;
	}
	public void setTestType(String testType) {
		this.testType = testType;
	}
	public String getTestDescription() {
		return testDescription;
	}

	public double getTestCost() {
		return testCost;
	}

	public void setTestCost(double testCost) {
		this.testCost = testCost;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}
	
}