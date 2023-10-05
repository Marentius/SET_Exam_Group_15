package com.set.mvp.usertests;

import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.*;

public class BookTripTest {

    final User userList = new User("Test", "Test", "Test", 1);
    private Trip oslo;

    @BeforeEach
    public void init(){
        oslo = new Trip("Oslo", 100);
    }

    @RepeatedTest(50)
    public void book_one_trip_test() {
        int originalTriplist = userList.getTrips().size();

        userList.addTrip(oslo);

        int changedTriplist = userList.getTrips().size();

        assertTrue(originalTriplist < changedTriplist);
    }

    @RepeatedTest(50)
    public void book_several_trips_test() {
        int originalTriplist = userList.getTrips().size();

        userList.addTrip(oslo);
        userList.addTrip(oslo);
        userList.addTrip(oslo);
        userList.addTrip(oslo);

        int changedTripList = userList.getTrips().size();

        assertTrue(originalTriplist < changedTripList);
    }

}
