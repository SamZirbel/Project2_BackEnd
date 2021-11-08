package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.revature.services.UserService;



@SpringBootApplication

public class Project2Application {

	public static void main(String[] args) {
		
		
		SpringApplication.run(Project2Application.class, args);
		UserService ur=new UserService();
		
		ur.hello();
		
	}

}
