package com.set.mvp.panels.user;

import com.set.mvp.models.LoggedInUser;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageUser extends InitApp {
    private JPanel mainPanel;
    private JButton editUserButton;
    private JButton bookTripButton;
    private JButton logOutButton;

    public MainPageUser(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);
        if (LoggedInUser.getUser().isLoggedIn()) {
            System.out.println("User is logged in");
        }

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageUser.this, new StartPanelLogIn("Log in"));
                if (LoggedInUser.getUser().isLoggedIn()) {
                    LoggedInUser.getUser().logOut();
                }
            }
        });
        bookTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageUser.this, new BookTripUser("Book Trip User"));
            }
        });
        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageUser.this, new EditUserPage("Edit User"));
            }
        });
    }
}
