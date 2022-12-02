package me.weldnor.securechat.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Message {
    @Id
    private ObjectId id;

    private String to;
    private String message;
}
