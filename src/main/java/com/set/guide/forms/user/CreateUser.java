package com.set.guide.forms.user;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;
import com.set.guide.repository.UserJsonRepository;
import com.set.guide.repository.UserRepository;

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
    private JTextField txtPhonenumber;
    private JTextField txtAddress;
    private JButton createUserButton;
    private UserJsonRepository userJsonRepository;

    public CreateUser(String title) {
        super(title);
        start_gui(mainPanel,800,400);

        userJsonRepository = new UserJsonRepository("/data/user.json");
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userJsonRepository.createUser(txtUsername.getText(), txtPassword.getText(), txtFirstname.getText(), txtLastname.getText(), txtEmail.getText(), txtPhonenumber.getText(), txtAddress.getText(), new ArrayList<>());
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(CreateUser.this, new MainPageUser("Main Page"));
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(CreateUser.this, new MainPageUser("Main Page"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(CreateUser.this, new LogIn("Log In"));
            }
        });
    }
}
