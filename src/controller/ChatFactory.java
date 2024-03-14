package controller;

import base.Chat;
import base.ChatFactoryInterface;
import model.GroupChat;
import model.PrivateChat;
import model.User;

import java.util.List;

/**
 * Basic factory pattern which is responsible for creating the diffrent Chat objects we have in the project.
 */
public class ChatFactory implements ChatFactoryInterface {

    @Override
    public Chat transform(Chat chat) {
        return null;
    }

    @Override
    public Chat createChat(String name, List<User> participants) {
//        if (participants.size() > 2) {
//            return new GroupChat();
//        } else {
//            return new PrivateChat();
//        }

        return null;
    }
}
