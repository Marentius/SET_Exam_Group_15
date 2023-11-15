package com.set.mvp.usertests;


import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserCanGetTrips {
    private UserJsonRepository userJsonRepository;
    private TripJsonRepository tripJsonRepository;

    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository();
        tripJsonRepository = new TripJsonRepository();
    }

    @Test
    public void userCanGetTrips(){

        ArrayList<Trip> trips = new ArrayList<>();
        User user = userJsonRepository.createUser("user", "user", "user", "user", "user", trips);

        Trip trip = tripJsonRepository.addTrip("trip", "loc", "desc", new Guide("Guide", "Guide", "Guide", "Guide", "Guide", 100), 100, 100, null);

        user.addTrip(trip);

        ArrayList<Trip> getTrips = userJsonRepository.getTrips(user.getProfileId());


        assertArrayEquals(user.getTrips().toArray(), getTrips.toArray());

        userJsonRepository.deleteUser(user.getProfileId());
        tripJsonRepository.deleteTrip(trip.getTripId());
    }
}
