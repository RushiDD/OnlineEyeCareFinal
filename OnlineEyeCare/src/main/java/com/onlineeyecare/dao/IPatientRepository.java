package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.onlineeyecare.dto.Patient;

@Repository
public interface IPatientRepository extends JpaRepository<Patient,Integer>  {
	
}


		
