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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
