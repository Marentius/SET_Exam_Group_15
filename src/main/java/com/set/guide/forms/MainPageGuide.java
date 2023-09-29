package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGuide extends InitGui{
    private JButton logOutButton;
    private JPanel mainPanel;
    private JButton addTripButton;
    private JButton editUserButton;

    public MainPageGuide(String title) {
        super(title);
        start_gui(mainPanel);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_window(MainPageGuide.this, new LogIn("Log in"));
            }
        });
    }
}
