package com.set.mvp.usertests;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UserGetTripsTest {
    UserJsonRepository userJsonRepository;
    TripJsonRepository tripJsonRepository;

    @BeforeEach
    public void init() {
        userJsonRepository = new UserJsonRepository();
        tripJsonRepository = new TripJsonRepository();
    }

    @Test
    public void userCanGetTrips() {
        ArrayList<Trip> trips = new ArrayList<>();

        User user = userJsonRepository.createUser("UserCanGetTripsTest", "User", "user", "user", "user", trips);
        Trip trip1 = tripJsonRepository.addTrip("Triptriptrip", "trip", "trip", null, 100, 100, null);
        LoggedInProfile.getProfile().logIn(user.getProfileId());
        userJsonRepository.bookTrip(trip1);

        ArrayList<Trip> getTrips = userJsonRepository.getTrips(user.getProfileId());
        assertArrayEquals(user.getTrips().toArray(), getTrips.toArray());

        userJsonRepository.deleteUser(user.getProfileId());
        tripJsonRepository.deleteTrip(trip1.getTripId());
    }

}

