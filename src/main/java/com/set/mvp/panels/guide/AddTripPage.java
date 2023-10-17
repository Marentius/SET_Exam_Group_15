package com.set.mvp.panels.guide;

import com.set.mvp.models.Guide;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.TripJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

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
    private TripJsonRepository tripJsonRepository;
    private GuideJsonRepository guideJsonRepository;

    public AddTripPage(String title) {
        super(title);
        start_gui(mainPanel,800,400);

        tripJsonRepository = new TripJsonRepository("/database/trip.json");
        guideJsonRepository = new GuideJsonRepository("/database/guide.json");

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
        addTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Guide guide : guideJsonRepository.getGuides()) {
                    if (LoggedInProfile.getProfile().getLoggedInProfileId() == guide.getProfileId()){
                        tripJsonRepository.addTrip(txtTitle.getText(), txtLocation.getText(), txtDescription.getText(), guide, Double.parseDouble(txtPrice.getText()),
                                Integer.parseInt(txtPrice.getText()), LocalDate.of(Integer.parseInt(txtDateYear.getText()), Integer.parseInt(txtDateMonth.getText()),
                                        Integer.parseInt(txtDateDay.getText())), new ArrayList<>());
                    }
                }
            }
        });
    }
}
