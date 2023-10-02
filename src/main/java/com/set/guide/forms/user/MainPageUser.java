package com.set.guide.forms.user;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;

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

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageUser.this, new LogIn("Log in"));
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
