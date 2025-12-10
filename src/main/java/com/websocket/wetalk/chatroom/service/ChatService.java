package com.websocket.wetalk.chatroom.service;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import com.websocket.wetalk.chatroom.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRepository chatRepository;

    public String insertChatRoom(String roomName) {
        String roomId = UUID.randomUUID().toString();
        chatRepository.save(new ChatRoom(roomId, roomName));

        return roomId;
    }
}
