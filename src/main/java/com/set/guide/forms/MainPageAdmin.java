package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageAdmin extends InitGui{
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
                new_window(MainPageAdmin.this, new LogIn("Log in"));
            }
        });
    }
}
