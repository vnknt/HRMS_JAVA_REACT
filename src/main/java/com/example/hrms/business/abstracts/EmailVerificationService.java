package com.example.hrms.business.abstracts;

import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.entities.concretes.EmailVerification;

public interface EmailVerificationService {
	
	Result isEmailVerified(User user);
	
	Result	add(EmailVerification emailVerification);
	
	
	
}
