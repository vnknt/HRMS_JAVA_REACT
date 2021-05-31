package com.example.hrms.core.concretes.utilities.validation;

import java.util.Date;

public interface ValidationService {
	boolean validate (String  identity_num,String name, String lastname , Date birth_date);
}
