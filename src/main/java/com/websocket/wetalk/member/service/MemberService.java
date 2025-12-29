package com.websocket.wetalk.member.service;

import com.websocket.wetalk.member.entity.Member;
import com.websocket.wetalk.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(String nickname) {
        Member member = Member.createMember(nickname);
        Member saveMember = memberRepository.save(member);
        return saveMember.getId();
    }
}
