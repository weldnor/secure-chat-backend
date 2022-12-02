package me.weldnor.securechat.controller;

import me.weldnor.securechat.entity.Message;
import me.weldnor.securechat.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @PutMapping
    public void addMessage(@RequestBody Message message) {
        messageService.addMessage(message);
    }
}
