package com.set.mvp.models;

public class Admin {
    private int profileId;
    private String username;
    private String password;


    public Admin(int profileId, String username, String password) {
        this.profileId = profileId;
        this.username = username;
        this.password = password;


    }

    public String viewUserInfo(User user) {
        String userInfo = "Username: " + user.getUsername() + "\n"
                + "First name: " + user.getFirstname() + "\n"
                + "Last name: " + user.getLastname() + "\n"
                + "Email: " + user.getEmail() + "\n"
                + "Phonenumber: " + user.getPhoneNumber() + "\n"
                + "Adress: " + user.getAddress() + "\n"
                + "Profil-ID: " + user.getProfileId() + "\n"
                + "Birthdate: " + user.getBirthDate() + "\n"
                + "Registered date: " + user.getRegisteredDate() + "\n";

        // userInfo += "Trips: " + user.getTrips() + "\n";

        return userInfo;
    }




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
