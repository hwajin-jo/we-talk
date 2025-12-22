package com.websocket.wetalk.message.dto;

import com.websocket.wetalk.message.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRespDto {
    private String content;
//    private Long memberId;
//    private String nickname;

    public MessageRespDto(Message message) {
        this.content = message.getContent();
//        this.memberId = message.getMember().getId();
//        this.nickname = message.getMember().getNickname();
    }
}
