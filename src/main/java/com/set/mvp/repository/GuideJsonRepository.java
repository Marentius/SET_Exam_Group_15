package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class GuideJsonRepository implements GuideRepository {
    private ArrayList<Guide> guideArrayList = new ArrayList<>();
    //private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public GuideJsonRepository(String filename) {
        readFromJsonFile(filename);
    }

    public ArrayList<Guide> readFromJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try (InputStream input = getClass().getResourceAsStream(filename)) {
            if (input == null) {
                throw new FileNotFoundException("Could not find file " + filename);
            }
            Guide[] guideArray = objectMapper.readValue(input, Guide[].class);
            guideArrayList.addAll(Arrays.asList(guideArray));
            //support.firePropertyChange("userArrayList", null, guideArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guideArrayList;
    }

    @Override
    public ArrayList<Guide> getGuides() {
        ArrayList<Guide> guides = new ArrayList<>(guideArrayList);
        return guides;
    }

    @Override
    public Guide createGuide(String username, String password, String firstname, String lastname, String email, ArrayList<Trip> trips) {
        Guide newGuide = new Guide(username, password, firstname, lastname, email, generateUnicProfileId(), trips);

        guideArrayList.add(newGuide);
        //support.firePropertyChange("guideArraylist", null, guideArrayList);

        writeToJsonFile("/src/main/resources/database/guide.json");

        System.out.println("Guide successfully created");

        return newGuide;
    }

    @Override
    public void deleteGuide(int profileId) {
        Guide guideToDelete = null;
        for (Guide guide : guideArrayList) {
            if (guide.getProfileId() == profileId) {
                guideToDelete = guide;
                break;
            }
        }

        if (guideToDelete != null) {
            guideArrayList.remove(guideToDelete);
            writeToJsonFile("/src/main/resources/database/guide.json");
            System.out.println("Guide with ID " + profileId + " was successfully deleted");
        } else {
            System.out.println("Guide with ID " + profileId + " not found.");
        }
    }

    /*public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }*/
    public int generateUnicProfileId() {
        int newID = 0;
        for (Guide guide : guideArrayList) {
            if (guide.getProfileId() > newID) {
                newID = guide.getProfileId();
            }
        }

        newID++;

        while (idExists(newID)){
            newID++;
        }
        return newID;
    }

    private boolean idExists(int id) {
        for (User user : guideArrayList) {
            if (user.getProfileId() == id) {
                return true;
            }
        }
        return false;
    }

    private void writeToJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            String projectPath = new File(".").getAbsolutePath();
            String fullPath = projectPath + filename;
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fullPath), guideArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int checkGuideExistans(String username) {
        for (User user : guideArrayList) {
            if (user.getUsername().equals(username)){
                return user.getProfileId();
            }
        }
        System.out.println("Guide don't exists");
        return 0;
    }
}
