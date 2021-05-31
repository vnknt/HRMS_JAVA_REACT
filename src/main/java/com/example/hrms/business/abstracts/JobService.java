package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.entities.concretes.Job;

public interface JobService {

	DataResult<List<Job>> getAll();
	
}
