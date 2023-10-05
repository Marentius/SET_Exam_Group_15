package com.set.guide.forms;

import com.set.guide.forms.admin.MainPageAdmin;
import com.set.guide.forms.guide.MainPageGuide;
import com.set.guide.forms.user.CreateUser;
import com.set.guide.forms.user.MainPageUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends InitApp {
    private JPanel mainPanel;
    private JTextField txtUsername;
    private JButton logInAsUserButton;
    private JButton logInAsGuideButton;
    private JButton logInAsAdminButton;
    private JButton createUserButton;
    private JButton createGuideButton;
    private JPasswordField txtPassword;

    public LogIn(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        logInAsUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(LogIn.this, new MainPageUser("Main page"));
            }
        });
        logInAsGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(LogIn.this, new MainPageGuide("Main Page"));
            }
        });
        logInAsAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(LogIn.this, new MainPageAdmin("Main page"));
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(LogIn.this, new CreateUser("Create User"));
            }
        });
    }
}
