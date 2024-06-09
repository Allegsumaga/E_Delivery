package models;

public class Log_User {
    private String user;
    private String password;

    public Log_User(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public boolean validate() {
        // Replace with actual validation logic
        return "Ellie Williams".equals(user) && "password123".equals(password);
    }

    // Getters and setters (if needed)
}
