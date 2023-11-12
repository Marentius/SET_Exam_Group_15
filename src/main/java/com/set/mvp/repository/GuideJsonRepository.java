package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.Guide;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.User;
import com.set.mvp.repository.interfaces.GuideRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GuideJsonRepository implements GuideRepository {
    private ArrayList<Guide> guideArrayList = new ArrayList<>();
    public GuideJsonRepository() {
        readFromGuideJsonFile();
    }

    @Override
    public Guide getLoggedInGuide() {
        int profileId = LoggedInProfile.getProfile().getLoggedInProfileId();

        for (Guide guide : guideArrayList) {
            if (guide.getProfileId() == profileId){
                return guide;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Guide> getGuides() {
        ArrayList<Guide> guides = new ArrayList<>(guideArrayList);
        return guides;
    }
    @Override
    public Guide createGuide(String username, String password, String firstname, String lastname, String email) {
        Guide newGuide = null;

        if (!username.isEmpty() && !password.isEmpty() && !firstname.isEmpty() && !lastname.isEmpty() && !email.isEmpty()){
            newGuide = new Guide(username, password, firstname, lastname, email, generateUnicGuideProfileId());
            guideArrayList.add(newGuide);
            writeToGuideJsonFile();
            System.out.println("Guide successfully created");
        } else {
            System.out.println("Failed to create guide. Fields can not be empty");
        }

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
            writeToGuideJsonFile();
            System.out.println("Guide with ID " + profileId + " was successfully deleted");
        } else {
            System.out.println("Guide with ID " + profileId + " not found.");
        }
    }
    @Override
    public void editGuideInfo(String username, String password, String firstname, String lastname, String email) {

        if (!username.isEmpty())
            getLoggedInGuide().setUsername(username);

        if (!password.isEmpty())
            getLoggedInGuide().setPassword(password);

        if (!firstname.isEmpty())
            getLoggedInGuide().setFirstname(firstname);

        if (!lastname.isEmpty())
            getLoggedInGuide().setLastname(lastname);

        if (!email.isEmpty())
            getLoggedInGuide().setEmail(email);


        writeToGuideJsonFile();
        System.out.println("User info successfully edited");
    }
    public int generateUnicGuideProfileId() {
        int newID = 0;

        for (Guide guide : guideArrayList) {

            if (guide.getProfileId() > newID) {

                newID = guide.getProfileId();
            }
        }

        newID++;

        while (guideProfileIdExists(newID)){
            newID++;
        }
        return newID;
    }
    private boolean guideProfileIdExists(int id) {

        for (User user : guideArrayList) {

            if (user.getProfileId() == id) {

                return true;
            }
        }
        return false;
    }
    public int checkGuideExistansReturnProfileId(String username) {

        readFromGuideJsonFile();

        for (User user : guideArrayList) {

            if (user.getUsername().equals(username)){

                return user.getProfileId();
            }
        }
        System.out.println("Guide don't exists");
        return 0;
    }
    private void writeToGuideJsonFile() {

        String filename = "/src/main/resources/database/guide.json";

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try {
            String projectPath = new File(".").getAbsolutePath();
            String fullPath = projectPath + filename;
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fullPath), guideArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromGuideJsonFile() {

        String filename = "src/main/resources/database/guide.json";

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        guideArrayList.clear();

        try (InputStream input = new FileInputStream(filename)){
            Guide[] guideArray = objectMapper.readValue(input, Guide[].class);
            guideArrayList.addAll(Arrays.asList(guideArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}













