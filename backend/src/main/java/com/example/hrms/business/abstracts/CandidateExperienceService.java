package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {
	
	
	Result add(CandidateExperience experience);

	
}
