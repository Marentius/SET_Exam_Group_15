package com.set.guide.forms;

import javax.swing.*;

public class HomePage {
    public static void createHomePage(){
        JFrame mainSite = new JFrame();
        mainSite.setSize(500, 500);
        mainSite.setLayout(null);


        JButton profilePageButton = new JButton("Profil");
        profilePageButton.setBounds(350, 30, 100, 40);
        mainSite.add(profilePageButton);
        mainSite.setVisible(true);

    }
}
