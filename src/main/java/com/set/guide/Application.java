package com.set.guide;

import com.set.guide.forms.HomePage;
import com.set.guide.forms.LogIn;
import com.set.guide.models.Trip;
import com.set.guide.models.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Application {
    public static void main(String[] args) {
        Trip oslo = new Trip("Oslo", 100);
        Trip sarp = new Trip("Sarpsborg", 200);
        User tripList = new User("Test", "Test", "Test", 1);

        tripList.addTrip(oslo);
        tripList.addTrip(sarp);

        System.out.println(tripList);

        tripList.deleteTrip(oslo);

        System.out.println(tripList);


        HomePage.createHomePage();
    }
}

