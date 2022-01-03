package com.example.hrms.dataAccess.abstracts;

import com.example.hrms.entities.abstracts.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
}
