package com.websocket.wetalk.member.entity;

import com.websocket.wetalk.memberchatroom.entity.MemberChatRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    Long id;
    String nickname;

    @OneToMany(mappedBy = "member")
    List<MemberChatRoom> memberChatRooms = new ArrayList<>();
}
