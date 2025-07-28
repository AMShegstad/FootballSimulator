package com.alexshegstad.footballsimulator.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class LocationGenerator {
    
    private static final Random rand = new Random();
    private List<String> locations;
    
    public LocationGenerator() {
        loadLocations();
    }
    
    private void loadLocations() {
        try {
            // Load JSON file from resources folder
            InputStream inputStream = getClass().getResourceAsStream("/locations.json");
            
            if (inputStream == null) {
                throw new RuntimeException("locations.json file not found in resources");
            }
            
            ObjectMapper mapper = new ObjectMapper();
            
            // If your JSON is an array like: ["New York", "Los Angeles", ...]
            locations = mapper.readValue(inputStream, new TypeReference<List<String>>() {});
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading locations.json", e);
        }
    }
    
    public String getRandomLocation() {
        if (locations == null || locations.isEmpty()) {
            return "Unknown City";
        }
        return locations.get(rand.nextInt(locations.size()));
    }
    
    public List<String> getAllLocations() {
        return locations;
    }
}