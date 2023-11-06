package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.Admin;
import com.set.mvp.models.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminJsonRepository {
    private ArrayList<Admin> adminArrayList = new ArrayList<>();

    public AdminJsonRepository() {
        readFromJsonFile();
    }

    public ArrayList<Admin> readFromJsonFile() {
        String filename = "/database/admin.json";
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

        try (InputStream input = getClass().getResourceAsStream(filename)) {
            if (input == null) {
                throw new FileNotFoundException("Could not find file " + filename);
            }
            Admin[] adminArray = objectMapper.readValue(input, Admin[].class);
            adminArrayList.addAll(Arrays.asList(adminArray));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return adminArrayList;
    }
    public int checkUserExistansReturnProfileId(String username) {
        for (Admin admin : adminArrayList) {
            if (admin.getUsername().equals(username)){
                return admin.getProfileId();
            }
        }
        System.out.println("User don't exists");
        return 0;
    }
}
