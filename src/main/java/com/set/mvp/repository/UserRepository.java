package com.set.mvp.repository;

import com.set.mvp.models.Trip;
import com.set.mvp.models.User;

import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getUsers();
    User createUser(String username, String password, String firstname, String lastname, String email, ArrayList<Trip> trips);
    void deleteUser(int profileId);
}
