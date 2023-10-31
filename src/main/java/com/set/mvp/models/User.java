package com.set.mvp.models;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    private String firstname, lastname, email,username, password;
    private int profileId;
    private ArrayList<Trip> trips = new ArrayList<>();

    public User(){}

    public User(String username, String password, String firstname, String lastname, String email, int profileId, ArrayList<Trip> trips) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profileId = profileId;
        this.trips = trips;
        this.username = username;
        this.password = password;
        new ArrayList<Trip>();
    }

    public User(String username, String password, String firstname, String lastname, String email, int profileId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profileId = profileId;
        this.username = username;
        this.password = password;
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }
    public void deleteTrip(Trip trip) {
        trips.remove(trip);
    }

    public ArrayList<Trip> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<Trip> trips) {
        this.trips = trips;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Username: " + username;
    }

}
