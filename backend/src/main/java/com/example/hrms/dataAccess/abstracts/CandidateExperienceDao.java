package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience, Integer> {

}
