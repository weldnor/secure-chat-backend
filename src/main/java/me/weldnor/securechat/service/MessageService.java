package me.weldnor.securechat.service;

import me.weldnor.securechat.entity.Message;
import me.weldnor.securechat.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages(String key1, String key2) {
        return messageRepository.getMessagesByKeys(key1, key2);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }
}
