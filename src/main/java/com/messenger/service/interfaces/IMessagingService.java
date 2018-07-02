package com.messenger.service.interfaces;

import java.util.List;

import com.messenger.entity.Message;

public interface IMessagingService {
	public List<Message> getMessage();
	public Message saveMessage(Message message);
}
