package com.example.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
@Entity
@Table(name="jobs")
@Data
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","jobAdverts"})
public class Job {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="job_id")
	private int jobId;
	
	@Column(name="job_name")
	private String jobName;
	
	@OneToMany(mappedBy = "job")
	private List<JobAdvert> jobAdverts;
	
	
}
