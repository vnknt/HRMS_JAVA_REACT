package com.example.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.LanguageService;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
	
	private LanguageService languageService;
	
	
	@Autowired
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Language language) {
		this.languageService.add(language);
		return new SuccessResult();
	}
	
	
	@GetMapping("/getall")
	public Result getall() {
		
		return this.languageService.getAll();	}
}
