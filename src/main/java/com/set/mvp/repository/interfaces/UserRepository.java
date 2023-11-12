package com.set.mvp.repository.interfaces;

import com.set.mvp.models.Trip;
import com.set.mvp.models.User;

import javax.swing.*;
import java.util.ArrayList;

public interface UserRepository {
    ArrayList<User> getUsers();
    User getLoggedInUser();
    User createUser(String username, String password, String firstname, String lastname, String email, ArrayList<Trip> trips);
    void deleteUser(int profileId);
    void editUserInfo(String username, String password, String firstname, String lastname, String email);
    void bookTrip(Trip trip);
    ArrayList<Trip> getTrips(int profileId);
    void unbookTrip(Trip trip);
}
