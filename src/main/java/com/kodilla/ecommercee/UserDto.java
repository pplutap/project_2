package com.kodilla.ecommercee;

public class UserDto {
    private Long id;
    private String username;
    private boolean status;
    private int userKey;

    public UserDto() {
    }

    public UserDto(Long id, String username, boolean status, int userKey) {
        this.id = id;
        this.username = username;
        this.status = status;
        this.userKey = userKey;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean isStatus() {
        return status;
    }

    public int getUserKey() {
        return userKey;
    }
}
