package base;

import model.Message;
import model.User;
import java.util.List;

public abstract class Chat implements ChatInterface {
    Long id = null;
    String name = null;
    List<User> participants = null;
    List<Message> messages = null;

    public void addMessage(Message Message) {
        this.messages.add(Message);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
