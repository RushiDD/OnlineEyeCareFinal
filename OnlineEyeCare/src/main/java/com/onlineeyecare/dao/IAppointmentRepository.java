package com.onlineeyecare.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlineeyecare.dto.Appointment;

	/*
	It is IAppointmentRepository which extends JpaRepository which contains full API of CredRepositories
	used for basic CRUD operations
	*/

@Repository
public interface IAppointmentRepository extends  JpaRepository<Appointment,Integer> {

}
