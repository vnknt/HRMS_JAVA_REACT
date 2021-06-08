package com.example.hrms.business.concretes;

import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateExperienceService;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CandidateExperienceDao;
import com.example.hrms.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService {

	private CandidateExperienceDao candidateExperienceDao;
	
	public CandidateExperienceManager(CandidateExperienceDao candidateExperienceDao ) {
		this.candidateExperienceDao  = candidateExperienceDao;
	}
	
	
	public Result add(CandidateExperience candidateExperience) {
		this.candidateExperienceDao.save(candidateExperience);
		return new SuccessResult();
	}
	
}
