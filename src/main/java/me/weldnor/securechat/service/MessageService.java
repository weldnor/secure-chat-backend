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
        markMessagesAsRead(key1,key2);
        return messageRepository.getMessagesByKeys(key1, key2);
    }

    public void markMessagesAsRead(String key1, String key2) {
        var messages = messageRepository.getMessagesByKeys(key1, key2).stream()
                .filter(message -> message.getTo().equals(key1))
                .peek(message -> message.setRead(true))
                .toList();

        messageRepository.saveAll(messages);
    }

    public void addMessage(Message message) {
        messageRepository.save(message);
    }
}
