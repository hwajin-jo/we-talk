package com.websocket.wetalk.chatroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatRoomRespDto {
    int code;
    String message;
    Long roomId;
}
