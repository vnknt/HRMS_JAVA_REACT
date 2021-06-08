package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Cv;

public interface CvDao extends JpaRepository<Cv, Integer> {

	List<Cv> getByCandidate_UserId(int userId);
	
	
}
