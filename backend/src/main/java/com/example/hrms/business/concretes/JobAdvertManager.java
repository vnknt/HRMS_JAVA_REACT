package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobAdvertService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobAdvertDao;
import com.example.hrms.entities.concretes.JobAdvert;
import com.example.hrms.entities.dtos.JobAdvertDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	private JobAdvertDao jobAdvertDao;
	
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll());
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		try {
			this.jobAdvertDao.save(jobAdvert);
		}catch (Exception e) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}


	@Override
	public DataResult<List<JobAdvert>> getByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_CompanyName(companyName)); 
	}


	@Override
	public DataResult<List<JobAdvert>> getAllOrderByCreationDateAsc() {
		return new SuccessDataResult<List<JobAdvert>>();
		
	}


	@Override
	public DataResult<List<JobAdvert>> getAllByEmployer_CompanyNameAndIsActiveTrue(String companyName) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByEmployer_CompanyNameAndIsActiveTrue(companyName));
	}

	
	
	
	
	
	
	
}
