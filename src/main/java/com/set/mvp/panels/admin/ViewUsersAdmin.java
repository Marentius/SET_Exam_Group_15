package com.set.mvp.panels.admin;

import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.panels.InitApp;
import com.set.mvp.panels.StartPanelLogIn;
import com.set.mvp.models.User;
import com.set.mvp.repository.UserJsonRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewUsersAdmin extends InitApp {
    private JList<User> userJList;
    private JPanel mainPanel;
    private JButton homeButton;
    private JButton logOutButton;
    private JButton deleteUserButton;
    private DefaultListModel<User> listModel;
    private UserJsonRepository userJsonRepository;

    public ViewUsersAdmin(String title) {
        super(title);
        start_gui(mainPanel, 800, 400);

        userJsonRepository = new UserJsonRepository("/database/user.json");

        listModel = new DefaultListModel<>();
        userJList.setModel(listModel);

        updateUserList();

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = userJList.getSelectedValue();

                if (selectedUser != null) {
                    userJsonRepository.deleteUser(selectedUser.getProfileId());
                    JOptionPane.showMessageDialog(mainPanel, "The user: " + userJList.getSelectedValue().getUsername() + " was successfully deleted");

                    updateUserList();
                } else {
                        JOptionPane.showMessageDialog(mainPanel, "Please select an user to delete.");
                }
            }
        });
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewUsersAdmin.this, new MainPageAdmin("Main Page Admin"));
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_panel(ViewUsersAdmin.this, new StartPanelLogIn("Log In"));
                LoggedInProfile.getProfile().logOut();
            }
        });
    }

    private void updateUserList() {
        ArrayList<User> users = userJsonRepository.getUsers();
        listModel.clear();
        for (User user : users) {
            listModel.addElement(user);
        }
    }
}
