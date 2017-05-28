package com.test.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * The Class GCDRESTTestApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableJms
@EnableWebSecurity
public class GCDRESTTestApplication {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GCDRESTTestApplication.class, args);
	}
}
