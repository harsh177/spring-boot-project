package com.messenger.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.messenger.common.ApplicationConstants;
import com.messenger.common.URLConstants;
import com.messenger.entity.Customer;
import com.messenger.entity.Message;
import com.messenger.entity.Tag;
import com.messenger.service.interfaces.IMessagingService;

@RestController
@RequestMapping(URLConstants.MESSAGE_API)
public class MessageController {

	@Autowired
	@Qualifier("messageService")
	private IMessagingService messagingService;// If you are using interface and it has more then one implementation
												// configure then qualifier is must

	@Autowired
	private Customer customer;// If you are using class then qualifier is optional

	@RequestMapping(value = { "/get", "/" }, method = RequestMethod.GET, produces = ApplicationConstants.APP_JSON)
	public ResponseEntity<List<Message>> getMessage() {
		return new ResponseEntity<List<Message>>(messagingService.getMessage(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET, produces = ApplicationConstants.APP_JSON)
	public ResponseEntity<String> hello() {
		return new ResponseEntity<String>("Hello World", HttpStatus.OK);
	}

	@RequestMapping("/test")
	public String test() {
		return customer.toString();
	}

	@RequestMapping("/test/exception")
	public String testException() throws Exception {
		throw new Exception("Exception test done");
	}

	@RequestMapping(value = URLConstants.MESSAGE_API_TAG_ADD, method = RequestMethod.POST, consumes = ApplicationConstants.APP_JSON)
	public ResponseEntity<Tag> addTag(@Valid @RequestBody Tag tag) {
		return new ResponseEntity<Tag>(tag, HttpStatus.OK);
	}

	@RequestMapping(value = "/add/message", method = RequestMethod.POST, consumes = ApplicationConstants.APP_JSON)
	public ResponseEntity<Message> addTag(@Valid @RequestBody Message message) {
		return new ResponseEntity<Message>(messagingService.saveMessage(message), HttpStatus.OK);
	}
}