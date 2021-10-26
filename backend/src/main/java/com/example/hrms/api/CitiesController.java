package com.example.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.CityService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {

	private CityService cityService;
	
	@Autowired
	public CitiesController(CityService cityService) {
		
		this.cityService = cityService;
		
	}
	
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll() {
		
		
		return this.cityService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(	 City city) {
		
		return  this.cityService.add(city);
	}
	
	
	
}
