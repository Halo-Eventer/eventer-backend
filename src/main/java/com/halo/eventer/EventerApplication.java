package com.halo.eventer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EventerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventerApplication.class, args);
	}

}
