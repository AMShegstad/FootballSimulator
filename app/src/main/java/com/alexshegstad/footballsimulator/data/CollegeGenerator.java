package com.alexshegstad.footballsimulator.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CollegeGenerator {
    
    private static final Random rand = new Random();
    private List<String> colleges;

    public CollegeGenerator() {
        loadColleges();
    }

    private void loadColleges() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/colleges.json");

            if (inputStream == null) {
                throw new RuntimeException("colleges.json file not found in resources");
            }

            ObjectMapper mapper = new ObjectMapper();

            colleges = mapper.readValue(inputStream, new TypeReference<List<String>>() {});

        } catch (IOException e) {
            throw new RuntimeException("Error reading locations.json", e);
        }      
    }

    public String getRandomCollege() {
        if (colleges == null || colleges.isEmpty()) {
            return "Unknown College";
        }
        return colleges.get(rand.nextInt(colleges.size()));
    }

    public List<String> getAllColleges() {
        return colleges;
    }
}
