package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CvService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.CvDao;
import com.example.hrms.entities.concretes.Cv;
@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	
	@Autowired
	public CvManager(CvDao cvDao) {
		
		this.cvDao = cvDao;
		
	}
	
	
	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Cv>> getAll() {
		
		return new SuccessDataResult<List<Cv>>(this.cvDao.findAll());
		
	}

	@Override
	public DataResult<List<Cv>> getByCandidateId(int candidateId) {
		return new SuccessDataResult<List<Cv>>(this.cvDao.getByCandidate_UserId(candidateId));
	}

	
	
	
	
	
}
