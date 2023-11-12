package com.set.mvp.models;

public class LoggedInProfile {
    private static LoggedInProfile profile;
    private int LoggedInProfileId = -1;

    private LoggedInProfile() {}

    public static LoggedInProfile getProfile() {
        if (profile == null) {
            profile = new LoggedInProfile();
        }
        return profile;
    }

    public void logIn(int profileId) {
        this.LoggedInProfileId = profileId;
    }

    public void logOut() {
        this.LoggedInProfileId = -1;
    }

    public int getLoggedInProfileId() {
        return LoggedInProfileId;
    }

}

