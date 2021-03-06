package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.Cv;

public interface CvService {

	Result add(Cv cv);
	Result update(Cv cv);
	DataResult<List<Cv>> getAll();
	DataResult<List<Cv>> getByCandidateId(int candidateId);
	
	
	
	
}
