package com.example.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_experiences")
@AllArgsConstructor
@NoArgsConstructor

public class CandidateExperience {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="exp_id")
	private int experienceId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="position")
	private String position;
	
	@Column(name="start_date")
	private Date startDate;
	
	@Column(name="end_date")
	private Date endDate;

	@ManyToOne()
	@JoinColumn(name="cv_id")
	private Cv cv;
	
	
	
	
	
}
