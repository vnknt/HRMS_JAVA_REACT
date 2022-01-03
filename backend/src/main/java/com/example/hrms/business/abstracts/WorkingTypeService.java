package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.WorkingType;

public interface WorkingTypeService {

	DataResult<List<WorkingType>> getAll();
	Result add(WorkingType workingType);
	
}
