package com.example.hrms.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.entities.abstracts.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	public UserController(VerificationCodeService verificationCodeService) {
		this.verificationCodeService = verificationCodeService;	
	}
	
	
	
	
	
	@PostMapping("/verify_email")
	public Result verify_email(@RequestBody User user , String verification_code) {
		return this.verificationCodeService.verify(user, verification_code);
	}
	
}
