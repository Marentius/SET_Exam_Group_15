package com.set.mvp.panels;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.admin.MainPageAdmin;
import com.set.mvp.panels.guide.CreateGuide;
import com.set.mvp.panels.guide.MainPageGuide;
import com.set.mvp.panels.user.CreateUser;
import com.set.mvp.panels.user.MainPageUser;
import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.UserJsonRepository;

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
    private UserJsonRepository userJsonRepository;
    private GuideJsonRepository guideJsonRepository;
    private UserJsonRepository adminJsonRepository;

    public StartPanelLogIn(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        userJsonRepository = new UserJsonRepository("/database/user.json");
        guideJsonRepository = new GuideJsonRepository("/database/guide.json");
        adminJsonRepository = new UserJsonRepository("/database/admin.json");

        logInAsUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int userId = userJsonRepository.checkUserExistansReturnProfileId(txtUsername.getText());
                if (userId != 0) {
                    LoggedInProfile.getProfile().logIn(userId);
                    new_panel(StartPanelLogIn.this, new MainPageUser("Main page User"));
                } else {
                    JOptionPane.showMessageDialog(StartPanelLogIn.this, "LogIn Failed. Try Again or create user");
                }
            }
        });
        logInAsGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int guideId = guideJsonRepository.checkGuideExistansReturnProfileId(txtUsername.getText());
                if (guideId != 0) {
                    LoggedInProfile.getProfile().logIn(guideId);
                    new_panel(StartPanelLogIn.this, new MainPageGuide("Main Page Guide"));
                } else {
                    JOptionPane.showMessageDialog(StartPanelLogIn.this, "LogIn Failed. Try Again or create guide");
                }
            }
        });
        logInAsAdminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int adminId = adminJsonRepository.checkUserExistansReturnProfileId(txtUsername.getText());
                if (adminId != 0) {
                    LoggedInProfile.getProfile().logIn(adminId);
                    new_panel(StartPanelLogIn.this, new MainPageAdmin("Main page"));
                } else {
                    JOptionPane.showMessageDialog(StartPanelLogIn.this, "LogIn Failed. Only admin can log in");
                }
            }
        });
        createUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(StartPanelLogIn.this, new CreateUser("Create User"));
            }
        });
        createGuideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(StartPanelLogIn.this, new CreateGuide("Create Guide"));
            }
        });
    }
}
