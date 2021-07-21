package io.muzoo.ooc.webapp.basic.security;

import java.util.List;

public class UserService {

    private MySql mySql = new MySql();

    public void addUser(String username, String password, String display_name) {
        mySql.insert(username, password, display_name);
    }

    public void removeUser(String username) {
        mySql.delete(username);
    }

    public void editUser(String username, String password, String display_name) {
        mySql.update(username, password, display_name);
    }

    public List<User> getUsers() {
        return mySql.getUsers();
    }

    public User getUser(String username) {
        for (User user : getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkIfUserExists(String username) {
        return getUser(username) != null;
    }
}
