package com.set.guide;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddToList {

    private TripList tripList = new TripList();

    @Test
    public void add_trip_to_list() {
        int count1 = tripList.getTripList().size();

        tripList.addTrip(new Trip("Oslo", 100));

        int count2 = tripList.getTripList().size();

        assertTrue(count1 < count2);
    }

    @Test
    public void delete_trip_from_list() {
        Trip oslo = new Trip("Oslo", 100);
        Trip sarp = new Trip("Sarp", 200);
        tripList.addTrip(oslo);
        tripList.addTrip(sarp);

        int count1 = tripList.getTripList().size();

        tripList.deleteTrip(oslo);

        int count2 = tripList.getTripList().size();

        assertTrue(count1 > count2);
    }
}
