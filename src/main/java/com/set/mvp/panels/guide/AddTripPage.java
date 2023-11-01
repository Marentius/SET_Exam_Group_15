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
    private JButton addTripButton;
    private JComboBox dayComboBox;
    private JComboBox yearComboBox;
    private JComboBox MonthComboBox;
    private JComboBox priceComboBox;
    private JComboBox durationComboBox;
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
                LoggedInProfile.getProfile().logOut();
            }
        });
        addTripButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Guide guide : guideJsonRepository.getGuides()) {
                    if (LoggedInProfile.getProfile().getLoggedInProfileId() == guide.getProfileId()){
                        if (txtTitle.getText().isEmpty()
                                || txtLocation.getText().isEmpty()
                                || txtDescription.getText().isEmpty()
                                || "".equals(priceComboBox.getSelectedItem())
                                || "".equals(durationComboBox.getSelectedItem())
                                || "".equals(yearComboBox.getSelectedItem())
                                || "".equals(MonthComboBox.getSelectedItem())
                                || "".equals(dayComboBox.getSelectedItem())){
                            JOptionPane.showMessageDialog(mainPanel, "All fields must be provided and cannot be empty or null.");
                            return;
                        }
                        tripJsonRepository.addTrip(txtTitle.getText(),
                                txtLocation.getText(),
                                txtDescription.getText(),
                                guide,
                                Double.parseDouble((String) priceComboBox.getSelectedItem()),
                                Integer.parseInt((String) durationComboBox.getSelectedItem()),
                                LocalDate.of(Integer.parseInt((String) yearComboBox.getSelectedItem()), Integer.parseInt((String) MonthComboBox.getSelectedItem()), Integer.parseInt((String) dayComboBox.getSelectedItem())),
                                new ArrayList<>());

                        JOptionPane.showMessageDialog(mainPanel, "The trip: " + txtTitle.getText() + " was successfully added.");

                        new_panel(AddTripPage.this, new MainPageGuide("Main Page Guide"));
                    }
                }
            }
        });
    }
}
