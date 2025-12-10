package com.websocket.wetalk.chatroom.repository;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatRoom, Long> {
}
