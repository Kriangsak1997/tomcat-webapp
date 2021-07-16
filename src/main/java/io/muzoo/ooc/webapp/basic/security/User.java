package io.muzoo.ooc.webapp.basic.security;

public class User {

    private long id;
    private String username;
    private String password;
    private String Display_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplay_name() {
        return Display_name;
    }

    public void setDisplay_name(String display_name) {
        Display_name = display_name;
    }


    public User(long id, String username, String password, String display_name) {
        this.id = id;
        this.username = username;
        this.password = password;
        Display_name = display_name;
    }

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
