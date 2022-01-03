package com.example.hrms.api;

import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserRoleDao;
import com.example.hrms.entities.abstracts.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;
    public Result add(UserRole userRole){
        userRoleDao.save(userRole);
        return new SuccessResult();
    }


}
