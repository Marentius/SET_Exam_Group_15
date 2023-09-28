package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {
    public static void createLogInWindow(){
        JFrame logInWindow = new JFrame("Log in/Register User");
        logInWindow.setSize(500, 700);


        logInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInWindow.setLayout(null);
        logInWindow.setVisible(true);
        //---------^^ basic code for logg in window^^------------------------
        JTextField username = new JTextField();
        username.setBounds(50, 50, 200, 30);

        JTextField password = new JTextField();
        password.setBounds(50, 100, 200, 30);

        logInWindow.add(username);
        logInWindow.add(password);
        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();

                JOptionPane.showMessageDialog(null, "Brukernavnet ditt: " + usernameText);
            }
        });

        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String passwordText = password.getText();
                JOptionPane.showMessageDialog(null,  "Passordet ditt: " + passwordText);
            }
        });

        //---------------^^Lagde to actionlisteners, som leser ut brukernavnet og passordet som er skrevet inn i tekstfeltet^^-----------------

        JButton logInButton = new JButton("Logg inn");
        logInWindow.add(logInButton);
        logInButton.setBounds(50, 300, 200, 30);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();
                String passwordText= password.getText();
                if (usernameText.isEmpty() || passwordText.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Skriv inn brukernavn og passord for å gå videre.");
                }
                else {
                    HomePage.createHomePageWindow();
                    logInWindow.setVisible(false);
                }
            }
        });

    }
}



