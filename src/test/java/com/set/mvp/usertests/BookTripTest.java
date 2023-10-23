package com.set.mvp.usertests;

import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class BookTripTest {
    UserJsonRepository userJsonRepository;
    TripJsonRepository tripJsonRepository;

    @BeforeEach
    public void init(){
    userJsonRepository = new UserJsonRepository("/database/user.json");
    tripJsonRepository = new TripJsonRepository("/database/trip.json");
    }

    @Test
    public void book_one_trip_test() {
        ArrayList<Trip> trips = new ArrayList<>();
        User user = userJsonRepository.createUser("User", "User", "User", "User", "User", trips);
        Trip trip = tripJsonRepository.addTrip("Trip", "Trip", "Trip", null, 100, 100, null, null);
        user.addTrip(trip);
        assertTrue(user.getTrips().size() > 0);
        assertTrue(user.getTrips().size() < 2);
        assertFalse(user.getTrips().size() == 3);
        tripJsonRepository.deleteTrip(trip.getTripId());
        userJsonRepository.deleteUser(user.getProfileId());

    }

    @Test
    public void book_several_trips_test() {
        ArrayList<Trip> trips = new ArrayList<>();
        User user = userJsonRepository.createUser("User", "User", "User", "User", "User", trips);
        Trip trip1 = tripJsonRepository.addTrip("Trip", "Trip", "Trip", null, 100, 100, null, null);
        Trip trip2 = tripJsonRepository.addTrip("Trip", "Trip", "Trip", null, 100, 100, null, null);
        Trip trip3 = tripJsonRepository.addTrip("Trip", "Trip", "Trip", null, 100, 100, null, null);
        Trip trip4 = tripJsonRepository.addTrip("Trip", "Trip", "Trip", null, 100, 100, null, null);

        user.addTrip(trip1);
        user.addTrip(trip2);
        assertTrue(user.getTrips().size() == 2);
        user.addTrip(trip3);
        assertFalse(user.getTrips().size() == 2);
        user.addTrip(trip4);
        assertTrue(user.getTrips().size() == 4);

        userJsonRepository.deleteUser(user.getProfileId());
        tripJsonRepository.deleteTrip(trip1.getTripId());
        tripJsonRepository.deleteTrip(trip2.getTripId());
        tripJsonRepository.deleteTrip(trip3.getTripId());
        tripJsonRepository.deleteTrip(trip4.getTripId());
    }

}
