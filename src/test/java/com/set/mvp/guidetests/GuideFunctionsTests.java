package com.set.mvp.guidetests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
        fail("Method not implemented yet.");
    }

    @Test
    public void guide_can_cancel_trip(){
        ArrayList<Trip> tripList = new ArrayList<>();
        Guide guide = new Guide("Guide", "123", "guide", "guide", "email", "12345678", "adress",
                1, LocalDate.of(2001, 1, 1), LocalDate.of(2001, 01, 01), tripList);

        Trip trip1 = new Trip("Trøndelag", 100);
        Trip trip2 = new Trip("Oslo", 200);
        guide.addTrip(trip1);
        guide.addTrip(trip2);

        int tripListLength = tripList.size();

        guide.deleteTrip(trip1);
        assertTrue(tripListLength > guide.getTrips().size());
    }

    @Test
    public void guide_can_contact_support(){
        fail("Method not implemented yet");
    }

    @Test
    public void guide_can_edit_trip(){
        fail("Method not implemented yet");
    }


    @Test
    public void guide_must_be_verified_as_guide(){

    }

}
