package controller;

import base.Chat;
import base.ChatFactoryInterface;
import database.DbController;
import model.GroupChat;
import model.PrivateChat;
import model.User;

import java.util.List;

/**
 * Basic factory pattern which is responsible for creating the diffrent Chat objects we have in the project.
 */
public class ChatFactory implements ChatFactoryInterface {
    private DbController db;

    public ChatFactory() {
        db = DbController.getInstance();
    }

    /**
     * Transforms the chat to group or private chat, depending on the amount of participants.
     * A chat is considered group chat whenever a chat haves more than 2 participants.
     * @param chat Chat
     * @return Chat
     */
    @Override
    public Chat transform(Chat chat) {
        return null;
    }

    /**
     * Will create the correct chat object based on the amount of participants.
     * @param name
     * @param participants
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    public Chat createChat(String name, List<User> participants) throws ClassNotFoundException {
        long id = db.getNextIdForTable("chat");

        if (!participants.isEmpty() && participants.size() > 2) {
            GroupChat newChat = new GroupChat(id, name, participants);
            db.saveObject(newChat);
            return newChat;
        } else if (participants.size() == 2){
            PrivateChat newChat = new PrivateChat(id, name, participants);
            db.saveObject(newChat);
            return newChat;
        }

        return null;
    }
}
