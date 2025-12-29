package com.websocket.wetalk.member.controller;

import com.websocket.wetalk.member.dto.JoinReqDto;
import com.websocket.wetalk.member.dto.JoinRespDto;
import com.websocket.wetalk.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public JoinRespDto join(@RequestBody JoinReqDto joinReqDto) {
        Long memberId = memberService.join(joinReqDto.getNickname());
        return new JoinRespDto(0, "success", memberId);
    }

}
