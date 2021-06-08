package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dtos.JobAdvertDto;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByCompanyName(String companyName);
	
	
	
	Result add(JobAdvert jobAdvert);
	
	DataResult<List<JobAdvert>> getAllOrderByCreationDateAsc();
	DataResult<List<JobAdvert>> getAllByEmployer_CompanyNameAndIsActiveTrue(String companyName );
	
	
}
