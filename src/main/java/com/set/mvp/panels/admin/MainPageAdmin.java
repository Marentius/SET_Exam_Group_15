package com.set.mvp.panels.admin;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageAdmin extends InitApp {
    private JButton logOutButton;
    private JPanel mainPanel;
    private JButton viewUsersButton;
    private JButton viewGuidesButton;
    private JButton viewTripsButton;

    public MainPageAdmin(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new StartPanelLogIn("Log in"));
                LoggedInProfile.getProfile().logOut();
            }
        });
        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new ViewUsersAdmin("View Users Admin"));
            }
        });
        viewGuidesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new ViewGuidesAdmin("View Guides Admin"));
            }
        });
        viewTripsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new ViewTripsAdmin("View Trips"));
            }
        });
    }
}
