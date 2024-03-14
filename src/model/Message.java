package model;

import base.ChatterObject;

import java.sql.Timestamp;

public class Message extends ChatterObject {
    long chatId;
    long userId;
    Timestamp createdAt;
    String content;

    public Message(long id, long chatId, long userId, String content) {
        this.setId(id);
        this.chatId = chatId;
        this.userId = userId;
        // Creates a Timestamp with the current time in millis.
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.content = content;
    }
}
