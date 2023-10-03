package com.set.guide.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Guide {
    private String firstname, lastname, email, phoneNumber, address, username, password;
    private int guideId;
    private LocalDate birthDate, registeredDate;
    private ArrayList<Trip> guideTrips = new ArrayList<>();

    public Guide(String firstname, String lastname, String email, int guideId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.guideId = guideId;
    }

    //public void createTrip(Trip guideTrip) {}
    //public void deleteTrip(Trip guideTrip) {trips.remove(guideTrip);}
    //t
}
