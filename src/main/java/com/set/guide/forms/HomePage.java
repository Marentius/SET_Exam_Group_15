package com.set.guide.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage {
    public static void createHomePageWindow(){
        JFrame mainPageWindow = new JFrame();
        mainPageWindow.setSize(500, 700);
        mainPageWindow.setLayout(null);


        JButton profilePageButton = new JButton("Profil");
        profilePageButton.setBounds(350, 30, 100, 40);
        mainPageWindow.add(profilePageButton);
        mainPageWindow.setVisible(true);

        profilePageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profile.createProfileWindow();
                mainPageWindow.setVisible(false);
            }
        });

        JButton menuButton = new JButton("Meny");
        menuButton.setBounds(35, 30, 100, 40);
        mainPageWindow.add(menuButton);

        JLabel placeholder = new JLabel("Placeholder");
        placeholder.setBounds(250, 150, 100, 40);
        mainPageWindow.add(placeholder);

        JLabel placeholder2 = new JLabel("Placeholder");
        placeholder2.setBounds(250, 300, 100, 40);
        mainPageWindow.add(placeholder2);

        JLabel placeholder3 = new JLabel("Placeholder");
        placeholder3.setBounds(250, 450, 100, 40);
        mainPageWindow.add(placeholder3);

        JLabel placeholder4 = new JLabel("Placeholder");
        placeholder4.setBounds(250, 600, 100, 40);
        mainPageWindow.add(placeholder4);

        JLabel picture = new JLabel(new ImageIcon("src/main/java/com/set/guide/pictures/Omvisning.jpg"));
        mainPageWindow.add(picture);
        picture.setBounds(35, 150, 100, 80);

        JLabel picture2 = new JLabel(new ImageIcon("src/main/java/com/set/guide/pictures/Omvisning.jpg"));
        mainPageWindow.add(picture2);
        picture2.setBounds(35, 300, 100, 80);

        JLabel picture3 = new JLabel(new ImageIcon("src/main/java/com/set/guide/pictures/Omvisning.jpg"));
        mainPageWindow.add(picture3);
        picture3.setBounds(35, 450, 100, 80);

        JLabel picture4 = new JLabel(new ImageIcon("src/main/java/com/set/guide/pictures/Omvisning.jpg"));
        mainPageWindow.add(picture4);
        picture4.setBounds(35, 600, 100, 80);

    }
}
