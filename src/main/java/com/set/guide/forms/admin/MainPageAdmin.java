package com.set.guide.forms.admin;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageAdmin extends InitApp {
    private JButton logOutButton;
    private JPanel mainPanel;
    private JButton etEllerAnnetButton;
    private JButton reportUserButton;

    public MainPageAdmin(String title) {
        super(title);
        start_gui(mainPanel);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new LogIn("Log in"));
            }
        });
    }
}
