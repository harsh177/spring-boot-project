package com.messenger.unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.messenger.dao.interfaces.IMessagingDAO;
import com.messenger.entity.Message;
import com.messenger.service.impl.MessagingService;

@RunWith(MockitoJUnitRunner.class)
public class MessengerServiceTest {
	@Mock
	IMessagingDAO iMessagingDAO;
	
	@InjectMocks
	MessagingService messagingServiceImpl;

	@Test
	public void test1_itShouldReturn_emptyListOfMessage_Success() {
		//Given
		List<Message> list=new ArrayList<Message>();
		//When
		when(iMessagingDAO.findAll()).thenReturn(list);
		//Then
		assertEquals(0, messagingServiceImpl.getMessage().size());
	}

}
