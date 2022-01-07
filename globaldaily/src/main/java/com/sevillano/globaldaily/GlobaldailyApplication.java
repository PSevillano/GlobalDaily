package com.sevillano.globaldaily;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GlobaldailyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlobaldailyApplication.class, args);
	}

}
