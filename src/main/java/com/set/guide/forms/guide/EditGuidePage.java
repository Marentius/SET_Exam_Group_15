package com.set.guide.forms.guide;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;

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

    public EditGuidePage(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(EditGuidePage.this, new MainPageGuide("Main Page"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(EditGuidePage.this, new LogIn("log In"));
            }
        });
    }
}
