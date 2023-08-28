package com.test.speakclock.speakingclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.test.*")
public class SpeakingclockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeakingclockApplication.class, args);
	}

}
