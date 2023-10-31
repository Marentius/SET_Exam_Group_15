package com.set.mvp.panels.user;

import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.UserJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUserPage extends InitApp {
    private JButton homeButton;
    private JButton logOutButton;
    private JButton saveButton;
    private JTextField txtNewUsername;
    private JPasswordField txtNewPassword;
    private JTextField txtNewFirstname;
    private JTextField txtNewLastName;
    private JTextField txtNewEmail;
    private JPanel mainPanel;
    private UserJsonRepository userJsonRepository;

    public EditUserPage(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        userJsonRepository = new UserJsonRepository("/database/user.json");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(EditUserPage.this, new MainPageUser("Main Page User"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(EditUserPage.this, new StartPanelLogIn("Log in"));
            }
        });
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtNewUsername.getText().equals("")){

                } else {
                    userJsonRepository.editUserInfo(
                            txtNewUsername.getText(),
                            txtNewPassword.getText(),
                            txtNewFirstname.getText(),
                            txtNewLastName.getText(),
                            txtNewEmail.getText());
                }

            }
        });
    }
}
