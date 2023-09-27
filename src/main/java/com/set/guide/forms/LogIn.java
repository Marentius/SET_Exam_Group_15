package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn {
    public static void createLogIn(){
        JFrame logIn = new JFrame("Log in/Register User");
        logIn.setSize(500, 500);
        logIn.setSize(500, 500);

        logIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logIn.setLayout(null);
        logIn.setVisible(true);
        //---------^^ basic code for logg in window^^------------------------
        JTextField username = new JTextField();
        username.setBounds(50, 50, 200, 30);

        JTextField password = new JTextField();
        password.setBounds(50, 100, 200, 30);

        logIn.add(username);
        logIn.add(password);
        username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();
                String passwordText = password.getText();

                JOptionPane.showMessageDialog(null, "Brukernavnet ditt: " + usernameText + " " + ", Passordet ditt: " + passwordText);
            }
        });

        password.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usernameText = username.getText();
                String passwordText = password.getText();
                JOptionPane.showMessageDialog(null, "Brukernavnet ditt: " + usernameText + " " + ", Passordet ditt: " + passwordText);
            }
        });

        //---------------^^Lagde to actionlisteners, som leser ut brukernavnet og passordet som er skrevet inn i tekstfeltet^^-----------------

        JButton logInButton = new JButton("Logg inn");
        logIn.add(logInButton);
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
                    HomePage.createHomePage();
                    logIn.setVisible(false);
                }
            }
        });

    }
}



