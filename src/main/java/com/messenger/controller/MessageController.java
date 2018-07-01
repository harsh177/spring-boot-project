package com.messenger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
    @RequestMapping(value= {"/get","/"},method=RequestMethod.GET,produces="application/json")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>(messagingService.getMessage(),HttpStatus.OK);
    }
    
    @RequestMapping("/test")
    public String test() {
        return customer.toString();
    }
    
    @RequestMapping("/test/exception")
    public String testException() throws Exception {
    	throw new Exception("Exception test done");
    }

}