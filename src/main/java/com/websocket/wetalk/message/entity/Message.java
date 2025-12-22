package com.websocket.wetalk.message.entity;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import com.websocket.wetalk.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_room_id")
    private ChatRoom chatRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public static Message createChatMessage(Member member, ChatRoom chatRoom, String content) {
        return Message.builder()
                .content(content)
                .member(member)
                .chatRoom(chatRoom)
                .build();
    }
}
