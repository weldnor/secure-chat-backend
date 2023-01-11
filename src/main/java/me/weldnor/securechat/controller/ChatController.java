package me.weldnor.securechat.controller;

import me.weldnor.securechat.entity.Chat;
import me.weldnor.securechat.service.ChatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/chats")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }


    @GetMapping
    public List<Chat> getChats(@RequestParam String key) {
        return chatService.getChats(key);
    }

}
