package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.LoggedInProfile;
import com.set.mvp.models.Trip;
import com.set.mvp.models.User;
import com.set.mvp.repository.interfaces.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class UserJsonRepository implements UserRepository {

    private ArrayList<User> userArrayList = new ArrayList<>();

    public UserJsonRepository() {
        readFromUserJsonFile();
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

        writeToUserJsonFile();

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
            writeToUserJsonFile();
            System.out.println("User with ID " + profileId + " was successfully deleted");
        } else {
            System.out.println("User with ID " + profileId + " not found.");
        }
    }

    @Override
    public void editUserInfo(String username, String password, String firstname, String lastname, String email) {

        int profileId = LoggedInProfile.getProfile().getLoggedInProfileId();

        for (User user : userArrayList) {
            if (user.getProfileId() == profileId){
                if (!username.isEmpty())
                    user.setUsername(username);
                if (!password.isEmpty())
                    user.setPassword(password);
                if (!firstname.isEmpty())
                    user.setFirstname(firstname);
                if (!lastname.isEmpty())
                    user.setLastname(lastname);
                if (!email.isEmpty())
                    user.setEmail(email);

                writeToUserJsonFile();

                System.out.println("User info successfully edited");
            }
        }
    }

    @Override
    public void bookTrip(Trip trip) {
        int profileId = LoggedInProfile.getProfile().getLoggedInProfileId();

        for (User user : userArrayList) {
            if (user.getProfileId() == profileId){
                user.addTrip(trip);

                writeToUserJsonFile();

                System.out.println("The trip: " + trip.getTitle() + " was successfully added to your trips");
            }
        }
    }

    @Override
    public ArrayList<Trip> getTrips(int profileId) {
        ArrayList<Trip> trips = new ArrayList<>();
        for (User user : userArrayList) {
            if (user.getProfileId() == profileId){
                trips.addAll(user.getTrips());
            }
        }
        return trips;
    }

    @Override
    public void unbookTrip(Trip trip) {
        int profileId = LoggedInProfile.getProfile().getLoggedInProfileId();

        for (User user : userArrayList) {
            if (user.getProfileId() == profileId){
                user.getTrips().remove(trip);

                writeToUserJsonFile();

                System.out.println("The trip: " + trip.getTitle() + " was successfully unbooked");
            }
        }
    }

    public int generateUnicProfileId() {
        int newID = 0;
        for (User user : userArrayList) {
            if (user.getProfileId() > newID) {
                newID = user.getProfileId();
            }
        }

        newID++;

        while (userProfileIdExists(newID)){
            newID++;
        }
        return newID;
    }

    private boolean userProfileIdExists(int id) {
        for (User user : userArrayList) {
            if (user.getProfileId() == id) {
                return true;
            }
        }
        return false;
    }

    public int checkUserExistansReturnProfileId(String username) {
        readFromUserJsonFile();
        for (User user : userArrayList) {
            if (user.getUsername().equals(username)){
                return user.getProfileId();
            }
        }
        System.out.println("User don't exists");
        return 0;
    }

    public void writeToUserJsonFile() {

        String filename = "/src/main/resources/database/user.json";

        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            String projectPath = new File(".").getAbsolutePath();
            String fullPath = projectPath + filename;
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fullPath), userArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<User> readFromUserJsonFile() {
        String filename = "src/main/resources/database/user.json";
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try (InputStream input = new FileInputStream(new File(filename))) {
        //    if (input == null) {
        //        throw new FileNotFoundException("Could not find file " + filename);
        //    }
            User[] userArray = objectMapper.readValue(input, User[].class);
            userArrayList.addAll(Arrays.asList(userArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userArrayList;
    }
}
