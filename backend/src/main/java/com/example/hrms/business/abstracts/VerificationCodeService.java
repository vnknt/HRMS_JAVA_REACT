package com.example.hrms.business.abstracts;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {

	DataResult<VerificationCode> createVerificationCodeForUser(User user);
	
	Result add(VerificationCode verificationCode);
	
	Result sendCodeByMail(User user,VerificationCode code);
	
	Result verify(User user, String verification_code);
	
}