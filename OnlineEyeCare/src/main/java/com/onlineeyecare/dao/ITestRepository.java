package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlineeyecare.dto.TestModule;

@Repository
public interface ITestRepository extends JpaRepository<TestModule, Integer> {

	
}
