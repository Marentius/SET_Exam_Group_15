package com.set.mvp.usertests;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.User;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserAndEditUserTest {
    private UserJsonRepository userJsonRepository;

    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository("/database/user.json");
    }

    @Test
    public void user_can_create_user(){
        ArrayList<User> usersOriginal = userJsonRepository.getUsers();
        User createdUser = userJsonRepository.createUser("Robene", "123", "Robin", "Enerhaugen", "Robin.enerhaugen@hotmail.com", new ArrayList<>());

        boolean isProfileIdInList = false;
        for (User user : userJsonRepository.getUsers()){
            if (user.getProfileId() == createdUser.getProfileId()){
                isProfileIdInList = true;
                break;
            }
        }
        assertTrue(isProfileIdInList);
        assertFalse(Arrays.equals(userJsonRepository.getUsers().toArray(), usersOriginal.toArray()));

        userJsonRepository.deleteUser(createdUser.getProfileId());
    }

    @Test
    public void user_can_edit_user_info() {
        User createdUser = userJsonRepository.createUser("User","User","User","User","User", null);
        int createdUserProfileID = createdUser.getProfileId();
        String oldUsername = createdUser.getUsername();
        String oldPasword = createdUser.getPassword();
        String oldFirstname = createdUser.getFirstname();
        String oldLastname = createdUser.getLastname();
        String oldEmail = createdUser.getEmail();
        LoggedInProfile.getProfile().logIn(createdUserProfileID);
        userJsonRepository.editUserInfo("newuser", "newuser","newuser","newuser","newuser");
        assertFalse(createdUser.getUsername().equals(oldUsername));
        assertFalse(createdUser.getPassword().equals(oldPasword));
        assertFalse(createdUser.getFirstname().equals(oldFirstname));
        assertFalse(createdUser.getLastname().equals(oldLastname));
        assertFalse(createdUser.getLastname().equals(oldEmail));
        assertTrue(createdUser.getUsername().equals("newuser"));
        assertTrue(oldUsername.equals("User"));

        LoggedInProfile.getProfile().logOut();
        userJsonRepository.deleteUser(createdUserProfileID);

    }

    @Test
    public void user_can_change_passoword(){
        User createdUser = userJsonRepository.createUser("User", "User", "User", "User","User", null);
        int createdUserProfileId = createdUser.getProfileId();
        LoggedInProfile.getProfile().logIn(createdUserProfileId);
        String oldPassword = createdUser.getPassword();
        userJsonRepository.editUserInfo("User", "New_password", "User", "User", "User");
        assertFalse(oldPassword.equals(createdUser.getPassword()));
        LoggedInProfile.getProfile().logOut();
        userJsonRepository.deleteUser(createdUserProfileId);
    }


}
