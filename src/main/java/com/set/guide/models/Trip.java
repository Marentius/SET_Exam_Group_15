package com.set.guide.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Trip {


    private String title, tripId, location, description, guide;
    private double price, rating;
    private int duration, bookedSpots;
    private LocalDate date;
    private ArrayList<String> reviews;

    public Trip() {
    }

    public Trip(String location, int price) {
        this.location = location;
        this.price = price;
    }

    public Trip(String tripId, String title, String location, String description, String guide, double price, double rating, int duration, int bookedSpots, LocalDate date, ArrayList<String> reviews) {
        this.tripId = tripId;
        this.title = title;
        this.location = location;
        this.description = description;
        this.guide = guide;
        this.price = price;
        this.rating = rating;
        this.duration = duration;
        this.bookedSpots = bookedSpots;
        this.date = date;
        this.reviews = reviews;
    }

    /*public ArrayList<Trip> getTrips(){
        ArrayList<Trip> trips = new ArrayList<>();
        for (Trip trips1 : JOSNFile) {
            trips.add(trips1)
        }
        return trips;
    }*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<String> reviews) {
        this.reviews = reviews;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public int getBookedSpots() {
        return bookedSpots;
    }

    public void setBookedSpots(int bookedSpots) {
        this.bookedSpots = bookedSpots;
    }

    @Override
    public String toString() {
        return "Location: " + location + ", Price: " + price + "kr, Description: " + description + ", Rating: " + rating + ", Guide: " + guide + ", Booked Spots: " + bookedSpots;
    }
}
