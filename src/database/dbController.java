package database;

import base.Chat;
import base.ChatterObject;
import model.User;

import java.util.List;

/**
 * Controller that talks to our InMemDbPrototype class.
 * In a real world situation you always use some sort of DBMS to talk to the database.
 *
 * This is that DMBS thingy.
 *
 * This class uses:
 * Streams to iterate a List of objects and find an Object.
 * Instance of a Singleton class.
 */
public class dbController {
    private InMemDbHandler dbHandler;

    public dbController() {
        // InMemDbHandler is singleton
        this.dbHandler = InMemDbHandler.getInstance();
    }

    /**
     * Looks for the next available id for a table name.
     * @param tableName
     * @return
     */
    public Long getNextIdForTable(String tableName) throws ClassNotFoundException {
        long next = 0L;

        List<?> tableData = dbHandler.getTableData(tableName);

        /*
        Casting the List<?> to List<ChatterObject> since ChatterObject is our base object class.
        All classes should implement ChatterObject in some way because it contains the long id member.
        This saves some logic and extra loops which might improve performance.
         */
        if (!tableData.isEmpty() && tableData.get(0) instanceof ChatterObject) {
            List<ChatterObject> objects = (List<ChatterObject>) tableData;
            for (ChatterObject obj : objects) {
                if (obj.getId() == next) next++;
                if (obj.getId() > next) next = obj.getId() + 1; // Whenever the next == 0L
            }
        }

        return next;
    }

    /**
     * Tries to retrieve the User based on the given long id.
     * Will return null if the given id is invalid or when the user does not exist.
     * @param id long
     * @return User || null
     */
    public User getUser(long id) {
        if (id > 0L) {
            // ignore unchecked cast since we are 100% certain this is a List with User objects.
            List<User> users = (List<User>) this.dbHandler.getTableData("user");
            return users.stream()
                    .filter(current -> current.getId() == id)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Tries to retrieve the User based on the given long id.
     * Will return null if the given id is invalid or when the user does not exist.
     * @param username String
     * @return User || null
     */
    public User getUser(String username) {
        if (!username.isEmpty()) {
            // ignore unchecked cast since we are 100% certain this is a List with User objects.
            List<User> users = (List<User>) this.dbHandler.getTableData("user");
            return users.stream()
                    .filter(current -> current.getUserName().equals(username))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Public method to save any object that is supported by this dbController.
     * This method accepts any instance of the Object class, the method will check if the Object is one of the supported
     * classes we can save to the InMemDbHandler.
     */
    public boolean saveObject(Object obj) {
        if (obj instanceof User) this.saveUser((User) obj);
        if (obj instanceof Chat) this.saveChat((Chat) obj);
        else return false; // throw error.
        return true;
    }

    /**
     * Conversion method to save the User Object.
     * @param user
     */
    private void saveUser(User user) {
        // We can ignore the unchecked cast warning since we are 100% certain this List is a List of User objects.
        List<User> users = (List<User>) this.dbHandler.getTableData("user");
        users.add(user);
    }

    /**
     * Conversion method to save the Chat Object.
     * @param chat
     */
    private void saveChat(Chat chat) {
        // We can ignore the unchecked cast warning since we are 100% certain this List is a List of User objects.
        List<Chat> chats = (List<Chat>) this.dbHandler.getTableData("chat");
        chats.add(chat);
    }
}
