package com.example.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmailVerificationService;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.EmailVerificationDao;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.entities.concretes.EmailVerification;

@Service

public class EmailVerificationManager implements EmailVerificationService {

	
	private EmailVerificationDao emailVerificationDao;
	
	@Autowired
	public EmailVerificationManager(EmailVerificationDao emailVerificationDao) {
		
		this.emailVerificationDao  = emailVerificationDao;
		
	}

	@Override
	public Result isEmailVerified(User user) {
		EmailVerification result = this.emailVerificationDao.findByUserId(user.getUserId());
		if(result == null)
			return new ErrorResult("Record not found");
		else {
			
			if(result.isVerified())
				return new SuccessResult();
			else
				return new ErrorResult("Not verified");
		
		}
		
	}

	@Override
	public Result add(EmailVerification emailVerification) {
		
		try {
			this.emailVerificationDao.save(emailVerification);
			
		}catch (Exception e) {
			return new ErrorResult("Email verification couldn't be added");
		}
		return new SuccessResult();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
