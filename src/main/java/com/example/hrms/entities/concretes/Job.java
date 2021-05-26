package com.example.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Table(name="Jobs")
@Data
public class Job {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
}
