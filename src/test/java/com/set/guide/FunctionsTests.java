package com.set.guide;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FunctionsTests {

    final TripList tripList = new TripList();
    private Trip oslo;
    private Trip sarp;

    @BeforeEach
    public void init(){
        oslo = new Trip("Oslo", 100);
        sarp = new Trip("Sarpsborg", 200);
    }

    @Test
    public void book_trip_test() {
        int originalTriplist = tripList.getTripList().size();

        tripList.addTrip(oslo);

        int changedTriplist = tripList.getTripList().size();

        assertTrue(originalTriplist < changedTriplist);
    }

    @Test
    public void cancel_booking_test() {
        tripList.addTrip(oslo);
        tripList.addTrip(sarp);

        int originalTriplist = tripList.getTripList().size();

        tripList.deleteTrip(oslo);

        int changedTriplist = tripList.getTripList().size();

        assertTrue(originalTriplist > changedTriplist);
    }
}
