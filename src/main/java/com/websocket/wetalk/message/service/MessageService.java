package com.websocket.wetalk.message.service;

import com.websocket.wetalk.chatroom.entity.ChatRoom;
import com.websocket.wetalk.chatroom.repository.ChatRoomRepository;
import com.websocket.wetalk.member.entity.Member;
import com.websocket.wetalk.member.repository.MemberRepository;
import com.websocket.wetalk.message.dto.MessageRespDto;
import com.websocket.wetalk.message.entity.Message;
import com.websocket.wetalk.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MessageService {

    private final String SEND_MESSAGE_PREFIX = "/topic/chat-rooms/";

    private final MemberRepository memberRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Transactional
    public void sendMessage(Long memberId, Long chatRoomId, String content) {
        Member member = memberRepository.findById(memberId).orElseThrow();
        ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).orElseThrow();

        Message message = Message.createChatMessage(member, chatRoom, content);

        publish(message);
    }

    private void publish(Message message) {
//        simpMessagingTemplate.convertAndSend(SEND_MESSAGE_PREFIX + message.getChatRoom().getId(), new MessageRespDto(message));
        simpMessagingTemplate.convertAndSend(SEND_MESSAGE_PREFIX + 1, new MessageRespDto(message));
        messageRepository.save(message);
    }
}
