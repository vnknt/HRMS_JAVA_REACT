package com.example.hrms.adapters.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.core.concretes.utilities.results.DataResult;

public interface ImageUploadService {
	
	
	DataResult<Map> upload(MultipartFile file) throws IOException;
	
	
}
