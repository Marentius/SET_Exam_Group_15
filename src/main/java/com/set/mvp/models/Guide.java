package com.set.mvp.models;

import java.util.ArrayList;

public class Guide extends User {

    public Guide(String username, String password, String firstname, String lastname, String email, int profileId, ArrayList<Trip> trips) {
        super(username, password, firstname, lastname, email, profileId, trips);
    }

    public Guide(String username, String password, String firstname, String lastname, String email, int profileId) {
        super(username, password, firstname, lastname, email, profileId);
    }

    public Guide(){}

    public void deleteTrip(Trip trip) {
        getTrips().remove(trip);}

}
