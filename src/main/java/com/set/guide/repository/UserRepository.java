package com.set.guide.repository;

import com.set.guide.models.Trip;
import com.set.guide.models.User;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getUsers();
    User createUser(String username, String password, String firstname, String lastname,
                    String email, String phoneNumber, String address, ArrayList<Trip> trips);
    void deleteUser(int profileId);
}
