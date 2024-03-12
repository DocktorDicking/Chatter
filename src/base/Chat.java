package base;

import model.User;

import java.util.ArrayList;

public abstract class Chat implements ChatInterface {
    Long id = null;
    String name = null;
    ArrayList<User> participants = null;
}
