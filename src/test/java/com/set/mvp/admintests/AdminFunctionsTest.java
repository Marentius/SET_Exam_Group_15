package com.set.mvp.admintests;


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

public class AdminFunctionsTest {
    GuideJsonRepository guideJsonRepository;
    UserJsonRepository userJsonRepository;
    TripJsonRepository tripJsonRepository;


    @BeforeEach
    public void init() {
        guideJsonRepository = new GuideJsonRepository("/database/guide.json");
        userJsonRepository = new UserJsonRepository("/database/user.json");
        tripJsonRepository = new TripJsonRepository("/database/trip.json");

    }

    @Test
    public void adminCanDeleteGuideTest() {

        Guide createdGuide = guideJsonRepository.createGuide("DeleteGuide", "123", "Guide", "Guide", "Guide", null);

        guideJsonRepository.deleteGuide(createdGuide.getProfileId());
        boolean isProfileInIdList = false;
        for (Guide guide : guideJsonRepository.getGuides()) {
            if (guide.getProfileId() == (createdGuide.getProfileId())) {
                isProfileInIdList = true;
                break;
            }

        }
        assertFalse(isProfileInIdList);
    }
    @Test
    public void adminCanDeleteUserTest() {
        User createdUser = userJsonRepository.createUser("User", "User", "User", "User", "User", null);
        boolean isProfileInIdList = false;
        userJsonRepository.deleteUser(createdUser.getProfileId());

        for (User user : userJsonRepository.getUsers()) {
            if (user.getProfileId() == (createdUser.getProfileId())) {
                isProfileInIdList = true;
                break;
            }
        }
        assertFalse(isProfileInIdList);
    }

    @Test
    public void adminCanDeleteTripTest() {
        Trip createdTrip = tripJsonRepository.addTrip("Trip", "Trip", "Trip", null, 1000, 100, null, null);
        boolean isTripIdInList = false;
        tripJsonRepository.deleteTrip(createdTrip.getTripId());
        for (Trip trip : tripJsonRepository.getTrips()) {
            if (trip.getTripId() == createdTrip.getTripId()) {
                isTripIdInList = true;
                break;
            }
        }
        assertFalse(isTripIdInList);
    }



    @Test
    public void adminCanViewAllUsers(){
        ArrayList<User> users = userJsonRepository.getUsers();
        assertArrayEquals(users.toArray(), userJsonRepository.getUsers().toArray());
    }
  @Test
    public void adminCanViewAllGuides() {
        ArrayList<Guide> guides = guideJsonRepository.getGuides();
        assertArrayEquals(guides.toArray(), guideJsonRepository.getGuides().toArray());

}

@Test
    public void adminCanViewAllTrips(){
        ArrayList<Trip> trips = tripJsonRepository.getTrips();
        assertArrayEquals(trips.toArray(), tripJsonRepository.getTrips().toArray());
}
}

