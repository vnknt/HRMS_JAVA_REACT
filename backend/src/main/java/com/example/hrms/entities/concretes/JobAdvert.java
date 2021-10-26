package com.example.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="job_adverts")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvert {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_advert_id")
	private int jobAdvertId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="empty_position_number")
	private int emptyPositionNumber;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="deadline")
	private Date deadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@ManyToOne()
	@JoinColumn(name = "employer_id")
	private Employer employer;
	
	
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;
	
	
	@ManyToOne()
	@JoinColumn(name="job_id")
	private Job job;
	
	@ManyToOne()
	@JoinColumn(name="working_time_id")
	private WorkingTime workingTime;
	
	@ManyToOne()
	@JoinColumn(name="working_type_id")
	private WorkingType workingType;
	
	
	
}
