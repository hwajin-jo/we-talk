package com.websocket.wetalk.chatroom.entity;

import com.websocket.wetalk.memberchatroom.entity.MemberChatRoom;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    @Column(name = "room_name", length = 100, nullable = false)
    private String roomName;

    @OneToMany(mappedBy = "chatRoom")
    private List<MemberChatRoom> roomList = new ArrayList<>();

    @Builder
    public ChatRoom(String roomName) {
        this.roomName = roomName;
    }
}
