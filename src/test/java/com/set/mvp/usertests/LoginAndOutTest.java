package com.set.mvp.usertests;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.User;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LoginAndOutTest {
    private UserJsonRepository userJsonRepository;
    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository();
    }
    @Test
    public void user_can_log_in(){
        User createduser = userJsonRepository.createUser("user", "user", "user", "user", "user", new ArrayList<>());
        int createdUserId = createduser.getProfileId();
        LoggedInProfile.getProfile().logIn(createdUserId);
        assertTrue(LoggedInProfile.getProfile().getLoggedInProfileId() == createdUserId);
        assertFalse(LoggedInProfile.getProfile().getLoggedInProfileId() == 100000);
        LoggedInProfile.getProfile().logOut();
        userJsonRepository.deleteUser(createdUserId);
    }

    @Test
    public void user_can_log_out(){
        User createduser = userJsonRepository.createUser("user", "user", "user", "user", "user", new ArrayList<>());
        int createdUserId = createduser.getProfileId();
        LoggedInProfile.getProfile().logIn(createdUserId);
        assertTrue(LoggedInProfile.getProfile().getLoggedInProfileId() == createdUserId);
        LoggedInProfile.getProfile().logOut();
        assertFalse(LoggedInProfile.getProfile().getLoggedInProfileId() == createdUserId);
        userJsonRepository.deleteUser(createdUserId);
    }
}
