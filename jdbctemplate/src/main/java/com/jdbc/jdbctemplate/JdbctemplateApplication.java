package com.jdbc.jdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jdbc.jdbctemplate.model.Alien;

@SpringBootApplication
public class JdbctemplateApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(JdbctemplateApplication.class, args);
		
		Alien alien = context.getBean(Alien.class);
		alien.setId(10);
		alien.setName("kiran");
		alien.setTech(100);
		
		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien);
		
		System.out.println(repo.findAll());
	}

}
