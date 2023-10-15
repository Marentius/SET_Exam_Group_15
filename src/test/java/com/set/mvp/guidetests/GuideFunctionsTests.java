package com.set.mvp.guidetests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class GuideFunctionsTests {
    @Test
    public void guide_can_create_profile(){
        fail("Method not implemented yet.");
    }

    @Test
    public void guide_can_create_trip(){
        fail("ikke implementert");
    }

    @Test
    public void guide_can_cancel_trip(){
        ArrayList<Trip> trips = new ArrayList<>();
        Guide guide = new Guide("Guide", "Guide", "Guide", "Guide", "Guide", 100, trips);

        Trip trip = new Trip("Oslo", 100);
        Trip trip1 = new Trip("Tønsberg", 100);

        guide.addTrip(trip);
        guide.addTrip(trip1);

        int tripListSize = guide.getTrips().size();

        guide.deleteTrip(trip);

        assertTrue(tripListSize > guide.getTrips().size());
    }
    @Test
    public void guide_can_contact_support(){
        fail("Method not implemented yet");
    }

    @Test
    public void guide_can_edit_trip(){
        ArrayList<Trip> trips = new ArrayList<>();
        Guide guide = new Guide("Guide", "Guide", "Guide", "Guide", "Guide", 10000,trips);
        Trip trip = new Trip("Oslo", 100);
        guide.addTrip(trip);

        guide.editTrip(trip);

        fail("Ikke ferdig");
    }

    @Test
    public void guide_can_report_user(){
        fail("Method not implemented yet");
    }
    @Test
    public void guide_must_be_verified_as_guide(){
        fail("Method not implemented yet");
    }

}
