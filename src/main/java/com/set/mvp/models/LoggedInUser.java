package com.set.mvp.models;

public class LoggedInUser {
    private static LoggedInUser instance;
    private int LoggedInUserId = -1; //-1 = no user logged in

    private LoggedInUser() {}

    public static LoggedInUser getInstance() {
        if (instance == null) {
            instance = new LoggedInUser();
        }
        return instance;
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

