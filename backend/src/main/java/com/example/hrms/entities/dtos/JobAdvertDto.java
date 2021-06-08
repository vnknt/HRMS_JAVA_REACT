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
	private String companyName;
	private String jobName;
	private int emptyPositionNumber;
	private Date creationDate;
	private Date deadline;
	
	
	
	
}
