package model;

import base.Chat;

import java.util.List;

public class GroupChat extends Chat {

    public GroupChat(long id, String name, List<User> participants) {
        this.setId(id);
        this.setName(name);
        this.setParticipants(participants);
    }

    public int numOfParticipants() {
        return super.getParticipants().size();
    }

    @Override
    public void delete() {

    }

    /**
     * Demotes this chat to private chat.
     * @return
     */
    public PrivateChat demote() {
        return null;
    }
}
