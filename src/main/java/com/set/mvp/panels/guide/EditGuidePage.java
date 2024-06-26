package com.set.mvp.panels.guide;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.GuideJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditGuidePage extends InitApp {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton logOutButton;
    private JButton saveButton;
    private JTextField txtNewUsernameGuide;
    private JPasswordField txtNewPasswordGuide;
    private JTextField txtNewFirstnameGuide;
    private JTextField txtNewLastnameGuide;
    private JTextField txtNewEmailGuide;
    private JLabel username;
    private JLabel password;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel email;
    private GuideJsonRepository guideJsonRepository;

    public EditGuidePage(String title) {
        super(title);
        start_gui(mainPanel, 800, 550);

        guideJsonRepository = new GuideJsonRepository();

        username.setText(guideJsonRepository.getLoggedInGuide().getUsername());
        password.setText(guideJsonRepository.getLoggedInGuide().getPassword());
        firstName.setText(guideJsonRepository.getLoggedInGuide().getFirstname());
        lastName.setText(guideJsonRepository.getLoggedInGuide().getLastname());
        email.setText(guideJsonRepository.getLoggedInGuide().getEmail());

        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(EditGuidePage.this, new MainPageGuide("Main Page"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(EditGuidePage.this, new StartPanelLogIn("log In"));
                LoggedInProfile.getProfile().logOut();
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guideJsonRepository.editGuideInfo(txtNewUsernameGuide.getText(), txtNewPasswordGuide.getText(), txtNewFirstnameGuide.getText(), txtNewLastnameGuide.getText(), txtNewEmailGuide.getText());
                JOptionPane.showMessageDialog(mainPanel, "User info successfully edited");
                new_panel(EditGuidePage.this, new MainPageGuide("Main Page Guide"));
            }
        });
    }
}
