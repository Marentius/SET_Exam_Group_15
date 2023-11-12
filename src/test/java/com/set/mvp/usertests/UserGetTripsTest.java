package com.set.mvp.usertests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class UserGetTripsTest {
    private UserJsonRepository userJsonRepository;
    private TripJsonRepository tripJsonRepository;
    private GuideJsonRepository guideJsonRepository;

    @BeforeEach
    public void init() {
        userJsonRepository = new UserJsonRepository();
        tripJsonRepository = new TripJsonRepository();
        guideJsonRepository = new GuideJsonRepository();
    }

    @Test
    public void userCanGetTrips() {
        ArrayList<Trip> trips = new ArrayList<>();
        Guide guide = guideJsonRepository.createGuide("guide", "guide", "guide", "guide", "guide");
        User user = userJsonRepository.createUser("UserCanGetTripsTest", "User", "user", "user", "user", trips);
        Trip trip1 = tripJsonRepository.addTrip("Triptriptrip", "trip", "trip", guide, 100, 100, null);
        LoggedInProfile.getProfile().logIn(user.getProfileId());
        userJsonRepository.bookTrip(trip1);

        ArrayList<Trip> getTrips = userJsonRepository.getTrips(user.getProfileId());
        assertArrayEquals(user.getTrips().toArray(), getTrips.toArray());

        userJsonRepository.deleteUser(user.getProfileId());
        tripJsonRepository.deleteTrip(trip1.getTripId());
        guideJsonRepository.deleteGuide(guide.getProfileId());

    }

}