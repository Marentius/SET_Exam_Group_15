package com.set.mvp.panels.user;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.User;
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
        start_gui(mainPanel, 1500, 600);

        tripJsonRepository = new TripJsonRepository();
        userJsonRepository = new UserJsonRepository();

        listModel = new DefaultListModel<>();
        tripJlist.setModel(listModel);

        updateTripList();

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

                Trip selectedTrip = tripJlist.getSelectedValue();

                if (selectedTrip == null){
                    JOptionPane.showMessageDialog(mainPanel,"Please select a trip to book.");
                    return;
                }

                //Should have the implementation below in the bookTrip method, but I left it here for simplicity.
                //JOptionPane.showMessageDialog generated unnecessary popups in the test classes.

                User loggedInUser = userJsonRepository.getLoggedInUser();
                boolean tripAlreadyBooked = false;

                for (Trip userTrip : loggedInUser.getTrips()) {
                    if (userTrip.getTripId() == selectedTrip.getTripId()) {
                        tripAlreadyBooked = true;
                        break;
                    }
                }

                if (!tripAlreadyBooked) {
                    userJsonRepository.bookTrip(selectedTrip);
                    JOptionPane.showMessageDialog(mainPanel, "The trip: " + selectedTrip.getTitle() + " was successfully added to your trips");
                } else {
                    System.out.println("Trip already booked");
                    JOptionPane.showMessageDialog(mainPanel, "Trip already booked");
                }
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
