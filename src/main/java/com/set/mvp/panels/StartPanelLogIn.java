package com.set.mvp.panels;

import com.set.mvp.panels.admin.MainPageAdmin;
import com.set.mvp.panels.guide.MainPageGuide;
import com.set.mvp.panels.user.CreateUser;
import com.set.mvp.panels.user.MainPageUser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanelLogIn extends InitApp {
    private JPanel mainPanel;
    private JTextField txtUsername;
    private JButton logInAsUserButton;
    private JButton logInAsGuideButton;
    private JButton logInAsAdminButton;
    private JButton createUserButton;
    private JButton createGuideButton;
    private JPasswordField txtPassword;

    public StartPanelLogIn(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        logInAsUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(StartPanelLogIn.this, new MainPageUser("Main page"));
            }
        });
        logInAsGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(StartPanelLogIn.this, new MainPageGuide("Main Page"));
            }
        });
        logInAsAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(StartPanelLogIn.this, new MainPageAdmin("Main page"));
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(StartPanelLogIn.this, new CreateUser("Create User"));
            }
        });
    }
}
