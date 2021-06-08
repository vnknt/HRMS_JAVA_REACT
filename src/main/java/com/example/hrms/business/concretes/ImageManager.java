package com.example.hrms.business.concretes;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.hrms.adapters.cloudinary.ImageUploadService;
import com.example.hrms.business.abstracts.ImageService;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorDataResult;
import com.example.hrms.core.concretes.utilities.results.ErrorResult;
import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.ImageDao;

@Service
public class ImageManager implements ImageService{

	private ImageUploadService imageUploadService;
	private ImageDao imageDao;
	
	@Autowired
	public ImageManager(ImageDao imageDao, ImageUploadService imageUploadService) {
		
		
		this.imageDao = imageDao;
		this.imageUploadService=imageUploadService;
		
		
	}
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public Result upload (MultipartFile file ) {
		 try {
			 
			 this.imageUploadService.upload(file);
				 
		 }
		 catch(Exception e) {
			 return new ErrorResult ( "Resim yüklenirken hata oluştu "+e.getMessage());
		 }
		return new SuccessResult();
	}
	
	
	
	
	
}
