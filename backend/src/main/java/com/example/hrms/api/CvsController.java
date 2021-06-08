package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.entities.concretes.Cv;

@RestController
@RequestMapping("/api/cvs")

public class CvsController {
	
	private CvService cvService;
	
	@Autowired
	public CvsController(CvService cvService) {
		
		this.cvService = cvService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<Cv>> getall() {
		return this.cvService.getAll();
	}
	
	
	@GetMapping("/getbycandidateid")
	public DataResult<List<Cv>> getByCandidateId(int candidateId) {
		return this.cvService.getByCandidateId(candidateId);
	}
	
	
	
}
