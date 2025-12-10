package com.websocket.wetalk.chat.repository;

import com.websocket.wetalk.chat.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatRoom, Long> {
}
