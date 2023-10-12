package com.set.mvp.repository;

import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;

import java.time.LocalDate;
import java.util.ArrayList;

public interface TripRepository {
    ArrayList<Trip> getTrips();
    Trip addTrip(int tripId, String title, String location, String description, Guide guide, double price, int duration, LocalDate date, ArrayList<String> reviews);
}
