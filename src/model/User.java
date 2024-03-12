package model;

public class User {
    Long id;
    String userName;
    String password; // should be hashed.
    String displayName;

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String userName, String password, String displayName) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.displayName = displayName;
    }
}
