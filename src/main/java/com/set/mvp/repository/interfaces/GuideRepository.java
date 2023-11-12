package com.set.mvp.repository.interfaces;

import com.set.mvp.models.Guide;

import java.util.ArrayList;

public interface GuideRepository {
    Guide getLoggedInGuide();
    ArrayList<Guide> getGuides();
    Guide createGuide(String username, String password, String firstname, String lastname,  String email);
    void deleteGuide(int profileId);
    void editGuideInfo(String username, String password, String firstname, String lastname, String email);
}
