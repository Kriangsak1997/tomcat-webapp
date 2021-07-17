package io.muzoo.ooc.webapp.basic.security;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserService {
    private DatabaseConnectionService databaseConnectionService;

    public void addUser(String username, String password, String display_name) {
        databaseConnectionService.insert(username, password, display_name);
    }

    public void removeUser(String username) {
        databaseConnectionService.delete(username);
    }

    public void editUser(String username, String password, String display_name) {
        databaseConnectionService.update(username, password, display_name);
    }

    public List<User> getUsers() {
        return databaseConnectionService.getUsers();
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
