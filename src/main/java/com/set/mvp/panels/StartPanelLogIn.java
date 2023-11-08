package com.set.mvp.panels;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.admin.MainPageAdmin;
import com.set.mvp.panels.guide.CreateGuide;
import com.set.mvp.panels.guide.MainPageGuide;
import com.set.mvp.panels.user.CreateUser;
import com.set.mvp.panels.user.MainPageUser;
import com.set.mvp.repository.GuideJsonRepository;
import com.set.mvp.repository.UserJsonRepository;
import com.set.mvp.repository.AdminJsonRepository;

import javax.swing.*;
import java.awt.event.*;

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
    private AdminJsonRepository adminJsonRepository;

    public StartPanelLogIn(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        guideJsonRepository = new GuideJsonRepository();
        adminJsonRepository = new AdminJsonRepository();
        userJsonRepository = new UserJsonRepository();

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

        // Make login form look mega sexy
        txtUsername.setCaretPosition(0);
        txtUsername.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (txtUsername.getText().equals("Check instructions below")) {
                    txtUsername.setText("");
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (txtUsername.getText().equals("")) {
                    txtUsername.setText("Check instructions below");
                    txtUsername.setCaretPosition(0);
                }
            }
        });
        txtUsername.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Check instructions below")) {
                    txtUsername.setCaretPosition(0);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });
    }
}
