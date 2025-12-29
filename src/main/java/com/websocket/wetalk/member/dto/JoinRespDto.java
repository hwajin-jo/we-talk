package com.websocket.wetalk.member.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JoinRespDto {
    int code;
    String message;
    Long memberId;
}
