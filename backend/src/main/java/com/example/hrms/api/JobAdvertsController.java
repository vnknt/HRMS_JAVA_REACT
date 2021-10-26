package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dtos.JobAdvertDto;

@RestController
@RequestMapping("/api/jobAdverts")
@CrossOrigin
public class JobAdvertsController {
	private JobAdvertService jobAdvertService;
	
	
	
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@GetMapping("/getAllConfirmed")
	public DataResult<List<JobAdvert>> getAllConfirmed(){
		
		return this.jobAdvertService.getAllConfirmed();
	}
	
	@GetMapping("/getAllUnconfirmed")
	public DataResult<List<JobAdvert>> getAllUnconfirmed(){
		
		return this.jobAdvertService.getAllUnconfirmed();
	}
	
	
	@GetMapping("/getByCompanyName")
	public DataResult<List<JobAdvert>> getByCompanyName(String companyName){
		
		return this.jobAdvertService.getByCompanyName(companyName);
	}
	
	
	@GetMapping("/getAllSortedByDate")
	public DataResult<List<JobAdvert>> getAllSortedByDate(){
		
		return this.jobAdvertService.getAllOrderByCreationDateAsc();
	}
	
	@GetMapping("/getActiveAdverts")
	public DataResult<List<JobAdvert>> getActiveAdverts(String companyName){
		
		return this.jobAdvertService.getAllByEmployer_CompanyNameAndIsActiveTrue(companyName);
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		
		return this.jobAdvertService.add(jobAdvert);
		
		
	}
	
	
	@GetMapping("/getById")
	public DataResult<JobAdvert> getById(int id){
		
		
		return this.jobAdvertService.getByJobAdvertId(id);
	}
	
	
	@GetMapping("/confirmJobAdvert")
	public Result confirmJobAdvert(@RequestParam(value="jobAdvertId") int jobAdvertId) {
		
		return this.jobAdvertService.confirmJobAdvert( jobAdvertId);
		
	}
	
	
	
}
