package com.cafe.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CafeUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeUserApplication.class, args);
	}

}
