package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn extends InitGui{
    private JPanel mainPanel;
    private JTextField txtFirstName;
    private JTextField txtLastName;
    private JTextField txtEmail;
    private JButton logInAsUserButton;
    private JButton logInAsGuideButton;
    private JButton logInAsAdminButton;
    private JButton createUserButton;
    private JButton createGuideButton;

    public LogIn(String title) {
        super(title);
        start_gui(mainPanel);

        logInAsUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_window(LogIn.this, new MainPageUser("Main page"));
            }
        });
        logInAsGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_window(LogIn.this, new MainPageGuide("Main Page"));
            }
        });
        logInAsAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_window(LogIn.this, new MainPageAdmin("Main page"));
            }
        });
    }
}
