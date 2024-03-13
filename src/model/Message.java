package model;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Message {
    Long id;
    Long chatId;
    Timestamp createdAt;
    ArrayList<User> recipients;
    String content;
}
