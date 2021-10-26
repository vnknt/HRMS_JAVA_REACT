package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.WorkingType;

public interface WorkingTypeDao extends JpaRepository<WorkingType, Integer> {

	List<WorkingType> findAll();
	WorkingType getByWorkingTypeId(int workingTypeId);
	
}
