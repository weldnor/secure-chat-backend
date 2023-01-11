package me.weldnor.securechat.repository;

import me.weldnor.securechat.entity.Message;

import java.util.List;

public interface MessageRepositoryCustom {
    List<Message> getMessagesByKeys(String key1, String key2);
}
