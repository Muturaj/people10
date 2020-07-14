package com.people10.assignment.AssignmentPeople10;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class AssignmentPeople10Application {

	//@Autowired
    //SessionFactory sessionFactory;
	public static void main(String[] args) {
		SpringApplication.run(AssignmentPeople10Application.class, args);
		System.out.println("Running Successfully");
	}

}
