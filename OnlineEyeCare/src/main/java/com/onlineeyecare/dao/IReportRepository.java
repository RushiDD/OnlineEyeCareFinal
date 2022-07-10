package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Report;

@Repository
public interface IReportRepository extends  JpaRepository<Report,Integer>{
	
	}
