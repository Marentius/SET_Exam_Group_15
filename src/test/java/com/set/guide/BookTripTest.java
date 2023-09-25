package com.set.guide;

import com.set.guide.models.Trip;
import com.set.guide.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

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
        int originalTriplist = userList.getUserTrip().size();

        userList.addTrip(oslo);

        int changedTriplist = userList.getUserTrip().size();

        assertTrue(originalTriplist < changedTriplist);
    }

    @RepeatedTest(50)
    public void book_several_trips_test() {
        int originalTriplist = userList.getUserTrip().size();

        userList.addTrip(oslo);
        userList.addTrip(oslo);
        userList.addTrip(oslo);
        userList.addTrip(oslo);

        int changedTripList = userList.getUserTrip().size();

        assertTrue(originalTriplist < changedTripList);
    }

}
