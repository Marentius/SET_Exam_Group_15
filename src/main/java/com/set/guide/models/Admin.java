package com.set.guide.models;

public class Admin {
    private int profileId;
    private String username;
    private String password;


    public Admin(int profileId, String username, String password) {
        this.profileId = profileId;
        this.username = username;
        this.password = password;


    }

    //public void checkUser(User profileId) {}
    //public void executeBackup(JSON ???) {}
    //public void verifyGuideProfile(User profileId)



    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
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
}
