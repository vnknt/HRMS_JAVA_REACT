package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.business.concretes.JobManager;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.entities.concretes.Job;
import com.google.common.net.MediaType;

import net.bytebuddy.asm.Advice.This;

@RestController
@RequestMapping(value = "/api/jobs"  )
public class JobsController {
	
	private JobService jobManager;
	
	
	@Autowired
	public JobsController(JobService jobManager) {
		super();
		this.jobManager = jobManager;
	}



	@GetMapping("/getall")
	public DataResult<List<Job>> getAll() {
		
		return this.jobManager.getAll();
		
		
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Job job){
		
		return this.jobManager.add(job);
		
		
	}
	
	
	
	
	
	
}



