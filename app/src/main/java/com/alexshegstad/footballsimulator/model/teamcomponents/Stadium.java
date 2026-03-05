package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stadium {
    private static final Random rand = new Random();
    private static List<String> stadiumNames;
    
    private String name;
    private int capacity;
    private String city;
    private String state;
    
    // Static block to load stadium names once
    static {
        loadStadiumNames();
    }
    
    public Stadium() {
        this.name = getRandomStadiumName();
        this.capacity = generateCapacity();
        // You can set city/state based on your needs
    }
    
    private static void loadStadiumNames() {
        try {
            stadiumNames = loadStadiumsFromJsonFile();
            if (stadiumNames == null || stadiumNames.isEmpty()) {
                throw new RuntimeException("No stadiums loaded from JSON file");
            }
            System.out.println("✅ Loaded " + stadiumNames.size() + " stadiums");
        } catch (Exception e) {
            System.err.println("❌ Error loading stadiums: " + e.getMessage());
            // Provide fallback stadiums
            stadiumNames = getDefaultStadiums();
        }
    }
    
    private static List<String> loadStadiumsFromJsonFile() {
        try {
            // FIXED: Proper resource loading
            InputStream inputStream = Stadium.class.getResourceAsStream("/stadiums.json");
            
            if (inputStream == null) {
                throw new RuntimeException("/stadiums.json file not found in resources");
            }
            
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(inputStream);
            
            List<String> names = new ArrayList<>();
            
            // Handle different JSON structures
            if (rootNode.isArray()) {
                // If JSON is directly an array of stadiums
                for (JsonNode stadiumNode : rootNode) {
                    String name = extractStadiumName(stadiumNode);
                    if (name != null) {
                        names.add(name);
                    }
                }
            } else if (rootNode.has("stadiums")) {
                // If JSON has a "stadiums" wrapper
                JsonNode stadiumsArray = rootNode.get("stadiums");
                for (JsonNode stadiumNode : stadiumsArray) {
                    String name = extractStadiumName(stadiumNode);
                    if (name != null) {
                        names.add(name);
                    }
                }
            } else {
                throw new RuntimeException("Invalid JSON structure in stadiums.json");
            }
            
            return names;
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading stadiums.json: " + e.getMessage(), e);
        }
    }
    
    private static String extractStadiumName(JsonNode stadiumNode) {
        // Try different possible field names
        if (stadiumNode.has("name")) {
            return stadiumNode.get("name").asText();
        } else if (stadiumNode.has("stadium")) {
            return stadiumNode.get("stadium").asText();
        } else if (stadiumNode.has("stadiumName")) {
            return stadiumNode.get("stadiumName").asText();
        } else if (stadiumNode.isTextual()) {
            return stadiumNode.asText();
        }
        return null;
    }
    
    private static List<String> getDefaultStadiums() {
        List<String> defaults = new ArrayList<>();
        defaults.add("Memorial Stadium");
        defaults.add("Veteran's Field");
        defaults.add("City Stadium");
        defaults.add("University Arena");
        defaults.add("Champion Field");
        defaults.add("Victory Stadium");
        defaults.add("Liberty Field");
        defaults.add("Eagle Stadium");
        defaults.add("Thunder Dome");
        defaults.add("Warrior Field");
        return defaults;
    }
    
    public static String getRandomStadiumName() {
        if (stadiumNames == null || stadiumNames.isEmpty()) {
            return "Generic Stadium";
        }
        return stadiumNames.get(rand.nextInt(stadiumNames.size()));
    }
    
    private int generateCapacity() {
        // Generate realistic stadium capacity (15,000 to 110,000)
        return 15000 + rand.nextInt(95000);
    }
    
    // Builder pattern
    public static class Builder {
        private String name;
        private int capacity;
        private String city;
        private String state;
        
        public Builder() {
            // Default values will be set in build()
        }
        
        public Builder name(String name) {
            this.name = name;
            return this;
        }
        
        public Builder capacity(int capacity) {
            this.capacity = capacity;
            return this;
        }
        
        public Builder city(String city) {
            this.city = city;
            return this;
        }
        
        public Builder state(String state) {
            this.state = state;
            return this;
        }
        
        public Stadium build() {
            Stadium stadium = new Stadium();
            
            // Override defaults if provided
            if (name != null) {
                stadium.name = name;
            }
            if (capacity > 0) {
                stadium.capacity = capacity;
            }
            if (city != null) {
                stadium.city = city;
            }
            if (state != null) {
                stadium.state = state;
            }
            
            return stadium;
        }
    }
    
    // Getters
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getCity() { return city; }
    public String getState() { return state; }
    
    // Setters
    public void setName(String name) { this.name = name; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    
    @Override
    public String toString() {
        return String.format("Stadium{name='%s', capacity=%d, location='%s, %s'}", 
                           name, capacity, city != null ? city : "Unknown", state != null ? state : "Unknown");
    }
}
