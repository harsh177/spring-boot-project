package com.messenger.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.messenger.entity.Message;

public interface IMessagingDAO extends JpaRepository<Message,Long> {

}
