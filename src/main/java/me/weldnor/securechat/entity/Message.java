package me.weldnor.securechat.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Message {
    @Id
    private ObjectId id;

    public String from;
    private String to;

    private String text;

    private boolean read;
}
