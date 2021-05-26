package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.business.concretes.JobManager;
import com.example.hrms.entities.concretes.Job;

@RestController
@RequestMapping("/api/jobs")
public class JobsController {
	
	private JobService jobManager;
	
	
	@Autowired
	public JobsController(JobService jobManager) {
		super();
		this.jobManager = jobManager;
	}



	@GetMapping("/getall")
	public List<Job> getAll() {
		return this.jobManager.getAll();
	}
	
	
	
}



