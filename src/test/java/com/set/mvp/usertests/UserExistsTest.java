package com.set.mvp.usertests;

import com.set.mvp.models.User;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserExistsTest {
    UserJsonRepository userJsonRepository;

    @BeforeEach
    public void init(){
        userJsonRepository = new UserJsonRepository();
    }


/*
    @Test
    public void userExists(){
        User createdUser = userJsonRepository.createUser("UserExistsTest", "User", "Fnmae",  "lname", "email", null);
        assertEquals(userJsonRepository.checkUserExistansReturnProfileId("UserExistsTest"),createdUser.getProfileId());

        userJsonRepository.deleteUser(createdUser.getProfileId());

    }


 */




}
