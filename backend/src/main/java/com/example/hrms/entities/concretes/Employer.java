package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.example.hrms.entities.abstracts.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name="user_id")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","jobAdverts"})
public class Employer extends User {

	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone")
	private String phone;
	
	
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
	
	
}
