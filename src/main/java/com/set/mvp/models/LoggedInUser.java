package com.set.mvp.models;

public class LoggedInUser {
    private static LoggedInUser user;
    private int LoggedInUserId = -1;

    private LoggedInUser() {}

    public static LoggedInUser getUser() {
        if (user == null) {
            user = new LoggedInUser();
        }
        return user;
    }

    public void logIn(int userId) {
        this.LoggedInUserId = userId;
    }

    public void logOut() {
        this.LoggedInUserId = -1;
    }

    public int getLoggedInUserId() {
        return LoggedInUserId;
    }

    public boolean isLoggedIn() {
        return LoggedInUserId != -1;
    }
}

