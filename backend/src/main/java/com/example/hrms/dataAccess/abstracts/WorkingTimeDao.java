package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.WorkingTime;

public interface WorkingTimeDao extends JpaRepository<WorkingTime, Integer> {

	List<WorkingTime> findAll();
}
