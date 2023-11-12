package com.set.mvp.usertests;

import com.set.mvp.models.Trip;
import com.set.mvp.repository.TripJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ViewTripsTest {

    private TripJsonRepository tripJsonRepository;

    @BeforeEach
    public void init(){
        tripJsonRepository = new TripJsonRepository();
    }
    @Test
    public void user_can_view_all_trips(){
        ArrayList<Trip> trips = tripJsonRepository.getTrips();

        assertArrayEquals(trips.toArray(), tripJsonRepository.getTrips().toArray());
    }


}
