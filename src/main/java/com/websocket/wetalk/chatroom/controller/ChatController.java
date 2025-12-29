package com.websocket.wetalk.chatroom.controller;

import com.websocket.wetalk.chatroom.dto.ChatRoomJoinReqDto;
import com.websocket.wetalk.chatroom.dto.ChatRoomLeaveReqDto;
import com.websocket.wetalk.chatroom.dto.ChatRoomRespDto;
import com.websocket.wetalk.chatroom.service.ChatService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    @PostMapping("/room/create")
    public ChatRoomRespDto createChatRoom(@RequestParam String roomName) {
        try {
            Long roomId = chatService.createChatRoom(roomName);
            log.info("roomId = {}", roomId);
            return new ChatRoomRespDto(0, "create chat room", roomId);
        } catch (Exception e) {
            log.error("ChatController createChatRoom error = {}", e.getMessage());
            return new ChatRoomRespDto(-1, "unKnown error", -1L);
        }
    }

    @PostMapping("/{chatRoomId}/join")
    public ChatRoomRespDto joinChatRoom(@RequestBody ChatRoomJoinReqDto chatRoomJoinReqDto, @PathVariable Long chatRoomId) {
        try {
            long memberId = chatRoomJoinReqDto.getMemberId();
            chatService.join(memberId, chatRoomId);
            return new ChatRoomRespDto(0, "success", chatRoomId);
        } catch (Exception e) {
            log.error("ChatController createChatRoom error = {}", e.getMessage());
            return new ChatRoomRespDto(-1, "Unknown Error", -1L);
        }
    }

    @PostMapping("/{chatRoomId}/leave")
    public ChatRoomRespDto leaveChatRoom(@RequestBody ChatRoomLeaveReqDto chatRoomLeaveReqDto, @PathVariable Long chatRoomId) {
        try {
            long memberId = chatRoomLeaveReqDto.getMemberId();
            chatService.leave(memberId, chatRoomId);
            return new ChatRoomRespDto(0, "success", chatRoomId);
        } catch (Exception e) {
            log.error("ChatController leaveChatRoom error = {}", e.getMessage());
            return new ChatRoomRespDto(-1, "Unknown Error", -1L);
        }
    }

}
