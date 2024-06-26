package com.set.mvp.panels.admin;

import com.set.mvp.models.Guide;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.GuideJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewGuidesAdmin extends InitApp {
    private JPanel mainPanel;
    private JList<Guide> guideJList;
    private JButton homeButton;
    private JButton logOutButton;
    private JButton deleteGuideButton;
    private DefaultListModel<Guide> listModel;
    private GuideJsonRepository guideJsonRepository;

    public ViewGuidesAdmin(String title) {
        super(title);
        start_gui(mainPanel, 800, 600);

        guideJsonRepository = new GuideJsonRepository();

        listModel = new DefaultListModel<>();
        guideJList.setModel(listModel);

        updateGuideList();
        deleteGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Guide selectedGuide = guideJList.getSelectedValue();

                if (selectedGuide != null) {
                    guideJsonRepository.deleteGuide(selectedGuide.getProfileId());
                    JOptionPane.showMessageDialog(mainPanel, "The guide: " + guideJList.getSelectedValue().getUsername() + " was successfully deleted.");

                    updateGuideList();
                } else {
                  JOptionPane.showMessageDialog(mainPanel, "Please select a guide to delete.");
                }
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewGuidesAdmin.this, new MainPageAdmin("Main Page Admin"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewGuidesAdmin.this, new StartPanelLogIn("Log In"));
                LoggedInProfile.getProfile().logOut();
            }
        });
    }
    private void updateGuideList() {
        ArrayList<Guide> guides = guideJsonRepository.getGuides();
        listModel.clear();
        for (Guide guide : guides) {
            listModel.addElement(guide);
        }
    }


}
