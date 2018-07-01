package com.messenger.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.messenger.entity.Customer;

@Configuration
@PropertySource("classpath:customer.properties")
/*
 * //To Register Multiple Propertie files
 * 
 * @PropertySources({
 * 
 * @PropertySource(value = "classpath:missing.properties",
 * ignoreResourceNotFound=true),
 * 
 * @PropertySource("classpath:db.properties") // if same key , this will win })
 * 
 */
public class CustomerConfig {
	@Autowired
	private Environment env;

	@Value("${customer.type}")
	private String type;

	@Bean
	public Customer getCustomer() {
		return new Customer(env.getProperty("customer.name"), this.type);
	}
}
