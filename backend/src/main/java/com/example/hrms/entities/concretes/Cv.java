package com.example.hrms.entities.concretes;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="candidate_cvs")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitiliazer","handler","image","candidateExperiences"})
public class Cv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name="github_url")
	private String  githubUrl;
	
	@Column(name="linkedin_url")
	private String linkedinUrl;
	
	@OneToOne()
	@JoinColumn(name="candidate_id")
	private Candidate candidate;
	
	
	@OneToOne()
	@JoinColumn(name="image_id")
	private Image image;
	
	@OneToMany(mappedBy = "cv")
	private List<CandidateExperience> candidateExperiences;
	
	
	
}
