package com.set.mvp.panels.guide;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.GuideJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageGuide extends InitApp {
    private JButton logOutButton;
    private JPanel mainPanel;
    private JButton addTripButton;
    private JButton editUserButton;
    private JButton viewAndManageYourButton;
    private JLabel welcome;
    private GuideJsonRepository guideJsonRepository;

    public MainPageGuide(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        guideJsonRepository = new GuideJsonRepository();

        welcome.setText(guideJsonRepository.getLoggedInGuide().getFirstname() + " " + guideJsonRepository.getLoggedInGuide().getLastname());

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageGuide.this, new StartPanelLogIn("Log in"));
                LoggedInProfile.getProfile().logOut();
            }
        });
        editUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageGuide.this, new EditGuidePage("Edit User"));
            }
        });
        addTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageGuide.this, new AddTripPage("Add Trip Page"));
            }
        });
        viewAndManageYourButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(MainPageGuide.this, new ViewAndManageGuideTrips("View and manage Guide trips"));
            }
        });
    }
}
