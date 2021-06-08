package com.example.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CandidateExperienceService;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.CandidateExperience;

@RestController
@RequestMapping("/api/experiences")
public class CandidateExperiencesController {
	
	private CandidateExperienceService candidateExperienceService;

	@Autowired
	public CandidateExperiencesController(CandidateExperienceService candidateExperienceService) {
		
		this.candidateExperienceService = candidateExperienceService;
		
	}
	
	@PostMapping("/add")
	
	public Result add(@RequestBody CandidateExperience experience){
		
		this.candidateExperienceService.add(experience);
		return new SuccessResult();
		
	}
	
	
	
	
	
	
}
