package com.set.mvp.usertests;

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

    /*@Test
    public void user_can_edit_user_info() {

        User user = new User("originalFirstname", "originalLastname", "originalEmail", 1);

        user.editUserInfo("newFirstname", "newLastname", "newEmail");

        assertEquals("newFirstname", user.getFirstname();
        assertEquals("newLastname", user.getLastname();
        assertEquals("newEmail", user.getEmail());

        fail("Method not implemented");
    }

    @Test
    public void user_can_change_passoword(){
        fail("Method not implemented yet");
    }*/


}
