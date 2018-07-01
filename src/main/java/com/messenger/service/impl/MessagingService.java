package com.messenger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.messenger.dao.interfaces.IMessagingDAO;
import com.messenger.service.interfaces.IMessagingService;

@Service
public class MessagingService implements IMessagingService {

	@Autowired
	@Qualifier("messageDAO")
	private IMessagingDAO messagingDAO;

	@Override
	public String getMessage() {
		return "Hello World";
	}
}
