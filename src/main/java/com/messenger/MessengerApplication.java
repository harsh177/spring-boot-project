package com.messenger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class MessengerApplication {

	private static Logger logger = LoggerFactory.getLogger(MessengerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MessengerApplication.class, args);
		
		logger.info("Message logged at logging level info"); //Default logging level of spring boot
		logger.debug("Message logged at logging level debug");
		logger.warn("Message logged at logging level warn");
		logger.error("Message logged at logging level error");

	}
}
