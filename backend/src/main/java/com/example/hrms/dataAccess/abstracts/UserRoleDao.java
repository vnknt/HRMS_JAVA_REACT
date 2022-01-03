package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.abstracts.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleDao extends JpaRepository<UserRole,Integer> {
    UserRole getUserRoleByRole(String role);
}
