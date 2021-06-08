package com.example.hrms.business.concretes;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.concretes.services.MailManager;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.VerificationCodeDao;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.entities.concretes.VerificationCode;

@Service
public class VerificationCodeManager implements VerificationCodeService {

	
	VerificationCodeDao verificationCodeDao;
	MailManager mailService;
	@Autowired
	public VerificationCodeManager(VerificationCodeDao verificationCodeDao ,MailManager mailService) {
		this.verificationCodeDao = verificationCodeDao;
		
	}
	
	
	
	
	@Override
	public DataResult<VerificationCode> createVerificationCodeForUser(User user) {
		String code = this.generateCode();
		VerificationCode verificationCode = new VerificationCode(0,user.getUserId(),code,new Date(System.currentTimeMillis()));
		this.add(verificationCode);
		return new SuccessDataResult<VerificationCode>(verificationCode);
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		try {
			this.verificationCodeDao.save(verificationCode);
		}catch (Exception e) {
			return new ErrorResult(e.getMessage());
		}
		return new SuccessResult();
		
	}

	@Override
	public Result sendCodeByMail(User user, VerificationCode code) {
		
		return mailService.send("", "", "");
	}

	
	
	
	
	
	
	
	
	
	
	
	

	private String generateCode() {
		
		int random_num = 1000 + (int) (Math.random() * 10000-1000);
		
		String code  = Integer.toString(random_num);
		
		return code;
	}




	@Override
	public Result verify(User user, String verification_code) {
		
		
		VerificationCode result = this.verificationCodeDao.findByUserIdAndVerificationCode(user.getUserId(), verification_code);
		
		if(result == null) {
			return new ErrorResult("Not found");
		}
		
		
		if(result.getVerificationCode() == verification_code  && result.getUserId() == user.getUserId()) {
			
			
		}
		
		
		return null;
	}

	
	
	
	
	
	
}
