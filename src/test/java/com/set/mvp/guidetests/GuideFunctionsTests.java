package com.set.mvp.guidetests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;

import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.TripJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GuideFunctionsTests {
    GuideJsonRepository guideJsonRepository;
    TripJsonRepository tripJsonRepository;
    @BeforeEach
        public void init(){
           guideJsonRepository = new GuideJsonRepository("/database/guide.json");
           tripJsonRepository = new TripJsonRepository("/database/trip.json");
        }


    @Test
    public void guide_can_create_profile() {
        ArrayList<Guide> guidesOriginal = guideJsonRepository.getGuides();
        Guide createdGuide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide", null);
        boolean isProfileIdInList = false;
        for (Guide guide : guideJsonRepository.getGuides()) {
            if (guide.getProfileId() == createdGuide.getProfileId()) {
                isProfileIdInList = true;
                break;
            }

        }
        assertTrue(isProfileIdInList);
        assertFalse(Arrays.equals(guidesOriginal.toArray(), guideJsonRepository.getGuides().toArray()));

        guideJsonRepository.deleteGuide(createdGuide.getProfileId());
    }


    @Test
    public void guide_can_create_trip(){
        ArrayList<Trip> trips = new ArrayList<>();
        Guide guide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide", trips);
        Trip trip = tripJsonRepository.addTrip("Guide", "Guide", "Guide", guide, 1000, 100, null, null);
        guide.addTrip(trip);
        boolean isTripInTripList = false;

        for (Trip trip1 : guide.getTrips()){
            if (trip1.getTripId() == trip.getTripId()){
                isTripInTripList = true;
                break;
            }
        }
        assertTrue(isTripInTripList);
        guide.deleteTrip(trip);
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

}
