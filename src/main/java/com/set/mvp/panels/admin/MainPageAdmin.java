package com.set.mvp.panels.admin;

import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageAdmin extends InitApp {
    private JButton logOutButton;
    private JPanel mainPanel;
    private JButton viewUsersButton;
    private JButton reportUserButton;

    public MainPageAdmin(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new StartPanelLogIn("Log in"));
            }
        });
        viewUsersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageAdmin.this, new ViewUsersAdmin("View Users Admin"));
            }
        });
    }
}
