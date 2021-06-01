package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobService;
import com.example.hrms.business.constants.Messages;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.JobDao;
import com.example.hrms.entities.concretes.Job;

@Service
public class JobManager implements JobService {
	
	private JobDao jobDao;
		
	@Autowired
	public JobManager(JobDao jobDao) {
		super();
		this.jobDao = jobDao;
	}


	@Override
	public DataResult<List<Job>>  getAll() {
		
		
		return new SuccessDataResult<List<Job>>(
				
				this.jobDao.findAll(),"data listelendi"
				);
		
	}


	@Override
	public Result add(Job job) {
		Job result = this.jobDao.findByJobNameIgnoreCase(job.getJobName());
		if(result!=null) {
			return new ErrorResult(Messages.job_already_exists);
		}
		try {
			this.jobDao.save(job);
			
		}catch (Exception e) {
			return new ErrorResult(Messages.error_occured);
		}
		return new SuccessResult();		
	}

	
	
	
	
}
