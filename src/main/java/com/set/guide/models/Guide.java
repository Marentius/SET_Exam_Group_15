package com.set.guide.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Guide extends User {
    private String firstname, lastname, email, phoneNumber, address, username, password;
    private int profileId;
    private LocalDate birthDate, registeredDate;
    private ArrayList<Trip> guideTrips = new ArrayList<>();

    public Guide(String firstname, String lastname, String email, int profileId, String firstname1) {
        super(firstname, lastname, email, profileId);
        this.firstname = firstname1;
    }

    public void createTrip(Trip guideTrip) {}
    public void deleteTrip(Trip guideTrip) {
        getTrips().remove(guideTrip);}

}
