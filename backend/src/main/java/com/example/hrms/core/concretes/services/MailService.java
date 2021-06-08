package com.example.hrms.core.concretes.services;

import com.example.hrms.core.concretes.utilities.results.Result;

public interface MailService {
	Result send(String address, String title, String message) ;
}
