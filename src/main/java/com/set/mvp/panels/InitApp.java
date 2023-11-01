package com.set.mvp.panels;

import com.set.mvp.panels.admin.MainPageAdmin;
import com.set.mvp.panels.admin.ViewGuidesAdmin;
import com.set.mvp.panels.admin.ViewTripsAdmin;
import com.set.mvp.panels.admin.ViewUsersAdmin;
import com.set.mvp.panels.guide.*;
import com.set.mvp.panels.user.*;

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

    public void new_panel(StartPanelLogIn old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(StartPanelLogIn old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(StartPanelLogIn old, MainPageAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(MainPageUser old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(MainPageGuide old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }

    public void new_panel(MainPageAdmin old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(BookTripUser old, StartPanelLogIn neww){
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
    public void new_panel(EditUserPage old, StartPanelLogIn neww){
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
    public void new_panel(EditGuidePage old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(StartPanelLogIn old, CreateUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(CreateUser old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(CreateUser old, StartPanelLogIn neww){
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
    public void new_panel(ViewUsersAdmin old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(AddTripPage old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(AddTripPage old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageGuide old, AddTripPage neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(CreateGuide old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(CreateGuide old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(StartPanelLogIn old, CreateGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageAdmin old, ViewGuidesAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewGuidesAdmin old, MainPageAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewGuidesAdmin old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewTripsAdmin old, MainPageAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewTripsAdmin old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageAdmin old, ViewTripsAdmin neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageUser old, ViewAndManageUserTrips neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewAndManageUserTrips old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewAndManageUserTrips old, MainPageUser neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(MainPageGuide old, ViewAndManageGuideTrips neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewAndManageGuideTrips old, MainPageGuide neww){
        old.setVisible(false);
        neww.setVisible(true);
    }
    public void new_panel(ViewAndManageGuideTrips old, StartPanelLogIn neww){
        old.setVisible(false);
        neww.setVisible(true);
    }




}
