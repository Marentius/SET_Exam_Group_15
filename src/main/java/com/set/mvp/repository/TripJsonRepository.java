package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.Guide;
import com.set.mvp.models.Trip;
import com.set.mvp.repository.interfaces.TripRepository;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class TripJsonRepository implements TripRepository {
    private ArrayList<Trip> tripArrayList = new ArrayList<>();

    public TripJsonRepository(String filename) {
        readFromJsonFile(filename);
    }

    public ArrayList<Trip> readFromJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try (InputStream input = getClass().getResourceAsStream(filename)) {
            if (input == null) {
                throw new FileNotFoundException("Could not find file " + filename);
            }
            Trip[] tripArray = objectMapper.readValue(input, Trip[].class);
            tripArrayList.addAll(Arrays.asList(tripArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tripArrayList;
    }

    @Override
    public ArrayList<Trip> getTrips() {
        ArrayList<Trip> trips = new ArrayList<>(tripArrayList);
        return trips;
    }

    @Override
    public Trip addTrip(String title, String location, String description, Guide guide, double price, int duration, LocalDate date, ArrayList<String> reviews) {
        Trip newTrip = new Trip(generateUnicTripId(), title, location, description, guide, price, duration, date, reviews);

        tripArrayList.add(newTrip);

        writeToJsonFile("/src/main/resources/database/trip.json");

        System.out.println("Trip successfully created");

        return newTrip;
    }

    @Override
    public void deleteTrip(int tripId) {
        Trip tripToDelete = null;

        for (Trip trip : tripArrayList) {
            if (trip.getTripId() == tripId) {
                tripToDelete = trip;
                break;
            }
        }

        if (tripToDelete != null) {
            tripArrayList.remove(tripToDelete);
            writeToJsonFile("/src/main/resources/database/trip.json");
            System.out.println("Trip with ID " + tripId + " was successfully deleted");
        } else {
            System.out.println("Trip with ID " + tripId + " was not found.");
        }
    }

    private void writeToJsonFile(String filename) {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        try {
            String projectPath = new File(".").getAbsolutePath();
            String fullPath = projectPath + filename;
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(fullPath), tripArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int generateUnicTripId() {
        int newID = 0;
        for (Trip trip : tripArrayList) {
            if (trip.getTripId() > newID) {
                newID = trip.getTripId();
            }
        }

        newID++;

        while (idExists(newID)) {
            newID++;
        }

        return newID;
    }

    private boolean idExists(int id) {
        for (Trip trip : tripArrayList) {
            if (trip.getTripId() == id) {
                return true;
            }
        }
        return false;
    }


}
