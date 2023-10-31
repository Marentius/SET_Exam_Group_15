package com.set.mvp.panels.user;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.UserJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewAndManageUserTrips extends InitApp {
    private JList<Trip> userTripList;
    private JPanel mainPanel;
    private JButton unbookTripButton;
    private JButton homeButton;
    private JButton logOutButton;
    private DefaultListModel<Trip> listModel;
    private UserJsonRepository userJsonRepository;

    public ViewAndManageUserTrips(String title) {
        super(title);
        start_gui(mainPanel, 1500,400);

        userJsonRepository = new UserJsonRepository("/database/user.json");

        listModel = new DefaultListModel<>();
        userTripList.setModel(listModel);

        updateTripList();
        unbookTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userJsonRepository.unbookTrip(userTripList.getSelectedValue());
                JOptionPane.showMessageDialog(ViewAndManageUserTrips.this, "The trip: " + userTripList.getSelectedValue().getTitle() + " was successfully unbooked");
                updateTripList();
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewAndManageUserTrips.this, new MainPageUser("Main Page User"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewAndManageUserTrips.this, new StartPanelLogIn("Log in"));
                LoggedInProfile.getProfile().logOut();
            }
        });
    }
    private void updateTripList() {
        ArrayList<Trip> trips = userJsonRepository.getTrips(LoggedInProfile.getProfile().getLoggedInProfileId());
        listModel.clear();
        for (Trip trip : trips) {
            listModel.addElement(trip);
        }
    }
}
