package controller;
import database.DbController;
import model.User;

public class Authentication {
    private static Authentication instance;
    private DbController db;

    private Authentication() {
        db = DbController.getInstance();
    }

    public static Authentication getInstance() {
        if (instance == null) instance = new Authentication();
        return instance;
    }

    /**
     * This is just an placeholder/example. Do not handle authentication like this in a RL scenario.
     * @param username
     * @param password
     * @return
     */
    public User authenticate(String username, String password) {
        User user = db.getUser(username);
        if (user != null && user.getPassword().equals(password)) return user;
        else return null;
    }
}
