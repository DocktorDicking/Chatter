package base;

import model.Message;
import model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic abstract implementation of the Chat class.
 * All Chat classes should extend this class so all Chat classes have the same basic properties.
 */
public abstract class Chat extends ChatterObject implements ChatInterface {
    String name = null;
    List<User> participants = null;
    List<Message> messages = new ArrayList<>();

    @Override
    public void addMessage(Message message) {
        this.messages.add(message);
    }

    @Override
    public void delete() {
        // delete this chat.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
