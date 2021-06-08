package com.example.hrms.core.concretes.utilities.business;

import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;

 public class BusinessRules {
	
	
	public static Result run(Result... logics) {
		
		for (Result result : logics) {
			if(!result.isSuccess()) {
				return result;
			}
		}
		return new SuccessResult();
	}
	
	
}
