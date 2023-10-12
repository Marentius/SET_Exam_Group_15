package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class UserJsonRepository implements UserRepository{

    private ArrayList<User> userArrayList = new ArrayList<>();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public UserJsonRepository(String filename) {
        readFromJsonFile(filename);
    }

    public ArrayList<User> readFromJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try (InputStream input = getClass().getResourceAsStream(filename)) {
            if (input == null) {
                throw new FileNotFoundException("Could not find file " + filename);
            }
            User[] userArray = objectMapper.readValue(input, User[].class);
            userArrayList.addAll(Arrays.asList(userArray));
            support.firePropertyChange("userArrayList", null, userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }
    @Override
    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>(userArrayList);
        return users;
    }

    @Override
    public User createUser(String username, String password, String firstname, String lastname, String email, ArrayList<Trip> trips) {
        User newUser = new User(username, password, firstname, lastname, email, generateUnicProfileId(), trips);

        userArrayList.add(newUser);
        support.firePropertyChange("userArrayList", null, userArrayList);

        writeToJsonFile("/src/main/resources/database/user.json");

        System.out.println("User successfully created");

        return newUser;
    }

    @Override
    public void deleteUser(int profileId) {

        User userToDelete = null;
        for (User user : userArrayList) {
            if (user.getProfileId() == profileId) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            userArrayList.remove(userToDelete);
            writeToJsonFile("/src/main/resources/database/user.json");
            System.out.println("User with ID " + profileId + " was successfully deleted");
        } else {
            System.out.println("User with ID " + profileId + " not found.");
        }
    }


    private void writeToJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            String projectPath = new File(".").getAbsolutePath();
            String fullPath = projectPath + filename;
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fullPath), userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public int generateUnicProfileId() {
        int newID = 0;
        for (User user : userArrayList) {
            if (user.getProfileId() > newID) {
                newID = user.getProfileId();
            }
        }

        newID++;

        while (idExists(newID)){
            newID++;
        }
        return newID;
    }

    private boolean idExists(int id) {
        for (User user : userArrayList) {
            if (user.getProfileId() == id) {
                return true;
            }
        }
        return false;
    }
    public int checkUserExistans(String username) {
        for (User user : userArrayList) {
            if (user.getUsername().equals(username)){
                return user.getProfileId();
            }
        }
        System.out.println("User don't exists");
        return 0;
    }


}
