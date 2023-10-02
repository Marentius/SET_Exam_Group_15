package com.set.guide.forms.user;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;
import com.set.guide.models.Trip;
import com.set.guide.repository.TripJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class BookTripUser extends InitApp {
    private JList<Trip> tripJlist;
    private JPanel mainPanel;
    private JButton bookTripButton;
    private JButton homeButton;
    private JButton logOutButton;
    private DefaultListModel<Trip> listModel;
    private TripJsonRepository tripJsonRepository;

    public BookTripUser(String title) {
        super(title);
        start_gui(mainPanel, 1500, 400);

        tripJsonRepository = new TripJsonRepository("/data/trip.json");

        listModel = new DefaultListModel<>();
        tripJlist.setModel(listModel);

        tripJsonRepository.addPropertyChangeListener(evt -> {
            updateTripList();
        });

        updateTripList();

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(BookTripUser.this, new LogIn("Log in"));
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(BookTripUser.this, new MainPageUser("Main Page User"));
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
