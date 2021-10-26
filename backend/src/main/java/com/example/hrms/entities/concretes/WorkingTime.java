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
@Table(name="working_times")
@Data
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","jobAdverts"})
public class WorkingTime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="working_time_id")
	private int workingTimeId;
	
	
	@Column(name="working_time")
	private String workingTime;
	
	@OneToMany(mappedBy = "workingType")
	private List<JobAdvert> jobAdverts;
	
	
}
