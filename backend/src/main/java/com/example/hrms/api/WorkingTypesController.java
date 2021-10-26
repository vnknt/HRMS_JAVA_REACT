package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.WorkingTypeService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingTypes")
@CrossOrigin
public class WorkingTypesController {
	
	private WorkingTypeService workingTypeService;
	
	@Autowired
	WorkingTypesController(WorkingTypeService workingTypeService){
		this.workingTypeService=workingTypeService;
	}
	
	
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingType>> getAll(){
		return this.workingTypeService.getAll();
	}
	
	
	
	
	
	
}
