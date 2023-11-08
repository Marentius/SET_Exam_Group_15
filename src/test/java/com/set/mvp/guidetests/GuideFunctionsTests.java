package com.set.mvp.guidetests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;


import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GuideFunctionsTests {
    GuideJsonRepository guideJsonRepository;
    TripJsonRepository tripJsonRepository;
    UserJsonRepository userJsonRepository;
    @BeforeEach
        public void init(){
           guideJsonRepository = new GuideJsonRepository("/database/guide.json");
           userJsonRepository = new UserJsonRepository("/database/user.json");
           tripJsonRepository = new TripJsonRepository("/database/trip.json");

        }


    @Test
    public void guide_can_create_profile() {
        ArrayList<Guide> guidesOriginal = guideJsonRepository.getGuides();
        Guide createdGuide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide");
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
        Guide guide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide");
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
        Guide guide = new Guide("Guide", "Guide", "Guide", "Guide", "Guide", 100);

        Trip trip = new Trip("Oslo", 100);
        Trip trip1 = new Trip("Tønsberg", 100);

        guide.addTrip(trip);
        guide.addTrip(trip1);

        int tripListSize = guide.getTrips().size();

        guide.deleteTrip(trip);

        assertTrue(tripListSize > guide.getTrips().size());
    }

    @Test
    public void guide_can_log_in(){
        Guide createdGuide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide");
        int createdGuideId = createdGuide.getProfileId();
        LoggedInProfile.getProfile().logIn(createdGuideId);
        assertTrue(LoggedInProfile.getProfile().getLoggedInProfileId() == createdGuideId);
        assertFalse(LoggedInProfile.getProfile().getLoggedInProfileId() == 100000000);
        LoggedInProfile.getProfile().logOut();
        guideJsonRepository.deleteGuide(createdGuideId);
    }

    @Test
    public void guideCanLogOut(){
        Guide createdGuide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide");
        int createdGuideId = createdGuide.getProfileId();
        LoggedInProfile.getProfile().logIn(createdGuideId);
        assertTrue(createdGuideId == LoggedInProfile.getProfile().getLoggedInProfileId());

        LoggedInProfile.getProfile().logOut();
        assertFalse(LoggedInProfile.getProfile().getLoggedInProfileId() == createdGuideId);
        guideJsonRepository.deleteGuide(createdGuideId);
    }


    @Test
    public void guide_can_edit_profile(){
        Guide createdGuide = guideJsonRepository.createGuide("guide", "password", "firstname", "lastname", "email");
        String oldUsername = createdGuide.getUsername();
        String oldPassword = createdGuide.getPassword();
        String oldFirstname = createdGuide.getFirstname();
        String oldLastname = createdGuide.getLastname();
        String oldEmail = createdGuide.getEmail();

        LoggedInProfile.getProfile().logIn(createdGuide.getProfileId());
        guideJsonRepository.editGuideInfo("newUsername", "newPassword", "newFirstname", "newLastname", "newEmail");

        assertFalse(createdGuide.getUsername().equals(oldUsername));
        assertFalse(createdGuide.getPassword().equals(oldPassword));
        assertFalse(createdGuide.getFirstname().equals(oldFirstname));
        assertFalse(createdGuide.getLastname().equals(oldLastname));
        assertFalse(createdGuide.getLastname().equals(oldEmail));

        LoggedInProfile.getProfile().logOut();
        guideJsonRepository.deleteGuide(createdGuide.getProfileId());
    }


    @Test
    public void checkGuideExistence(){
        Guide createdGuide1 = guideJsonRepository.createGuide("CheckIfGuideExists", "password", "firstname", "lastname", "email");

        assertEquals(guideJsonRepository.checkGuideExistans("CheckIfGuideExists"), createdGuide1.getProfileId());

        guideJsonRepository.deleteGuide(createdGuide1.getProfileId());
    }





}
