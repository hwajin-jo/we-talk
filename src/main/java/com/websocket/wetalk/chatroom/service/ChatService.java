package com.websocket.wetalk.chatroom.service;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import com.websocket.wetalk.chatroom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ChatRoomRepository chatRoomRepository;

    public Long createChatRoom(String roomName) {
        Long roomId = chatRoomRepository.save(new ChatRoom(roomName)).getId();
        return roomId;
    }
}
