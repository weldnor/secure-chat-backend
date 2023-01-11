package me.weldnor.securechat.entity;

import lombok.Data;

@Data
public class Chat {
    public String key;
    private String lastMessageText;
    private String lastMessageKey;
    private long lastMessageTimestamp;
    private long unread;
}
