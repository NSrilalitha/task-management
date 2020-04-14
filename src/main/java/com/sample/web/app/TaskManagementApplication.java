package com.sample.web.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages={"com.sample.web.app","com.sample.web.app.controller","com.sample.web.app.model","com.sample.web.app.service","com.sample.web.app.repository"})
@EnableWebMvc
@EnableTransactionManagement
public class TaskManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagementApplication.class, args);
	}

}
