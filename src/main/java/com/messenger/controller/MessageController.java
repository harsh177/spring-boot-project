package com.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.messenger.entity.Customer;
import com.messenger.service.interfaces.IMessagingService;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	@Qualifier("messageService")
	private IMessagingService messagingService;//If you are using interface and it has more then one implementation configure then qualifier is must
	
	@Autowired
	private Customer customer;//If you are using class then qualifier is optional
	
    @RequestMapping(value= {"/get","/"},method=RequestMethod.GET)
    public String getMessage() {
        return messagingService.getMessage();
    }
    
    @RequestMapping("/test")
    public String test() {
        return customer.toString();
    }

}