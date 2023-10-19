package com.set.mvp.admintests;

import com.set.mvp.models.Guide;
import com.set.mvp.models.User;
import com.set.mvp.panels.admin.ViewGuidesAdmin;
import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




import static org.junit.jupiter.api.Assertions.*;

public class AdminFunctionsTest {
    GuideJsonRepository guideJsonRepository;
    UserJsonRepository userJsonRepository;
    ViewGuidesAdmin viewGuidesAdmin;

    @BeforeEach
    public void init() {
        guideJsonRepository = new GuideJsonRepository("/database/guide.json");
        userJsonRepository = new UserJsonRepository("/database/user.json");
        viewGuidesAdmin = new ViewGuidesAdmin("Admin Can View Guides");


    }

    @Test
    public void adminCanDeleteGuideTest() {

        Guide createdGuide = guideJsonRepository.createGuide("DeleteGuide", "123", "Guide", "Guide", "Guide", null);

        guideJsonRepository.deleteGuide(createdGuide.getProfileId());
        boolean isProfileInIdList = false;
        for (Guide guide : guideJsonRepository.getGuides()) {
            if (guide.getProfileId() == (createdGuide.getProfileId())) {
                isProfileInIdList = true;
                break;
            }

        }
        assertFalse(isProfileInIdList);
    }
    @Test
    public void adminCanDeleteUserTest() {
        User createdUser = userJsonRepository.createUser("User", "User", "User", "User", "User", null);
        boolean isProfileInIdList = false;
        userJsonRepository.deleteUser(createdUser.getProfileId());

        for (User user : userJsonRepository.getUsers()) {
            if (user.getProfileId() == (createdUser.getProfileId())) {
                isProfileInIdList = true;
                break;
            }
        }
        assertFalse(isProfileInIdList);
    }

/*
    @Test
    public void adminCanViewAllUsers(){

    }
    @Test
    public void adminCanViewAllGuides() {

}
*/
}

