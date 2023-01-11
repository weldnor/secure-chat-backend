package me.weldnor.securechat.service;

import me.weldnor.securechat.entity.Chat;
import me.weldnor.securechat.entity.Message;
import me.weldnor.securechat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ChatService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Chat> getChats(String key) {
        var friendKeys = messageRepository.findAll().stream()
                .filter(message -> message.getFrom().equals(key) || message.getTo().equals(key))
                .flatMap(message -> Stream.of(message.getFrom(), message.getTo()))
                .filter(s -> !s.equals(key))
                .distinct()
                .toList();

        List<Chat> chats = new ArrayList<>();

        for (var friendKey : friendKeys) {
            Chat chat = new Chat();

            var allMessages = messageRepository.getMessagesByKeys(key, friendKey);
            chat.setKey(friendKey);
            Message lastMessage = allMessages.get(allMessages.size() - 1);
            chat.setLastMessageText(lastMessage.getText());
            chat.setLastMessageKey(lastMessage.from);

            var friendMessages = allMessages.stream().filter(message -> !message.getFrom().equals(key)).toList();
            var unreadMessagesCount = friendMessages.stream().filter(message -> !message.isRead()).count();
            chat.setUnread(unreadMessagesCount);
            chat.setLastMessageTimestamp(lastMessage.getId().getTimestamp());
            chats.add(chat);
        }

        return chats;
    }
}
