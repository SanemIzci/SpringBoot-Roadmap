package com.sanemizci.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.sanemizci"})
@EntityScan(basePackages = {"com.sanemizci"})
@EnableJpaRepositories(basePackages = {"com.sanemizci"})
@SpringBootApplication
public class PageableApplication {

	public static void main(String[] args) {
		SpringApplication.run(PageableApplication.class, args);
	}

}
