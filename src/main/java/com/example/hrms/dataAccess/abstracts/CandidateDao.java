package com.example.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hrms.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	
	
	
	List<Candidate>  findByEmail(String email);
	
	@Query("select c from Candidate c where c.identity_number = ?1")
	List<Candidate> findByIdentityNumber(String identity_number);
	

	
}