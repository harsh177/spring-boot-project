package com.messenger.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.messenger.filter.MyFilter;
import com.messenger.service.impl.MessagingService;
import com.messenger.service.interfaces.IMessagingService;

@Configuration
@Import({ CustomerConfig.class })
public class MessengerConfig {

	@Bean
	@Qualifier("messageService") // Not mandatory. If not specified, it takes the method name i.e.,
									// "getMessageService" as qualifier name.
	public IMessagingService getMessageService() {
		return new MessagingService();
	}

	@Bean
	public FilterRegistrationBean<MyFilter> myFilterBean() {
		final FilterRegistrationBean<MyFilter> filterRegBean = new FilterRegistrationBean<MyFilter>();
		filterRegBean.setFilter(new MyFilter());
		filterRegBean.addUrlPatterns("/*");
		filterRegBean.setEnabled(Boolean.TRUE);
		filterRegBean.setName("My Filter");
		filterRegBean.setAsyncSupported(Boolean.TRUE);
		return filterRegBean;
	}
}
