package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.VerificationCodeService;
import com.example.hrms.business.constants.Messages;
import com.example.hrms.business.validationRules.InputValidation;
import com.example.hrms.core.concretes.utilities.business.BusinessRules;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.core.concretes.utilities.validation.ValidationService;
import com.example.hrms.dataAccess.abstracts.CandidateDao;
import com.example.hrms.entities.abstracts.User;
import com.example.hrms.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService {
	
	
	private CandidateDao candidateDao;
	private ValidationService validationService;
	private VerificationCodeService verificationCodeService;
	@Autowired
	public CandidateManager(CandidateDao candidateDao  ,ValidationService validationService , VerificationCodeService verificationCodeService ) {
		this.candidateDao = candidateDao;
		this.validationService = validationService;
		this.verificationCodeService = verificationCodeService;
	}
	
	
	 
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll()) ;
	}

	
	@Override
	public Result add(Candidate candidate) {
		
		Result businessResult = BusinessRules.run( 
				InputValidation.isEmailValid(candidate.getEmail()),
				this.checkIfEmailNotExists(candidate.getEmail()) ,
				
				InputValidation.checkInputLen(candidate.getIdentityNumber(), 11, 11, "Tc no"),
				this.checkIfIdentityNotExists(candidate.getIdentityNumber()),
				
				InputValidation.checkInputLen(candidate.getFirstName(), 3, 25, "İsim"),
				InputValidation.checkInputLen(candidate.getLastName(), 3, 25, "Soyisim"),
				InputValidation.checkInputLen(candidate.getPassword(), 6, 18, "Şifre"),
				this.checkIdentityInfo(candidate)
				
				);
		
		
		if( ! businessResult.isSuccess() ){
			
			return businessResult;
		
		}
		
		try {
			User addedUser = this.candidateDao.save(candidate);
			this.verificationCodeService.createVerificationCodeForUser(addedUser);
			
		} catch (Exception e) {
			return new ErrorResult(Messages.registration_error);
		}
		
		return new SuccessResult(Messages.registration_success);
		
		
		
	}
	
	
	
	
	private Result checkIfEmailNotExists(String email) {
		List<Candidate> result = this.candidateDao.findByEmail(email);
		
		if(  result.isEmpty() ) {
			return new SuccessResult();
		}
		
		return new ErrorResult(Messages.email_already_in_use);
		
		
	}
	
	
	
	private Result checkIfIdentityNotExists(String identity_number) {
		
		List<Candidate> result = this.candidateDao.findByIdentityNumber(identity_number);
		

		if(  result.isEmpty() ) {
			return new SuccessResult();
		}
		
		return new ErrorResult(Messages.identity_already_in_use);
		
	}

	
	private Result checkIdentityInfo(Candidate candidate) {
		
		boolean validationResult = this.validationService.validate(
									candidate.getIdentityNumber(),
									candidate.getFirstName(),
									candidate.getLastName(),
									candidate.getBirthDate());
		if(!validationResult) {
			return new ErrorResult(Messages.identity_verification_error);
		}
		return new SuccessResult();
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
}
