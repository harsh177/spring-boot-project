package com.messenger.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.messenger.dao.impl.MessagingDAOImpl;
import com.messenger.dao.interfaces.IMessagingDAO;
import com.messenger.service.impl.MessagingService;
import com.messenger.service.interfaces.IMessagingService;

@Configuration
@Import({ CustomerConfig.class })
public class MessengerConfig {

	@Bean
	@Qualifier("messageService") // Not mandatory. If not specified, it takes the method name i.e., "getMessageService" as qualifier name.
	public IMessagingService getMessageService() {
		return new MessagingService();
	}

	@Bean
	@Qualifier("messageDAO")
	public IMessagingDAO getMessageDAO() {
		return new MessagingDAOImpl();
	}
}
