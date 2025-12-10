package com.websocket.wetalk.chatroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageReqDto {
    private String roomId;
    private String sender;
    private String message;
}
