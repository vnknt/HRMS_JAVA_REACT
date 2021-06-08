package com.example.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.hrms.entities.abstracts.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="candidates")
@PrimaryKeyJoinColumn(name = "user_id")
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","schools","languages","candidateExperiences"})
@AllArgsConstructor
@NoArgsConstructor
public class Candidate extends User {
	
	@Column(name="first_name")
	private String firstName; 
	
	@Column(name="last_name")
	private String lastName;
		
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	
	@OneToMany(mappedBy = "candidate")
	private List<School> schools;
	

}
