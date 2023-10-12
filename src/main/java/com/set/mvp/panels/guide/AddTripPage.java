package com.set.mvp.panels.guide;

import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddTripPage extends InitApp {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton logOutButton;
    private JTextField txtTitle;
    private JTextField txtLocation;
    private JTextField txtDescription;
    private JTextField txtPrice;
    private JTextField txtDuration;
    private JTextField txtDateYear;
    private JTextField txtDateMonth;
    private JTextField txtDateDay;
    private JButton addTripButton;

    public AddTripPage(String title) {
        super(title);
        start_gui(mainPanel,800,400);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(AddTripPage.this, new MainPageGuide("Main Page Guide"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(AddTripPage.this, new StartPanelLogIn("Log In"));
            }
        });
    }
}
