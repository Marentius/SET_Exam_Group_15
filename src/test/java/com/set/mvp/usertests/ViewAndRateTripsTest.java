package com.set.mvp.usertests;

import com.set.mvp.models.User;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ViewAndRateTripsTest {

    private UserJsonRepository userJsonRepository;

    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository("/database/user.json");
    }
    @Test
    public void user_can_view_all_trips(){
        ArrayList<User> userRep = userJsonRepository.getUsers();

        assertArrayEquals(userRep.toArray(), userJsonRepository.getUsers().toArray());
    }

    @Test
    public void user_can_rate_trips(){
        fail("Method not implemented yet");
    }

}
