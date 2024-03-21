package base;

import model.User;

import java.util.List;

public interface ChatFactoryInterface {
    public Chat transform(Chat chat);
    public Chat createChat(String name, List<User> participants) throws ClassNotFoundException;
}
