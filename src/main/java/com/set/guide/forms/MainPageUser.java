package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageUser extends InitGui{
    private JPanel mainPanel;
    private JButton editUserButton;
    private JButton bookTripButton;
    private JButton logOutButton;

    public MainPageUser(String title) {
        super(title);
        start_gui(mainPanel);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_window(MainPageUser.this, new LogIn("Log in"));
            }
        });
    }
}
