package com.example.hrms.api;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.adapters.cloudinary.ImageUploadService;
import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.Result;
@RestController
@RequestMapping("/api/images")
public class ImagesController {
	private ImageService imageService;
	private ImageUploadService imageUploadService;
	
	
	@Autowired
	public ImagesController(ImageService imageService, ImageUploadService imageUploadService) {
		this.imageService = imageService;
		this.imageUploadService = imageUploadService;
		
	}
	
	
	@PostMapping("/upload")
	public Result upload(@RequestParam("file") MultipartFile file) throws IOException {
		
		
		return this.imageService.upload(file);
		
		
	}
	
	
	
	
}
