package com.set.mvp.panels.guide;

import com.set.mvp.models.Guide;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.GuideJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateGuide extends InitApp {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton logOutButton;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JButton createGuideButton;
    private GuideJsonRepository guideJsonRepository;

    public CreateGuide(String title) {
        super(title);
        start_gui(mainPanel, 800,400);

        guideJsonRepository = new GuideJsonRepository("/database/guide.json");
        createGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guideJsonRepository.createGuide(txtUsername.getText(), txtPassword.getText(), txtFirstName.getText(), txtLastName.getText(), txtEmail.getText(), new ArrayList<>());
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(CreateGuide.this, new StartPanelLogIn("Log In"));
            }
        });
    }
}
