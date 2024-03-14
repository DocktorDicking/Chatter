package base;

import model.Message;

/**
 * Interface for the base abstract class Chat.
 * This makes sure all Chat classes/objects share the same signature.
 */
public interface ChatInterface {
    public void addMessage(Message message);
    public void delete();
}
