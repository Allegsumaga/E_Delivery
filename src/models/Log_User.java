package models;

import java.util.Arrays;
import java.util.List;

public class Log_User {
    private String user;
    private String password;

    // List of valid users
    private static final List<Log_User> validUsers = Arrays.asList(
        new Log_User("Ellie Williams", "password123"),
        new Log_User("Joel Miller", "password456"),
        new Log_User("Tommy Miller", "password789"),
        new Log_User("Abby Anderson", "password101")
    );

    public Log_User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean validate() {
        for (Log_User validUser : validUsers) {
            if (validUser.getUser().equals(user) && validUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Getters
    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}

