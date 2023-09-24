package com.set.guide;

import java.util.ArrayList;

public class TripList {

    private ArrayList<Trip> tripList = new ArrayList<>();

    public TripList() {
    }

    public void addTrip(Trip trip) {
        tripList.add(trip);
    }
    public void deleteTrip(Trip trip) {
        tripList.remove(trip);
    }

    public ArrayList<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(ArrayList<Trip> tripList) {
        this.tripList = tripList;
    }

    @Override
    public String toString() {
        return "Triplist: " + tripList;
    }

}
