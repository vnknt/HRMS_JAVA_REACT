package com.example.hrms;

import com.example.hrms.api.UserRoleService;
import com.example.hrms.business.abstracts.*;
import com.example.hrms.business.concretes.AuthService;
import com.example.hrms.entities.abstracts.UserRole;
import com.example.hrms.entities.concretes.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@EnableSwagger2
public class HrmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsApplication.class, args);
	}
	
	  @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }


	    @Bean
	CommandLineRunner run (EmployerService employerService,
						   CandidateService candidateService,
						   UserRoleService userRoleService,
						   AuthService authService,
						   CityService cityService,
						   JobService jobService,
						   WorkingTypeService workingTypeService,
						   WorkingTimeService workingTimeService
						   ){

		return args -> {
			UserRole adminRole = new UserRole(null,"ADMIN");


		UserRole employerRole = new UserRole(null,"EMPLOYER");
		UserRole jobSeekerRole = new UserRole(null,"JOB_SEEKER");
		UserRole systemUser = new UserRole(null,"SYSTEM_USER");
		userRoleService.add(adminRole);
		userRoleService.add(employerRole);
		userRoleService.add(jobSeekerRole);
		userRoleService.add(systemUser);

		Employer employer1 = new Employer();
		employer1.setEmail("bmw@employer.com");
		employer1.setCompanyName("BMW");
		employer1.setPassword("123456");
		employer1.setRoles(new ArrayList<>());
		employerService.add(employer1);


		Employer employer2 = new Employer();
			employer2.setEmail("mercedes@employer.com");
			employer2.setCompanyName("MERCEDES");
			employer2.setPassword("123456");
			employer2.setRoles(new ArrayList<>());
		employerService.add(employer2);




			Employer employer3 = new Employer();
		employer3.setEmail("admin@admin.com");
		employer3.setPassword("123456");
		employer3.setRoles(new ArrayList<>());
		employerService.add(employer3);




		Candidate candidate = new Candidate();
		candidate.setEmail("mkanat@candidate.com");
		candidate.setFirstName("Muhammed");
		candidate.setLastName("Kanat");
		candidate.setPassword("123456");
		candidate.setBirthDate(new Date(System.currentTimeMillis()));
		candidate.setIdentityNumber("1234");
		candidate.setRoles(new ArrayList<>());

		Candidate candidate2 = new Candidate();
		candidate2.setEmail("vnkanat@candidate.com");
		candidate2.setFirstName("Velat Necmettin");
		candidate2.setLastName("Kanat");
		candidate2.setPassword("123456");
		candidate2.setBirthDate(new Date(System.currentTimeMillis()));
		candidate2.setIdentityNumber("1234");
		candidate2.setRoles(new ArrayList<>());


		candidateService.add(candidate);
		candidateService.add(candidate2);


		authService.addRoleToUser("bmw@employer.com","EMPLOYER");
		authService.addRoleToUser("mercedes@employer.com","EMPLOYER");
		authService.addRoleToUser("mkanat@candidate.com","JOB_SEEKER");
		authService.addRoleToUser("vkanat@candidate.com","JOB_SEEKER");
		authService.addRoleToUser("admin@admin.com","SYSTEM_USER");









			City city = new City(0,"Istanbul",null);
			City city1 = new City(0,"Ankara",null);
			City city2= new City(0,"İzmir",null);

			cityService.add(city);
			cityService.add(city1);
			cityService.add(city2);

			WorkingTime workingTime =new WorkingTime();
			workingTime.setWorkingTime("Full time");

			WorkingTime workingTime2 =new WorkingTime();
			workingTime2.setWorkingTime("Part time");

			workingTimeService.add(workingTime);
			workingTimeService.add(workingTime2);


			WorkingType workingType = new WorkingType();
			workingType.setWorkingType("Uzaktan");
			WorkingType workingType2 = new WorkingType();
			workingType2.setWorkingType("Ofis");
			workingTypeService.add(workingType);
			workingTypeService.add(workingType2);


			Job job1 = new Job();
			job1.setJobName("Software Developer");
			Job job2 = new Job();
			job2.setJobName("3D Artist");
			Job job3 = new Job();
			job3.setJobName("Computer Engineer");
			Job job4 = new Job();
			job4.setJobName("Game Developer");
			Job job5 = new Job();
			job5.setJobName("Web Developer");


			jobService.add(job1);
			jobService.add(job2);
			jobService.add(job3);
			jobService.add(job4);
			jobService.add(job5);



















		};

		}
}
