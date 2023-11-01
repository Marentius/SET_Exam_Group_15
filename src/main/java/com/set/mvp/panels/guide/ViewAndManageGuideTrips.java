package com.set.mvp.panels.guide;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.TripJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewAndManageGuideTrips extends InitApp {
    private JList<Trip> tripJList;
    private JPanel mainPanel;
    private JButton deleteTripButton;
    private JButton homeButton;
    private JButton logOutButton;
    private DefaultListModel<Trip> listModel;
    private TripJsonRepository tripJsonRepository;

    public ViewAndManageGuideTrips(String title) {
        super(title);
        start_gui(mainPanel, 1500, 400);

        tripJsonRepository = new TripJsonRepository("/database/trip.json");

        listModel = new DefaultListModel<>();
        tripJList.setModel(listModel);

        updateGuideTripList(LoggedInProfile.getProfile().getLoggedInProfileId());

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewAndManageGuideTrips.this, new MainPageGuide("Main Page Guide"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewAndManageGuideTrips.this, new StartPanelLogIn("Log In"));
                LoggedInProfile.getProfile().logOut();
            }
        });
        deleteTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Trip selectedTrip = tripJList.getSelectedValue();

                if (selectedTrip != null){
                    tripJsonRepository.deleteTrip(selectedTrip.getTripId());
                    tripJsonRepository.deleteTripFromAllUserTripLists(selectedTrip.getTripId());
                    JOptionPane.showMessageDialog(mainPanel, "The trip: " + tripJList.getSelectedValue().getTitle() + " was successfully deleted in your trips, and in all users tripslist who has booked the trip.");


                    updateGuideTripList(LoggedInProfile.getProfile().getLoggedInProfileId());
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Please select a trip to delete");
                }
            }
        });
    }
    private void updateGuideTripList(int specificGuideID) {
        ArrayList<Trip> allTrips = tripJsonRepository.getTrips();
        listModel.clear();
        for (Trip trip : allTrips) {
            if (trip.getGuide().getProfileId() == specificGuideID) {
                listModel.addElement(trip);
            }
        }
    }

}
