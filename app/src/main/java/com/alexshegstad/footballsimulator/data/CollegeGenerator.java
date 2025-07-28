package com.alexshegstad.footballsimulator.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.alexshegstad.footballsimulator.model.College;
import com.alexshegstad.footballsimulator.model.CollegeData;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CollegeGenerator {
    
    private static final Random rand = new Random();
    private List<College> colleges;
    
    public CollegeGenerator() {
        loadColleges();
    }
    
    private void loadColleges() {
        try {
            // Load JSON file from resources folder
            InputStream inputStream = getClass().getResourceAsStream("/colleges.json");
            
            if (inputStream == null) {
                throw new RuntimeException("colleges.json file not found in resources");
            }
            
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse the JSON structure with "teams" wrapper
            CollegeData collegeData = mapper.readValue(inputStream, CollegeData.class);
            colleges = collegeData.getTeams();
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading colleges.json", e);
        }
    }
    
    public String getRandomCollege() {
        if (colleges == null || colleges.isEmpty()) {
            return "Unknown College";
        }
        
        College selectedCollege = colleges.get(rand.nextInt(colleges.size()));
        return selectedCollege.getRegion(); // Return only the region
    }
    
    // Optional: Get full college name (region + name)
    public String getRandomCollegeFullName() {
        if (colleges == null || colleges.isEmpty()) {
            return "Unknown College";
        }
        
        College selectedCollege = colleges.get(rand.nextInt(colleges.size()));
        return selectedCollege.getRegion() + " " + selectedCollege.getName();
    }
    
    // Optional: Get the full College object if you need other fields
    public College getRandomCollegeObject() {
        if (colleges == null || colleges.isEmpty()) {
            return null;
        }
        
        return colleges.get(rand.nextInt(colleges.size()));
    }
}
