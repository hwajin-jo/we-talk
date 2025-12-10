package com.websocket.wetalk.chatroom.entity;

import com.websocket.wetalk.memberchatroom.MemberChatRoom;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_id")
    private String roomId;
    @Column(length = 100, nullable = false)
    private String roomName;

    @OneToMany(mappedBy = "chatRoom")
    private List<MemberChatRoom> roomList = new ArrayList<>();
    private LocalDateTime createAt;

    @Builder
    public ChatRoom(String roomId, String roomName) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.createAt = LocalDateTime.now();
    }
}
