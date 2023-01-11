package me.weldnor.securechat.entity;

import lombok.Data;

@Data
public class Chat {
    public String key;
    private String lastMessageText;
    private String lastMessageFrom;
    private long lastMessageDate;
    private long unread;
}
