package com.set.guide.forms.admin;

import com.set.guide.forms.InitApp;
import com.set.guide.forms.LogIn;
import com.set.guide.models.User;
import com.set.guide.repository.UserJsonRepository;

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
        start_gui(mainPanel, 1500, 400);

        userJsonRepository = new UserJsonRepository("/data/user.json");

        listModel = new DefaultListModel<>();
        userJList.setModel(listModel);

        userJsonRepository.addPropertyChangeListener(evt -> {
            updateUserList();
        });

        updateUserList();

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User selectedUser = userJList.getSelectedValue();

                if (selectedUser != null) {
                    userJsonRepository.deleteUser(selectedUser.getProfileId());

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
                new_panel(ViewUsersAdmin.this, new LogIn("Log In"));
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
