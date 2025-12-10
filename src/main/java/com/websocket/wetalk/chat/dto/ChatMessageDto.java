package com.websocket.wetalk.chat.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessageDto {
    private String roomId;
    private String sender;
    private String message;
}
