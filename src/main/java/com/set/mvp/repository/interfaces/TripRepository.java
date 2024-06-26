package com.set.mvp.repository.interfaces;

import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TripRepository {
    ArrayList<Trip> getTrips();
    Trip addTrip(String title, String location, String description, Guide guide, double price, int duration, LocalDate date);
    void deleteTrip(int tripId);
    void deleteTripFromAllUserTripLists(int tripId);
}
