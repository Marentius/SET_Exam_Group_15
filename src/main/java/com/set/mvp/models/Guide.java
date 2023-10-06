package com.set.mvp.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Guide extends User {

    public Guide(String firstname, String lastname, String email, int profileId) {
        super(firstname, lastname, email, profileId);
    }

    public Guide(String username, String password, String firstname, String lastname, String email, String phoneNumber, String address, int profileId, LocalDate birthDate, LocalDate registeredDate, ArrayList<Trip> trips) {
        super(username, password, firstname, lastname, email, phoneNumber, address, profileId, birthDate, registeredDate, trips);
    }

    public Guide(){}

    /*
    public User createGuideUser(String username, String password, String firstname, String lastname, String email, String phoneNumber, String address, int profileId, LocalDate birthDate, LocalDate registeredDate, ArrayList<Trip> trips) {
        User newGuideUser = new User(username, password, firstname, lastname, email, phoneNumber, address, profileId, birthDate, registeredDate, trips);
        return newGuideUser;
    }

     */

    public void createTrip(Trip trip) {
        getTrips().add(trip);
    }

    public void deleteTrip(Trip trip) {
        getTrips().remove(trip);}


    public void editTrip(Trip trip) {
    }

    public void contactCustomerSupport() {}
    public void reportUserAccount(User profileId){}




    /*

    @Override
    public String toString() {
        return "Triplist: " + getTrips();
    }
    */
}
