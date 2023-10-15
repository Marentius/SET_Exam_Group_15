package com.set.mvp.repository.interfaces;

import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;

import java.util.ArrayList;

public interface GuideRepository {
    ArrayList<Guide> getGuides();
    Guide createGuide(String username, String password, String firstname, String lastname,  String email, ArrayList<Trip> trips);
    void deleteGuide(int profileId);
}
