package com.example.hrms.core.concretes.services;

import org.springframework.stereotype.Service;

import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;

@Service

public class MailManager implements MailService {

	public Result send(String address, String title, String message) {
		
		return new SuccessResult("Mail sent");
		
	}
	
	
	
}
