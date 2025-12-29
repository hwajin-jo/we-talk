package com.websocket.wetalk.member.entity;

import com.websocket.wetalk.memberchatroom.entity.MemberChatRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String nickname;
    @OneToMany(mappedBy = "member")
    private List<MemberChatRoom> memberChatRooms = new ArrayList<>();

    public void addMemberChatRoom(MemberChatRoom memberChatRoom) {
        memberChatRooms.add(memberChatRoom);
        memberChatRoom.setMember(this);
    }

    public static Member createMember(String nickname) {
        return Member.builder().nickname(nickname).build();
    }
}
