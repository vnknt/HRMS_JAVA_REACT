package com.example.hrms.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.example.hrms.core.concretes.utilities.results.DataResult;
import com.example.hrms.core.concretes.utilities.results.SuccessDataResult;
@Service
public class CloudinaryManager implements ImageUploadService{

	private Cloudinary cloudinary;
	
	
	CloudinaryManager(){
		this.cloudinary = new Cloudinary(ObjectUtils.asMap(
				
					"cloud_name", "dqx69ezwx",
					"api_key", "839477351961549",
					"api_secret", "xNjRYPvlyVZC4ToUV0NPJXKTOgg"
					
					)
				);		
	}

	@SuppressWarnings("rawtypes")
	@Override
	public DataResult<Map> upload(MultipartFile file) throws IOException {
		
		Map result = this.cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
		
		return new SuccessDataResult<Map>(result);
			
		
	}
	
	
	
	
	
}
