package com.set.mvp.panels.user;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.models.Trip;
import com.set.mvp.repository.TripJsonRepository;
import com.set.mvp.repository.UserJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BookTripUser extends InitApp {
    private JList<Trip> tripJlist;
    private JPanel mainPanel;
    private JButton bookTripButton;
    private JButton homeButton;
    private JButton logOutButton;
    private DefaultListModel<Trip> listModel;
    private TripJsonRepository tripJsonRepository;
    private UserJsonRepository userJsonRepository;

    public BookTripUser(String title) {
        super(title);
        start_gui(mainPanel, 1500, 400);
        if (LoggedInProfile.getProfile().isLoggedIn()) {
            System.out.println("User is logged in");
        }

        tripJsonRepository = new TripJsonRepository("/database/trip.json");
        userJsonRepository = new UserJsonRepository("/database/user.json");

        listModel = new DefaultListModel<>();
        tripJlist.setModel(listModel);

        updateTripList();
        System.out.println(LoggedInProfile.getProfile().getLoggedInProfileId());

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(BookTripUser.this, new StartPanelLogIn("Log in"));
                LoggedInProfile.getProfile().logOut();
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(BookTripUser.this, new MainPageUser("Main Page User"));
            }
        });
        bookTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userJsonRepository.bookTrip(tripJlist.getSelectedValue());
                JOptionPane.showMessageDialog(BookTripUser.this, "The trip: " + tripJlist.getSelectedValue().getTitle() + " was successfully added to your trips");
            }
        });
    }

    private void updateTripList() {
        ArrayList<Trip> trips = tripJsonRepository.getTrips();
        listModel.clear();
        for (Trip trip : trips) {
            listModel.addElement(trip);
        }
    }
}
