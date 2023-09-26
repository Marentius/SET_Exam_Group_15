package com.set.guide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Application {
    public static void main(String[] args) {
        JFrame loggIn = new JFrame("Logg in/ Register user");
        loggIn.setSize(500, 500);

        loggIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loggIn.setLayout(null);

        //---------^^ basic code for logg in window^^------------------------

        JTextField username = new JTextField();
        username.setBounds(50, 50, 200, 30);

        JTextField password = new JTextField();
        password.setBounds(50, 100, 200, 30);

        loggIn.add(username);
        loggIn.add(password);
//-------------^^ lagd to tekstfelt for brukernavn og passord, og la de til loggInn siden ----------------------------

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
        loggIn.add(logInButton);
        logInButton.setBounds(50, 300, 200, 30);


        JFrame mainSite = new JFrame();
        mainSite.setSize(500, 500);
        mainSite.setLayout(null);

        JLabel mainSiteUsername = new JLabel("");
        mainSiteUsername.setBounds(50, 50, 150, 50);
        mainSite.add(mainSiteUsername);
//--------------^^ Forsøker og lage en label som viser brukernavnet som er skrevet inn i tekstfeltet på logg inn siden, ikke funksjonell enda.----------
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainSite.setVisible(true);
                loggIn.setVisible(false);
            }
        });







//---------------^^Lagd ny logg inn knapp og en ny side som blir synlig når man trykker på loggin inn knappen^^-------

        loggIn.setVisible(true);
    }
}
