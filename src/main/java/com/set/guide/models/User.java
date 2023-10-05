package com.set.guide.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class User {

    private String firstname, lastname, email, phoneNumber, address, username, password;
    private int profileId;
    private LocalDate birthDate, registeredDate;
    private ArrayList<Trip> trips = new ArrayList<>();

    public User(String firstname, String lastname, String email, int profileId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profileId = profileId;
    }

    public User(){}

    public User(String username, String password, String firstname, String lastname, String email,
                String phoneNumber, String address, int profileId, LocalDate birthDate,
                LocalDate registeredDate, ArrayList<Trip> trips) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profileId = profileId;
        this.birthDate = birthDate;
        this.registeredDate = registeredDate;
        this.trips = trips;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
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
        return "Username: " + username + ", First Name: " + firstname + ", Last name: " + lastname;
    }

}
