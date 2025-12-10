package com.websocket.wetalk.chatroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CreateChatRoomRespDto {
    int code;
    String message;
    String roomId;
}
