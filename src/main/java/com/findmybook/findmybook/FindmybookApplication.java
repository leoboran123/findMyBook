package com.findmybook.findmybook;

import com.findmybook.findmybook.run.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.time.temporal.ChronoUnit;

import java.time.LocalDateTime;


@SpringBootApplication
@ComponentScan
public class FindmybookApplication {

	// To check the logs, we can use logger...
	// private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(FindmybookApplication.class, args);

		var welcomeMessage = new WelcomeMessage();
		System.out.println(welcomeMessage.getWelcomeMessage());

		// Checking the log...
		// log.info("Application started successfully");


	}
	
	@Bean
	CommandLineRunner runner() {
		return args-> {
			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1,ChronoUnit.HOURS), 5, Location.OUTDOOR);
			System.out.println("Run: " + run);
		};
	}

}
