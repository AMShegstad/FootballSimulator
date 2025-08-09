package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.Location;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;

public class LocationGenerator {
    
    private static final Random rand = new Random();
    private Map<String, List<String>> locationsByState;
    private List<Location> allLocations;
    
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
            
            // Parse the nested JSON structure: {"StateName": ["City1", "City2", ...]}
            locationsByState = mapper.readValue(inputStream, 
                new TypeReference<Map<String, List<String>>>() {});
            
            // Create a flat list of Location objects for easy random selection
            createLocationList();
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading locations.json", e);
        }
    }
    
    private void createLocationList() {
        allLocations = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> stateEntry : locationsByState.entrySet()) {
            String state = stateEntry.getKey();
            List<String> cities = stateEntry.getValue();
            
            for (String city : cities) {
                allLocations.add(new Location(city, state));
            }
        }
    }
    
    public Location getRandomLocation() {
        if (allLocations == null || allLocations.isEmpty()) {
            return new Location("Unknown City", "Unknown State");
        }
        return allLocations.get(rand.nextInt(allLocations.size()));
    }
    
    public Location getRandomLocationFromState(String state) {
        List<String> cities = locationsByState.get(state);
        if (cities == null || cities.isEmpty()) {
            return new Location("Unknown City", state);
        }
        
        String randomCity = cities.get(rand.nextInt(cities.size()));
        return new Location(randomCity, state);
    }
    
    public List<Location> getRandomLocations(int count) {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            locations.add(getRandomLocation());
        }
        return locations;
    }
    
    public List<Location> getAllLocations() {
        return new ArrayList<>(allLocations);
    }
    
    public List<String> getAllStates() {
        return new ArrayList<>(locationsByState.keySet());
    }
    
    public List<String> getCitiesInState(String state) {
        List<String> cities = locationsByState.get(state);
        return cities != null ? new ArrayList<>(cities) : new ArrayList<>();
    }
    
    public boolean isValidState(String state) {
        return locationsByState.containsKey(state);
    }
    
    public boolean isValidLocation(String city, String state) {
        List<String> cities = locationsByState.get(state);
        return cities != null && cities.contains(city);
    }
    
    // Get random location with specific criteria
    public Location getRandomLocationWithMinPopulation() {
        // You could add logic here to prefer larger cities
        // For now, just return random location
        return getRandomLocation();
    }
    
    public Location getRandomLocationExcludingState(String excludeState) {
        List<Location> filteredLocations = new ArrayList<>();
        
        for (Location location : allLocations) {
            if (!location.getState().equals(excludeState)) {
                filteredLocations.add(location);
            }
        }
        
        if (filteredLocations.isEmpty()) {
            return getRandomLocation();
        }
        
        return filteredLocations.get(rand.nextInt(filteredLocations.size()));
    }
    
    // For debugging
    public void printLocationStats() {
        System.out.println("Location Statistics:");
        System.out.println("Total states: " + locationsByState.size());
        System.out.println("Total cities: " + allLocations.size());
        
        locationsByState.forEach((state, cities) -> {
            System.out.println(state + ": " + cities.size() + " cities");
        });
    }
}