package model;

import base.ChatterObject;

public class User extends ChatterObject {
    String userName;
    String password; // should be hashed.
    String displayName;

    public User(long id) {
        this.setId(id);
    }

    public User(long id, String userName, String password, String displayName) {
        this.setId(id);
        this.userName = userName;
        this.password = password;
        this.displayName = displayName;
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
