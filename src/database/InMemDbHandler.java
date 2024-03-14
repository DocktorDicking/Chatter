package database;

import base.Chat;
import model.GroupChat;
import model.Message;
import model.PrivateChat;
import model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DO NOT USE DIRECTLY. This class is intended to be used by the dbController class.
 * A in memory database class that tries to mimic database interactions.
 * I want this project to be standalone and pure Java.
 *
 * This class uses a Singleton pattern to ensure there is only one of this type during runtime.
 *
 * This class uses:
 * Singleton pattern.
 * Map datastructure.
 *
 */
public class InMemDbHandler {

    private Map<String, List<?>> tableData;
    private static InMemDbHandler instance;

    /**
     * Default contructor for this object. It can only be called within this object itself by the getInstance() method.
     */
    private InMemDbHandler() {
        tableData = new HashMap<>();
        this.initDatabase();
    }

    /**
     * Inits the demo/test data for this project to mimic a database.
     */
    private void initDatabase() {
        tableData.put("user", this.createUsers());
        tableData.put("chat", this.createChats());
    }

    /**
     * Public method used by the dbController class to retrieve data from the Map.
     * @param tableName
     * @return List<?> objects
     */
    public List<?> getTableData(String tableName) {
        if (this.tableExists(tableName)) {
            return tableData.get(tableName);
        } else {
            //error
            return null;
        }
    }

    /**
     * This method determines if this class is instantiated or not.
     * Will return the instance or create a new one. Part of the Singleton pattern.
     * @return
     */
    public static InMemDbHandler getInstance() {
        if (instance == null) {
            instance = new InMemDbHandler();
        }

        return instance;
    }

    public boolean tableExists(String tableName) {
        return tableData.containsKey(tableName);
    }

    /**
     * Creates the demo data for users.
     * @return
     */
    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "test", "test", "Sir test"));
        users.add(new User(2L, "Joe", "test", "Joe"));
        users.add(new User(3L, "John", "test", "JohnDeer"));
        users.add(new User(4L, "Willis", "test", "WillisYall"));
        return users;
    }

    /**
     * Creates the demo chats including messages.
     * @return
     */
    private List<Chat> createChats() {
        List<Chat> chats = new ArrayList<>();
        if (tableData.containsKey("user")) {
            List<User> users = (List<User>) tableData.get("user");

            List<User> participants = new ArrayList<>();
            participants.add(users.get(0));
            participants.add(users.get(1));

            Chat chat = new PrivateChat(1L, "Prv Chat 1", participants);
            chat.addMessage(new Message(1L, 1L, participants.get(0).getId(), "Hi there, how are you doing?"));
            chat.addMessage(new Message(2L, 1L, participants.get(1).getId(), "Doing great! How about you?"));
            chat.addMessage(new Message(3L, 1L, participants.get(0).getId(), "Also good thanks! Want to meet up for coffee today?"));
            chats.add(chat);

            participants = new ArrayList<>();
            participants.add(users.get(0));
            participants.add(users.get(2));

            chat = new PrivateChat(2L, "Prv Chat 2", participants);
            chat.addMessage(new Message(4L, 2L, participants.get(1).getId(), "Hey friend, do not forget to bring donuts today!"));
            chat.addMessage(new Message(5L, 2L, participants.get(0).getId(), "Hi! Yeah I have them. Currntly on my way to the office."));
            chat.addMessage(new Message(6L, 2L, participants.get(1).getId(), "Awesome! See you in a bit."));
            chats.add(chat);

            chat = new GroupChat(3L, "GeneralChat", users);
            chat.addMessage(new Message(7L, 3L, users.get(0).getId(), "Hey all!"));
            chat.addMessage(new Message(8L, 3L, users.get(1).getId(), "Waddup!"));
            chat.addMessage(new Message(9L, 3L, users.get(2).getId(), "Yooooooo..."));
            chat.addMessage(new Message(10L, 3L, users.get(3).getId(), "Hello everyone!"));
            chats.add(chat);
        } else {
            //error
        }
        return chats;
    }
}
