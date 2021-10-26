package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();
	Result add(City city);
	
}
