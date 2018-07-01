package com.messenger.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSchedular {
	@Scheduled(fixedRate = 10000)
	public void call() {
		System.out.println("Message Schedular is running");
	}
}
