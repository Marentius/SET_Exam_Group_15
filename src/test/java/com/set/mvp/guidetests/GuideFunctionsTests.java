package com.set.mvp.guidetests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;

import com.set.mvp.models.User;

import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class GuideFunctionsTests {
    private GuideJsonRepository guideJsonRepository;
    private TripJsonRepository tripJsonRepository;
    private UserJsonRepository userJsonRepository;
    @BeforeEach
        public void init(){
           guideJsonRepository = new GuideJsonRepository();
           userJsonRepository = new UserJsonRepository();
           tripJsonRepository = new TripJsonRepository();

        }


    @Test
    public void guide_can_create_profile() {
        ArrayList<Guide> guidesOriginal = guideJsonRepository.getGuides();
        Guide createdGuide = guideJsonRepository.createGuide("Guide123", "Guide", "Guide", "Guide", "Guide");
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

        Guide guide = guideJsonRepository.createGuide("Guide12421", "Guide", "Guide", "Guide", "Guide");
        Trip trip = tripJsonRepository.addTrip("Guide", "Guide", "Guide", guide, 1000, 100, null);

        guide.addTrip(trip);
        boolean isTripInTripList = false;

        for (Trip trip1 : guide.getTrips()){
            if (trip1.getTripId() == trip.getTripId()){
                isTripInTripList = true;
                break;
            }
        }
        assertTrue(isTripInTripList);
        tripJsonRepository.deleteTrip(trip.getTripId());

        guideJsonRepository.deleteGuide(guide.getProfileId());
    }

    @Test
    public void guide_can_cancel_trip(){
        Guide guide = new Guide("Guid123e", "Guide", "Guide", "Guide", "Guide", 100);

        Trip trip = new Trip("Oslo", 100);
        Trip trip1 = new Trip("Tønsberg", 100);

        guide.addTrip(trip);
        guide.addTrip(trip1);

        int tripListSize = guide.getTrips().size();

        guide.deleteTrip(trip);
        tripJsonRepository.deleteTrip(trip.getTripId());
        tripJsonRepository.deleteTrip(trip1.getTripId());

        assertTrue(tripListSize > guide.getTrips().size());
    }

    @Test
    public void guide_can_log_in(){
        Guide createdGuide = guideJsonRepository.createGuide("Guid876e", "Guide", "Guide", "Guide", "Guide");
        int createdGuideId = createdGuide.getProfileId();
        LoggedInProfile.getProfile().logIn(createdGuideId);
        assertTrue(LoggedInProfile.getProfile().getLoggedInProfileId() == createdGuideId);
        assertFalse(LoggedInProfile.getProfile().getLoggedInProfileId() == 100000000);
        LoggedInProfile.getProfile().logOut();
        guideJsonRepository.deleteGuide(createdGuideId);
    }

    @Test
    public void guideCanLogOut(){
        Guide createdGuide = guideJsonRepository.createGuide("Guideeee", "Guide", "Guide", "Guide", "Guide");
        int createdGuideId = createdGuide.getProfileId();
        LoggedInProfile.getProfile().logIn(createdGuideId);
        assertTrue(createdGuideId == LoggedInProfile.getProfile().getLoggedInProfileId());

        LoggedInProfile.getProfile().logOut();
        assertFalse(LoggedInProfile.getProfile().getLoggedInProfileId() == createdGuideId);
        guideJsonRepository.deleteGuide(createdGuideId);
    }
  
    @Test
    public void guide_can_edit_profile(){
        Guide createdGuide = guideJsonRepository.createGuide("Guide", "Guide", "Guide", "Guide", "Guide");

        String oldUsername = createdGuide.getUsername();
        String oldPassword = createdGuide.getPassword();
        String oldFirstname = createdGuide.getFirstname();
        String oldLastname = createdGuide.getLastname();
        String oldEmail = createdGuide.getEmail();

        LoggedInProfile.getProfile().logIn(createdGuide.getProfileId());

        guideJsonRepository.editGuideInfo("New Username", "New password", "New firstname", "New lastname", "New email");

        assertFalse(createdGuide.getUsername().equals(oldUsername));
        assertFalse(createdGuide.getPassword().equals(oldPassword));
        assertFalse(createdGuide.getFirstname().equals(oldFirstname));
        assertFalse(createdGuide.getLastname().equals(oldLastname));
        assertFalse(createdGuide.getLastname().equals(oldEmail));

        LoggedInProfile.getProfile().logOut();
        guideJsonRepository.deleteGuide(createdGuide.getProfileId());
    }



   /* @Test
    public void deleteTripFromAllUsersTest(){
        User createdUser = userJsonRepository.createUser("tripUsersCanDeleteTripsFromAllUsers", "password", "firstname", "lastname", "email", new ArrayList<>());
        Guide createdGuide = guideJsonRepository.createGuide("DummyGuide", "guide", "guide", "test", "email");

        Trip trip = tripJsonRepository.addTrip("tripUsersCanDeleteTripsFromAllUsers", "loc", "desc", createdGuide, 100, 100, LocalDate.of(2024, 01,01), new ArrayList<>());

        LoggedInProfile.getProfile().logIn(createdUser.getProfileId());
        userJsonRepository.bookTrip(trip);

        tripJsonRepository.deleteTripFromAllUserTripLists(trip.getTripId());

        assertFalse(createdUser.getTrips().contains(trip));

        userJsonRepository.deleteUser(createdUser.getProfileId());

    }*/



    @Test
    public void checkIfGuideExists(){
        Guide createdGuide = guideJsonRepository.createGuide("checkifguideexists", "pas", "name", "name", "mail");

        assertEquals(guideJsonRepository.checkGuideExistansReturnProfileId("checkifguideexists"), createdGuide.getProfileId());

        guideJsonRepository.deleteGuide(createdGuide.getProfileId());

    }



}
