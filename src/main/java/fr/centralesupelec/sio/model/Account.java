package fr.centralesupelec.sio.model;

/**
 * An entity class to represent a user account.
 */
public class Account {

    // Encapsulation: private field
    private String username;
    private String passwordHash;

    // Encapsulation: public getter
    public String getUsername() {
        return username;
    }

    // Encapsulation: public setter
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
