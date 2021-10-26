package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.WorkingTimeService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimesController {

	
	
	private WorkingTimeService workingTimeService;
	
	@Autowired
	WorkingTimesController(WorkingTimeService workingTimeService){
		
		this.workingTimeService=workingTimeService;
		
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll(){
		
		return this.workingTimeService.getAll();
		
	}
	
	
	
}
