package com.example.hrms.business.concretes;

import com.example.hrms.core.concretes.utilities.results.Result;
import com.example.hrms.core.concretes.utilities.results.SuccessResult;
import com.example.hrms.dataAccess.abstracts.UserRoleDao;
import com.example.hrms.entities.abstracts.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRoleManager {

    private final UserRoleDao userRoleRepository;

    public Result add(String roleName){

        UserRole userRole = userRoleRepository.getUserRoleByRole(roleName);

        if(userRole==null){
            UserRole role = new UserRole();
            role.setRole(roleName);
            this.userRoleRepository.save(role);

        }

        return new SuccessResult();
    }


}
