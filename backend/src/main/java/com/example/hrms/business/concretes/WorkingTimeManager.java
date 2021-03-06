package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.WorkingTimeService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.dataAccess.abstracts.WorkingTimeDao;
import com.example.hrms.entities.concretes.WorkingTime;


@Service
public class WorkingTimeManager implements WorkingTimeService {

	private WorkingTimeDao workingTimeDao;
	
	
	@Autowired
	
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		
		this.workingTimeDao=workingTimeDao;
		
	}
	
	
	
	public DataResult<List<WorkingTime>> getAll(){
		
		return new SuccessDataResult<List<WorkingTime>>(this.workingTimeDao.findAll());
		
	}
	
	
}
