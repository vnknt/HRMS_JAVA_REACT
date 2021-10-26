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
@Data
@Table(name = "working_types")
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","jobAdverts"})
public class WorkingType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="working_type_id")
	private int workingTypeId;
	
	@Column(name="working_type")
	private String workingType;
	
	@OneToMany(mappedBy = "workingType")
	private List<JobAdvert> jobAdverts;
	
	
}
