package database;

import base.Chat;
import model.GroupChat;
import model.PrivateChat;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A in memory database class that tries to mimic database interactions.
 * I want this project to be standalone and pure Java.
 */
public class InMemDbPrototype {

    private Map<String, List<?>> tableData = new HashMap<>();

    /*
    TODO:
    Init tables: User, Chat, Message
     */
    public void initDatabase() {
        // TODO: Initialize tables and data for these tables.
        tableData.put("user", this.createUsers());
        tableData.put("chat", this.createChats());
    }

    public List<Chat> getChats() {
        return (List<Chat>) tableData.get("chat");
    }

    public boolean login(String username, String password) {
        return false;
    }


    // Create test data.
    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "test", "test", "Sir test"));
        users.add(new User(2L, "Joe", "test", "Joe"));
        users.add(new User(3L, "John", "test", "JohnDeer"));
        users.add(new User(4L, "Willis", "test", "WillisYall"));
        return users;
    }

    private List<Chat> createChats() {
        List<Chat> chats = new ArrayList<>();
        if (tableData.containsKey("user")) {
            List<User> users = (List<User>) tableData.get("user");
            List<User> participants = new ArrayList<>();

            participants.add(users.get(1));
            participants.add(users.get(2));

            chats.add(new PrivateChat(1L, "Prv Chat 1", participants));

            participants = new ArrayList<>();
            participants.add(users.get(1));
            participants.add(users.get(3));

            chats.add(new PrivateChat(1L, "Prv Chat 2", participants));
            chats.add(new GroupChat(2L, "GeneralChat", users));
        } else {
            //error
        }
        return chats;
    }
}
