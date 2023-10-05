package com.set.guide.forms;

import com.set.guide.forms.admin.MainPageAdmin;
import com.set.guide.forms.admin.ViewUsersAdmin;
import com.set.guide.forms.guide.EditGuidePage;
import com.set.guide.forms.guide.MainPageGuide;
import com.set.guide.forms.user.BookTripUser;
import com.set.guide.forms.user.CreateUser;
import com.set.guide.forms.user.EditUserPage;
import com.set.guide.forms.user.MainPageUser;

import javax.swing.*;

public class InitApp extends JFrame {
    public InitApp(String title) {
        super(title);
    }

    public void start_gui(JPanel mainPanel, int width, int height){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setContentPane(mainPanel);
        setVisible(true);
        setTitle("SET MVP");
    }

    public void new_panel(LogIn old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(LogIn old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(LogIn old, MainPageAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(MainPageUser old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(MainPageGuide old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(MainPageAdmin old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(BookTripUser old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(BookTripUser old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageUser old, BookTripUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageUser old, EditUserPage neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(EditUserPage old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(EditUserPage old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageGuide old, EditGuidePage neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(EditGuidePage old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(EditGuidePage old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(LogIn old, CreateUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(CreateUser old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(CreateUser old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageAdmin old, ViewUsersAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewUsersAdmin old, MainPageAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewUsersAdmin old, LogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
}
