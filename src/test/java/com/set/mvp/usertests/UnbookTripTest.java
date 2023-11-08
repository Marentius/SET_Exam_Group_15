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
    TripJsonRepository tripJsonRepository;
    UserJsonRepository userJsonRepository;

    @BeforeEach
    public void init(){
        tripJsonRepository = new TripJsonRepository("/database/trip.json");
        userJsonRepository = new UserJsonRepository("/database/user.json");
    }

     @Test
    public void userCanUnbookTrip(){
         ArrayList<Trip> trips = new ArrayList<>();
        User user = userJsonRepository.createUser("User", "Password", "firstname", "Lastname", "email", trips);
        Trip trip1 = tripJsonRepository.addTrip("Trip", "location,", "desc", null, 100, 100, null, null);
        Trip trip2 = tripJsonRepository.addTrip("Trip", "location,", "desc", null, 100, 100, null, null);

        user.addTrip(trip1);
        user.addTrip(trip2);

         assertTrue(user.getTrips().contains(trip1));
         assertTrue(user.getTrips().contains(trip2));

         LoggedInProfile.getProfile().logIn(user.getProfileId());

         userJsonRepository.unbookTrip(trip1);

         assertFalse(user.getTrips().contains(trip1));

         LoggedInProfile.getProfile().logOut();

         userJsonRepository.deleteUser(user.getProfileId());

         tripJsonRepository.deleteTrip(trip1.getTripId());
         tripJsonRepository.deleteTrip(trip2.getTripId());

     }


}
