package com.set.guide.models;

import java.util.ArrayList;

public class User {

    private String firstname;
    private String lastname;
    private String email;
    private int userId;
    private ArrayList<Trip> userTrip = new ArrayList<>();

    public User(String firstname, String lastname, String email, int userId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.userId = userId;
    }

    public void addTrip(Trip trip) {
        userTrip.add(trip);
    }
    public void deleteTrip(Trip trip) {
        userTrip.remove(trip);
    }

    public ArrayList<Trip> getUserTrip() {
        return userTrip;
    }

    public void setUserTrip(ArrayList<Trip> userTrip) {
        this.userTrip = userTrip;
    }

    @Override
    public String toString() {
        return "Triplist: " + userTrip;
    }

}
