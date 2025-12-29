package com.websocket.wetalk.memberchatroom.entity;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import com.websocket.wetalk.member.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Entity
public class MemberChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id", nullable = false)
    ChatRoom chatRoom;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    Member member;

    public static MemberChatRoom memberJoinChatRoom(Member member, ChatRoom chatRoom) {
        MemberChatRoom memberChatRoom = new MemberChatRoom();

        member.addMemberChatRoom(memberChatRoom);
        chatRoom.addMemberChatRoom(memberChatRoom);

        return memberChatRoom;
    }
}
