package model;

import base.Chat;

import java.util.List;

public class PrivateChat extends Chat {

    public PrivateChat(long id, String name, List<User> participants) {
        this.setId(id);
        this.setName(name);
        this.setParticipants(participants);
    }

    @Override
    public void delete() {

    }

    /**
     * Promote this chat to Groupchat.
     * @return
     */
    public GroupChat promote() {
        return null;
    }
}
