package com.set.guide.forms;

import com.sun.tools.javac.Main;

import javax.swing.*;

public class InitGui extends JFrame {
    public InitGui(String title) {
        super(title);
    }

    public void start_gui(JPanel mainPanel){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setContentPane(mainPanel);
        setVisible(true);
        setTitle("Log in");
    }

    public void new_window(LogIn old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_window(LogIn old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_window(LogIn old, MainPageAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_window(MainPageUser old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_window(MainPageGuide old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_window(MainPageAdmin old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
}
