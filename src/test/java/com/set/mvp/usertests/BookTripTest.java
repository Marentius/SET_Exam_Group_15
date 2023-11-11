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

import static org.junit.jupiter.api.Assertions.*;

public class BookTripTest {
    private UserJsonRepository userJsonRepository;
    private TripJsonRepository tripJsonRepository;
    private GuideJsonRepository guideJsonRepository;

    @BeforeEach
    public void init(){
    userJsonRepository = new UserJsonRepository();
    tripJsonRepository = new TripJsonRepository();
    guideJsonRepository = new GuideJsonRepository();
    }

    @Test
    public void userCanBookTripTest(){
        ArrayList<Trip> trips = new ArrayList<>();
        User user = userJsonRepository.createUser("user", "user", "user", "user", "user", trips);
        Guide guide = guideJsonRepository.createGuide("guide", "guide", "guide", "guide", "guide");
        Trip trip1 = tripJsonRepository.addTrip("Trip1", "location,", "desc", null, 100, 100, null);
        Trip trip2 = tripJsonRepository.addTrip("Trip2", "location,", "desc", null, 100, 100, null);

        LoggedInProfile.getProfile().logIn(user.getProfileId());

        userJsonRepository.bookTrip(trip1);
        userJsonRepository.bookTrip(trip2);

        assertTrue(user.getTrips().contains(trip1));
        assertTrue(user.getTrips().contains(trip2));

        LoggedInProfile.getProfile().logOut();

        userJsonRepository.deleteUser(user.getProfileId());
        tripJsonRepository.deleteTrip(trip1.getTripId());
        tripJsonRepository.deleteTrip(trip2.getTripId());
        guideJsonRepository.deleteGuide(guide.getProfileId());
    }


}
