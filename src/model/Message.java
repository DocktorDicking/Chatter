package model;

import java.sql.Timestamp;

public class Message {
    long id;
    Long chatId;
    Long userId;
    Timestamp createdAt;
    String content;

    public Message(long id, Long chatId, Long userId, String content) {
        this.id = id;
        this.chatId = chatId;
        this.userId = userId;
        // Creates a Timestamp with the current time in millis.
        this.createdAt = new Timestamp(System.currentTimeMillis());
        this.content = content;
    }
}
