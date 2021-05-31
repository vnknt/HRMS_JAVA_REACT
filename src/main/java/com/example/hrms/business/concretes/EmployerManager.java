package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.constants.Messages;
import com.example.hrms.business.validationRules.InputValidation;
import com.example.hrms.core.concretes.utilities.business.BusinessRules;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmployerDao;
import com.example.hrms.entities.concretes.Employer;

import springfox.documentation.schema.plugins.SchemaPluginsManager;


@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
		
	}
	
	@Override
	public Result add(Employer employer) {
		Result businessResult= BusinessRules.run(
									InputValidation.isEmailValid(employer.getEmail()),
									this.checkDomainAndEmail(employer.getWebsite(), employer.getEmail()),
									this.checkIfEmailNotExists(employer.getEmail()),
									this.checkIfWebsiteNotExists(employer.getWebsite()),
									InputValidation.checkInputLen(employer.getPassword(), 8, 18, "Şifre"),
									InputValidation.checkInputLen(employer.getPhone(), 6,15, "Telofon no")
									
										);
		
		
		
		if(!businessResult.isSuccess()) {
			
			return businessResult;
			
		}
		try {
			this.employerDao.save(employer);
			
		}catch (Exception e) {
			return new ErrorResult(Messages.registration_error);
		}
		return new SuccessResult(Messages.registration_success);
		
		
		
	}
	
	private Result checkIfEmailNotExists(String email) {
		
		if( this.employerDao.findByEmail(email)!=null ) {
			return new ErrorResult(Messages.email_already_in_use);
		}
		
		return new SuccessResult();
		
	}
	
	
	
	
	private Result checkDomainAndEmail(String domain, String email) {
		try {
			email = email.split("@")[1];
			email = email.toLowerCase();
		}catch(Exception e){
			
			return new ErrorResult(Messages.invalid_email);
			
		}
		
		domain=domain.toLowerCase();
		
		if(!domain.equals(email)) {
			return new ErrorResult(Messages.email_domain_different);
		}
		return new SuccessResult();
		
	}
	
	
	private Result checkIfWebsiteNotExists(String website) {
		
		if(this.employerDao.findByWebsite(website)!=null) {
			return new ErrorResult(Messages.website_alreay_in_use);
		}
		return new SuccessResult();
	}
	
	
	
	
}
