package com.set.guide.forms.guide;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;
import com.set.guide.forms.user.EditUserPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGuide extends InitApp {
    private JButton logOutButton;
    private JPanel mainPanel;
    private JButton addTripButton;
    private JButton editUserButton;

    public MainPageGuide(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageGuide.this, new LogIn("Log in"));
            }
        });
        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageGuide.this, new EditGuidePage("Edit User"));
            }
        });
    }
}
