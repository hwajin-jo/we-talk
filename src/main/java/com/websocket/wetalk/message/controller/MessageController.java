package com.websocket.wetalk.message.controller;

import com.websocket.wetalk.message.dto.MessageReqDto;
import com.websocket.wetalk.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Slf4j
@RequiredArgsConstructor
@Controller
public class MessageController {

    private final MessageService messageService;

    @MessageMapping("/chat-rooms/{chatRoomId}")
    public void sendChatMessage(MessageReqDto messageReqDto, SimpMessageHeaderAccessor accessor, @DestinationVariable Long chatRoomId) {
//        if (accessor.getSessionAttributes() == null || !accessor.getSessionAttributes().containsKey("memberId")) {
//            throw new IllegalStateException("No SessionAttribute or memberId. sessionId = " + accessor.getSessionId());
//        }

//        Long memberId = (Long) accessor.getSessionAttributes().get("memberId");
//        messageService.sendMessage(memberId, chatRoomId, messageReqDto.getContent());

        log.info("messageReqDto = {},  chatRoomId = {}", messageReqDto, chatRoomId);
        messageService.sendMessage(1L, chatRoomId, messageReqDto.getContent());
    }
}
