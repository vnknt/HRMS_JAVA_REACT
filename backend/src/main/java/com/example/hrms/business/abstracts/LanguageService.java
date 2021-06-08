package com.example.hrms.business.abstracts;

import java.util.List;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.concretes.Language;

public interface LanguageService {
	
	Result add(Language language);
	DataResult<List<Language>> getAll();
	
}
