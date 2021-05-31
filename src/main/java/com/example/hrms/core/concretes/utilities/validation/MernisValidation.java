package com.example.hrms.core.concretes.utilities.validation;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.hrms.mernis.FakeMernisService;

@Service
public class MernisValidation implements ValidationService {
	
	private FakeMernisService mernis = new FakeMernisService();
	
	
	
	@Override
	public boolean validate (String  identity_num,String name, String lastname , Date birth_date) {
		
		return this.mernis.ValidateByPersonalInfo(identity_num, name, lastname, birth_date);
		
	}
	
}
