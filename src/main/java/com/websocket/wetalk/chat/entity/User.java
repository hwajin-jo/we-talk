package com.websocket.wetalk.chat.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String username;
    String email;
    String password;
    LocalDateTime createAt;
    LocalDateTime lastActiveAt;

    @OneToMany(mappedBy = "user")
    List<ChatParticipants> chatParticipants = new ArrayList<>();
}
