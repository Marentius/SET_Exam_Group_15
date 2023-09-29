package com.set.guide.forms;

import javax.swing.*;
import java.awt.*;

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

    public void new_window(LogIn login, HomePage homepage){
        login.setVisible(false);
        homepage.setVisible(true);
    }
}
