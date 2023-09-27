package com.Corptec.SpringBootSalesforceAndSqlIntegrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux

@SpringBootApplication
//@EnableR2dbcRepositories
public class SpringBootSalesforceAndSqlIntegratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSalesforceAndSqlIntegratorApplication.class, args);
	}

}
