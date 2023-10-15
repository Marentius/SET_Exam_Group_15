package com.set.mvp.usertests;

import com.set.mvp.models.User;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserAndEditUserTest {
    UserJsonRepository userJsonRepository = new UserJsonRepository("database/user.json");
    ArrayList<User> users = userJsonRepository.getUsers();
    @Test
    public void user_can_create_user(){
        User createdUser = new User("Robene", "123", "Robin", "Enerhaugen",
                "Robin.enerhaugen@hotmail.com", 100, null);
        boolean isProfileIdInList = false;
        for (User user : users){
            if (user.getProfileId() == 100){
                isProfileIdInList = true;
                break;
            }
        }
        assertTrue(isProfileIdInList);

    }

    @Test
    public void user_can_edit_user_info() {

        //User user = new User("originalFirstname", "originalLastname", "originalEmail", 1);

        //user.editUserInfo("newFirstname", "newLastname", "newEmail");

        //assertEquals("newFirstname", user.getFirstname();
        //assertEquals("newLastname", user.getLastname();
        //assertEquals("newEmail", user.getEmail());

        fail("Method not implemented");
    }

    @Test
    public void user_can_change_passoword(){
        fail("Method not implemented yet");
    }


}
