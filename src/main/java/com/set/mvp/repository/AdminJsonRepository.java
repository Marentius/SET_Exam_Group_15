package com.set.mvp.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.set.mvp.models.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AdminJsonRepository {
    private ArrayList<Admin> adminArrayList = new ArrayList<>();

    public AdminJsonRepository() {
        readFromGuideJsonFile();
    }
    public ArrayList<Admin> readFromGuideJsonFile() {
        String filename = "src/main/resources/database/admin.json";
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        adminArrayList.clear();

        try (InputStream input = new FileInputStream(filename)){
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
