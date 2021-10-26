package com.example.hrms.entities.dtos;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertDto {

	private int id;
	private int employerId;
	private String jobName;
	private int emptyPositionNumber;
	private String description;
	private Date creationDate;
	private Date deadline;
	private int minSalary;
	private int maxSalary;
	
	
	
}
