package com.set.mvp.models;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trip {

    private Guide guide;
    private String title, location, description;
    private double price;
    private int duration, tripId;
    private LocalDate date;
    private ArrayList<String> reviews;

    public Trip() {
    }

    public Trip(String location, int price) {
        this.location = location;
        this.price = price;
    }

    public Trip(int tripId, String title, String location, String description, Guide guide, double price, int duration, LocalDate date, ArrayList<String> reviews) {
        this.tripId = tripId;
        this.title = title;
        this.location = location;
        this.description = description;
        this.guide = guide;
        this.price = price;
        this.duration = duration;
        this.date = date;
        this.reviews = reviews;
    }

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

    public Guide getGuide() {
        return guide;
    }

    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }


    @Override
    public String toString() {
        return "Location: " + location + ", Price: " + price + "kr, Description: " + description + ", Guide: " + guide.getFirstname() + " " + guide.getLastname();
    }
}
