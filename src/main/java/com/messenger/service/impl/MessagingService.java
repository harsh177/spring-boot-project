package com.messenger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.messenger.dao.interfaces.IMessagingDAO;
import com.messenger.entity.Message;
import com.messenger.service.interfaces.IMessagingService;

@Service
public class MessagingService implements IMessagingService {

	@Autowired
	private IMessagingDAO messagingDAO;
	
	public List<Message> getMessage(){
		return messagingDAO.findAll();
	}
	
	public Message saveMessage(Message message){
		return messagingDAO.save(message);
	}
}
