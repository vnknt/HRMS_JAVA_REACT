package com.example.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

}
