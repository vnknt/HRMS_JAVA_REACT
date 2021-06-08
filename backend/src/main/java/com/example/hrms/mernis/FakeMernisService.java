package com.example.hrms.mernis;

import java.util.Date;

public class FakeMernisService {
	
	public boolean ValidateByPersonalInfo(String identity_no , String first_name, String last_name , Date birth_year) {
		
		if( identity_no.isEmpty() || first_name.isEmpty()  || last_name.isEmpty() || birth_year ==null) {
			return false;
		}
		
		
		return true;
		
	}
	
	
	
}
