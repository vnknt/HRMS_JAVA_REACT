package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="jobs")
@Data
public class Job {
	@Id
	@GeneratedValue
	@Column(name="job_title_id")
	private int id;
	
	@Column(name="job_name")
	private String name;
}
