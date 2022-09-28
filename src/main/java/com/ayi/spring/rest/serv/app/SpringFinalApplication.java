package com.ayi.spring.rest.serv.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@EntityScan(basePackages = { "com.ayi.spring.rest.serv.app.entities" })
@EnableJpaRepositories(basePackages = { "com.ayi.spring.rest.serv.app.repositories" })
public class SpringFinalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFinalApplication.class, args);
	}

}
