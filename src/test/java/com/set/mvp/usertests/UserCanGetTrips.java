package com.set.mvp.usertests;


import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserCanGetTrips {
    UserJsonRepository userJsonRepository;
    TripJsonRepository tripJsonRepository;

    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository("/database/user.json");
        tripJsonRepository = new TripJsonRepository("/database/trip.json");
    }

    @Test
    public void userCanGetTrips(){

        ArrayList<Trip> trips = new ArrayList<>();
        User user = userJsonRepository.createUser("user", "user", "user", "user", "user", trips);

        Trip trip = tripJsonRepository.addTrip("trip", "loc", "desc", null, 100, 100, null, null);

        user.addTrip(trip);

        ArrayList<Trip> getTrips = userJsonRepository.getTrips(user.getProfileId());


        assertArrayEquals(user.getTrips().toArray(), getTrips.toArray());

        userJsonRepository.deleteUser(user.getProfileId());
        tripJsonRepository.deleteTrip(trip.getTripId());


        /*


        ArrayList<Trip> tripsList = new ArrayList<>();
        User user = userJsonRepository.createUser("user", "user", "user", "user", "user", tripsList);
        LoggedInProfile.getProfile().logIn(user.getProfileId());

        Trip trip1 = tripJsonRepository.addTrip("Trip1", "location,", "desc", null, 100, 100, null, null);
        Trip trip2 = tripJsonRepository.addTrip("Trip2", "location,", "desc", null, 100, 100, null, null);
        ArrayList<Trip> oldUserTrips = user.getTrips();

        assertFalse(oldUserTrips.contains(trip1));
        assertFalse(oldUserTrips.contains(trip2));

        userJsonRepository.bookTrip(trip1);
        userJsonRepository.bookTrip(trip2);

        ArrayList<Trip> newUserTrips = user.getTrips();

        assertTrue(newUserTrips.contains(trip1));
        assertTrue(newUserTrips.contains(trip2));

        assertArrayEquals(user.getTrips().toArray(), newUserTrips.toArray());

        LoggedInProfile.getProfile().logOut();
        tripJsonRepository.deleteTrip(trip1.getTripId());
        tripJsonRepository.deleteTrip(trip2.getTripId());
        userJsonRepository.deleteUser(user.getProfileId());
    */



    }
}
