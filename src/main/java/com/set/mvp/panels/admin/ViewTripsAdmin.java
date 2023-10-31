package com.set.mvp.panels.admin;

import com.set.mvp.models.Trip;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.TripJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewTripsAdmin extends InitApp {
    private JList<Trip> tripJList;
    private JPanel mainPanel;
    private JButton deleteTripButton;
    private JButton homeButton;
    private JButton logPutButton;
    private DefaultListModel<Trip> listModel;
    private TripJsonRepository tripJsonRepository;

    public ViewTripsAdmin(String title) {
        super(title);
        start_gui(mainPanel, 1500, 400);

        tripJsonRepository = new TripJsonRepository("/database/trip.json");

        listModel = new DefaultListModel<>();
        tripJList.setModel(listModel);

        updateTripList();

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewTripsAdmin.this, new MainPageAdmin("Main Page"));
            }
        });
        logPutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewTripsAdmin.this, new StartPanelLogIn("Log In"));
            }
        });
        deleteTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trip selectedTrip = tripJList.getSelectedValue();

                if (selectedTrip != null){
                    tripJsonRepository.deleteTrip(selectedTrip.getTripId());
                    JOptionPane.showMessageDialog(mainPanel, "The trip: " + tripJList.getSelectedValue().getTitle() + " was successfully deleted");

                    updateTripList();
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Please select a trip to delete");
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
