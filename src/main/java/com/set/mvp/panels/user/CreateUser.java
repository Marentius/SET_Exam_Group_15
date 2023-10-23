package com.set.mvp.panels.user;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.repository.UserJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateUser extends InitApp {
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton logOutButton;
    private JTextField txtUsername;
    private JTextField txtPassword;
    private JTextField txtFirstname;
    private JTextField txtLastname;
    private JTextField txtEmail;
    private JButton createUserButton;
    private UserJsonRepository userJsonRepository;

    public CreateUser(String title) {
        super(title);
        start_gui(mainPanel,800,400);

        userJsonRepository = new UserJsonRepository("/database/user.json");
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User user = userJsonRepository.createUser(txtUsername.getText(), txtPassword.getText(), txtFirstname.getText(), txtLastname.getText(), txtEmail.getText(), new ArrayList<>());
                JOptionPane.showMessageDialog(mainPanel, "The user: " + user.getUsername() + " was successfully created.");
                int userId = userJsonRepository.checkUserExistans(txtUsername.getText());
                LoggedInProfile.getProfile().logIn(userId);
                new_panel(CreateUser.this, new MainPageUser("Main Page"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(CreateUser.this, new StartPanelLogIn("Log In"));
            }
        });
    }

}
