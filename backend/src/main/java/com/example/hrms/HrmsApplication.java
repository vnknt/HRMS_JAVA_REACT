package com.example.hrms;

import com.example.hrms.api.UserRoleService;
import com.example.hrms.business.abstracts.CandidateService;
import com.example.hrms.business.abstracts.EmployerService;
import com.example.hrms.business.concretes.AuthService;
import com.example.hrms.entities.abstracts.UserRole;
import com.example.hrms.entities.concretes.Candidate;
import com.example.hrms.entities.concretes.Employer;
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
	CommandLineRunner run (EmployerService employerService, CandidateService candidateService, UserRoleService userRoleService, AuthService authService){

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

			Employer employer3 = new Employer();
			employer3.setEmail("admin@admin.com");
			employer3.setPassword("123456");
			employer3.setRoles(new ArrayList<>());
			employerService.add(employer3);





//			Employer employer2 = new Employer();
//			employer2.setEmail("mercedes@employer.com");
//			employer2.setCompanyName("MERCEDES");
//			employer2.setPassword("123456");
//
//
//			Employer employer3 = new Employer();
//			employer3.setEmail("google@employer.com");
//			employer3.setCompanyName("GOOGLE");
//			employer3.setPassword("123456");
//

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
		authService.addRoleToUser("mkanat@candidate.com","JOB_SEEKER");
		authService.addRoleToUser("vkanat@candidate.com","JOB_SEEKER");
		authService.addRoleToUser("admin@admin.com","SYSTEM_USER");

		};

		}
}
