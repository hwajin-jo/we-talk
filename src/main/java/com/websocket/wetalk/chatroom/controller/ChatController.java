package com.websocket.wetalk.chatroom.controller;

import com.websocket.wetalk.chatroom.dto.CreateChatRoomRespDto;
import com.websocket.wetalk.chatroom.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/room/create")
    public CreateChatRoomRespDto createChatRoom(@RequestParam String roomName) {
        try {
            Long roomId = chatService.createChatRoom(roomName);
            log.info("roomId = {}", roomId);
            return new CreateChatRoomRespDto(0, "create chat room", roomId);
        } catch (Exception e) {
            log.error("ChatController createChatRoom error = {}", e.getMessage());
            return new CreateChatRoomRespDto(-1, "unKnown error", -1L);
        }
    }
}
