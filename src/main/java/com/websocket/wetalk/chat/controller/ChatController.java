package com.websocket.wetalk.chat.controller;

import com.websocket.wetalk.chat.dto.ChatMessageDto;
import com.websocket.wetalk.chat.dto.CreateChatRoomRespDto;
import com.websocket.wetalk.chat.service.ChatService;
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
            String roomId = chatService.insertChatRoom(roomName);
            log.info("roomId = {}", roomId);
            return new CreateChatRoomRespDto(0, "create chat room", roomId);
        } catch (Exception e) {
            log.error("ChatController createChatRoom error = {}", e.getMessage());
            return new CreateChatRoomRespDto(-1, "unKnown error", "-1");
        }
    }

//    public void sendMessage(ChatMessageDto messageDto) {
//        try {
////            if (messageDto.getMessageType().equals(ChatMessageDto.MessageType.ENTER)) {
////                messageDto.setMessage();
//            }
//        } catch (Exception e) {
//            log.error("ChatController sendMessage error = {}", e.getMessage());
//        }
//    }
}
