package com.set.guide;

import com.set.guide.models.Trip;
import com.set.guide.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CancelTripTest {
    final User userList = new User("Test", "Test", "Test", 1);
    private Trip oslo;
    private Trip sarpsborg;

    @BeforeEach
    public void init(){
        oslo = new Trip("Oslo", 100);
        sarpsborg = new Trip("Sarpsborg", 200);
    }


    @RepeatedTest(50)
    public void cancel_booking_test() {
        userList.addTrip(oslo);
        userList.addTrip(sarpsborg);

        int originalTriplist = userList.getUserTrip().size();

        userList.deleteTrip(oslo);

        int changedTriplist = userList.getUserTrip().size();

        assertTrue(originalTriplist > changedTriplist);
    }

    @RepeatedTest(50)
    public void cancel_several_bookings_test() {
        userList.addTrip(oslo);
        userList.addTrip(oslo);
        userList.addTrip(oslo);
        userList.addTrip(sarpsborg);
        userList.addTrip(sarpsborg);
        userList.addTrip(sarpsborg);

        int originalTripList = userList.getUserTrip().size();

        userList.deleteTrip(oslo);
        userList.deleteTrip(oslo);
        userList.deleteTrip(sarpsborg);
        userList.deleteTrip(sarpsborg);

        int changedTripList = userList.getUserTrip().size();

        assertTrue(originalTripList > changedTripList);
    }
}
