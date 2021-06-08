package com.example.hrms.business.abstracts;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;

public interface ImageService {
	Result upload(MultipartFile file);
	
	
}
