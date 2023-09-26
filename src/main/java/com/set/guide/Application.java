package com.set.guide;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Application {
    public static void main(String[] args) {
        JFrame loggInn = new JFrame("Logg inn/ Registrer bruker");
        loggInn.setSize(500, 500);

        loggInn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loggInn.setLayout(null);

        //---------^^ basic kode for logg inn vinduet^^------------------------

        JTextField brukernavn = new JTextField();
        brukernavn.setBounds(50, 50, 200, 30);

        JTextField passord = new JTextField();
        passord.setBounds(50, 100, 200, 30);

        loggInn.add(brukernavn);
        loggInn.add(passord);
//-------------^^ lagd to tekstfelt for brukernavn og passord, og la de til loggInn siden ----------------------------

        brukernavn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brukerNavnTekst = brukernavn.getText();
                String passordTekst = passord.getText();

                JOptionPane.showMessageDialog(null, "Brukernavnet ditt: " + brukerNavnTekst + " " + ", Passordet ditt: " + passordTekst);
            }
        });




        passord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brukerNavnTekst = brukernavn.getText();
                String passordTekst = passord.getText();
                JOptionPane.showMessageDialog(null, "Brukernavnet ditt: " + brukerNavnTekst + " " + ", Passordet ditt: " + passordTekst);
            }
        });

        //---------------^^Lagde to actionlisteners, som leser ut brukernavnet og passordet som er skrevet inn i tekstfeltet^^-----------------

        JButton loggInnKnapp = new JButton("Logg inn");
        loggInn.add(loggInnKnapp);
        loggInnKnapp.setBounds(50, 300, 200, 30);


        JFrame hovedSide = new JFrame();
        hovedSide.setSize(500, 500);
        hovedSide.setLayout(null);

        JLabel hovedsideBrukernavn = new JLabel("");
        hovedsideBrukernavn.setBounds(50, 50, 150, 50);
        hovedSide.add(hovedsideBrukernavn);
//--------------^^ Forsøker og lage en label som viser brukernavnet som er skrevet inn i tekstfeltet på logg inn siden, ikke funksjonell enda.----------
        loggInnKnapp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hovedSide.setVisible(true);
                loggInn.setVisible(false);
            }
        });







//---------------^^Lagd ny logg inn knapp og en ny side som blir synlig når man trykker på loggin inn knappen^^-------

        loggInn.setVisible(true);
    }
}
