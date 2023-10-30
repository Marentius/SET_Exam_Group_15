package com.set.mvp.panels.guide;

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
    private GuideJsonRepository guideJsonRepository;

    public EditGuidePage(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        guideJsonRepository = new GuideJsonRepository("/database/guide.json");
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
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNewUsernameGuide.getText().equals("")){

                } else {
                    guideJsonRepository.editGuideInfo(
                            txtNewUsernameGuide.getText(),
                            txtNewPasswordGuide.getText(),
                            txtNewFirstnameGuide.getText(),
                            txtNewLastnameGuide.getText(),
                            txtNewEmailGuide.getText());
                }
            }
        });
    }
}
