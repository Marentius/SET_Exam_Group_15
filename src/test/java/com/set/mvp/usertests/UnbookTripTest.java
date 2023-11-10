package com.set.mvp.usertests;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnbookTripTest {
    UserJsonRepository userJsonRepository;
    TripJsonRepository tripJsonRepository;
    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository();
        tripJsonRepository = new TripJsonRepository();
    }

    @Test
    public void UserCanUnbookTrip(){
        ArrayList<Trip> trip = new ArrayList<>();

        User user = userJsonRepository.createUser("User", "User", "User", "User", "User", trip);

        Trip trip1 = tripJsonRepository.addTrip("Trip1", "Trip", "Trip", null, 100, 100, null, null);
        Trip trip2 = tripJsonRepository.addTrip("Trip2", "Trip", "Trip", null, 100, 100, null, null);

        LoggedInProfile.getProfile().logIn(user.getProfileId());

        userJsonRepository.bookTrip(trip1);
        userJsonRepository.bookTrip(trip2);

        userJsonRepository.unbookTrip(trip1);

        assertFalse(user.getTrips().contains(trip1));
        assertTrue(user.getTrips().contains(trip2));

        userJsonRepository.deleteUser(user.getProfileId());

        tripJsonRepository.deleteTrip(trip1.getTripId());
        tripJsonRepository.deleteTrip(trip2.getTripId());
    }
}