package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.config.Config;

@SpringBootApplication
public class Project2Application {

	public static void main(String[] args) {
		
		//ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		SpringApplication.run(Project2Application.class, args);
		
	}

}
