package com.set.guide;

import javax.swing.*;
public class Application {
    public static void main(String[] args) {
        JFrame f = new JFrame();

        JButton b = new JButton("Logg inn");
        b.setBounds(100,100,100, 80);

        //Tester push

        f.add(b);

        f.setSize(800,900);
        f.setLayout(null);
        f.setVisible(true);
    }
}
