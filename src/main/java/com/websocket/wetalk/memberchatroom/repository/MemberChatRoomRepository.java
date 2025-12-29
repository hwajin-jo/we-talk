package com.websocket.wetalk.memberchatroom.repository;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import com.websocket.wetalk.member.entity.Member;
import com.websocket.wetalk.memberchatroom.entity.MemberChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberChatRoomRepository extends JpaRepository<MemberChatRoom, Long> {

    void deleteByMemberAndChatRoom(Member member, ChatRoom chatRoom);
}
