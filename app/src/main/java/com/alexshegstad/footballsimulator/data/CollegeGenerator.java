package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.College;
import com.alexshegstad.footballsimulator.model.teamcomponents.CollegeData;
import com.fasterxml.jackson.databind.ObjectMapper;

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
                throw new RuntimeException("colleges.json file not found in resources folder");
            }
            
            ObjectMapper mapper = new ObjectMapper();
            
            // Parse the JSON structure with "teams" wrapper
            CollegeData collegeData = mapper.readValue(inputStream, CollegeData.class);
            colleges = collegeData.getTeams();
            
            // Validate that colleges were loaded
            if (colleges == null || colleges.isEmpty()) {
                throw new RuntimeException("No colleges found in colleges.json");
            }
            
            System.out.println("✅ Loaded " + colleges.size() + " colleges from JSON");
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading colleges.json: " + e.getMessage(), e);
        }
    }
    
    /**
     * Returns just the region name (e.g., "Alabama")
     */
    public String getRandomCollege() {
        if (colleges == null || colleges.isEmpty()) {
            return "Unknown College";
        }
        
        College selectedCollege = colleges.get(rand.nextInt(colleges.size()));
        return selectedCollege.getRegion();
    }
    
    /**
     * Returns full college name (e.g., "Alabama Crimson Tide")
     */
    public String getRandomCollegeFullName() {
        if (colleges == null || colleges.isEmpty()) {
            return "Unknown College";
        }
        
        College selectedCollege = colleges.get(rand.nextInt(colleges.size()));
        return selectedCollege.getFullName();
    }
    
    /**
     * Returns the complete College object with all data
     * FIXED: Never returns null to prevent NullPointerException
     */
    public College getRandomCollegeObject() {
        if (colleges == null || colleges.isEmpty()) {
            // Return a default college instead of null
            College defaultCollege = new College();
            defaultCollege.setRegion("Generic");
            defaultCollege.setName("University");
            defaultCollege.setAbbrev("GU");
            defaultCollege.setCity("Unknown City");
            defaultCollege.setState("Unknown State");
            return defaultCollege;
        }
        
        return colleges.get(rand.nextInt(colleges.size()));
    }
    
    /**
     * Get college by specific region (useful for testing)
     */
    public College getCollegeByRegion(String region) {
        if (colleges == null) return null;
        
        return colleges.stream()
                .filter(college -> region.equalsIgnoreCase(college.getRegion()))
                .findFirst()
                .orElse(null);
    }
    
    /**
     * Get total number of colleges loaded
     */
    public int getCollegeCount() {
        return colleges != null ? colleges.size() : 0;
    }
    
    /**
     * Check if colleges were loaded successfully
     */
    public boolean isLoaded() {
        return colleges != null && !colleges.isEmpty();
    }
}
