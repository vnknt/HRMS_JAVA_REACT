package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {

	List<JobAdvert> getByEmployer_CompanyName(String companyName);
	
	List<JobAdvert> findAll();
	
	List<JobAdvert> findByIsActiveTrue();
	List<JobAdvert> findByIsActiveFalse();
	
	
	
	//List<JobAdvert> findAllOrderByCreationDateAsc();
	List<JobAdvert> getByEmployer_CompanyNameAndIsActiveTrue(String companyName );
	
	JobAdvert getByJobAdvertId(int id);
	
	
}
