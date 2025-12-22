package com.websocket.wetalk.member.repository;

import com.websocket.wetalk.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
