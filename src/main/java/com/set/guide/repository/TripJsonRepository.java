package com.set.guide.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.guide.models.Trip;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class TripJsonRepository implements TripRepository {
    private ArrayList<Trip> tripArrayList = new ArrayList<>();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
            support.firePropertyChange("tripArrayList", null, tripArrayList);
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

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }
}
