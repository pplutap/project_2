package com.kodilla.ecommercee;

public class LoginDto {
    private boolean loggedIn;
    private int sessionId;

    public LoginDto() {
    }

    public LoginDto(boolean loggedIn, int sessionId) {
        this.loggedIn = loggedIn;
        this.sessionId = sessionId;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public int getSessionId() {
        return sessionId;
    }
}
