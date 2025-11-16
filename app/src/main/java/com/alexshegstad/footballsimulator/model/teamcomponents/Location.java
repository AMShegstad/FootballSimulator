package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Represents a U.S. location (city + state) with support for random generation.
 * JSON structure expected: { "State": ["City1", "City2", ...], ... }
 */
public class Location {
    private final String city;
    private final String state;

    // ---------- Static Data and Utilities ----------
    private static final Random rand = new Random();
    private static Map<String, List<String>> locationsByState;
    private static List<Location> allLocations;

    // ---------- Constructor ----------
    private Location(Builder builder) {
        ensureLocationsLoaded();

        if (builder.state == null && builder.city == null) {
            // Fully random
            Location random = getRandomLocation();
            this.city = random.city;
            this.state = random.state;
        } else if (builder.state != null && builder.city == null) {
            // Random city from given state
            this.state = builder.state;
            this.city = getRandomCity(builder.state);
        } else {
            // Use provided fields
            this.state = builder.state;
            this.city = builder.city;
        }
    }

    // ---------- Public Getters ----------
    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return city + ", " + state;
    }

    // ---------- Data Loading ----------
    private static void ensureLocationsLoaded() {
        if (locationsByState == null || locationsByState.isEmpty()) {
            loadLocations();
        }
    }

    private static void loadLocations() {
        try (InputStream inputStream = Location.class.getResourceAsStream("/locations.json")) {
            if (inputStream == null) {
                throw new RuntimeException("locations.json file not found in resources");
            }

            ObjectMapper mapper = new ObjectMapper();
            locationsByState = mapper.readValue(
                inputStream, new TypeReference<Map<String, List<String>>>() {}
            );
            createLocationList();

        } catch (IOException e) {
            throw new RuntimeException("Error reading locations.json", e);
        }
    }

    private static void createLocationList() {
        allLocations = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : locationsByState.entrySet()) {
            String state = entry.getKey();
            for (String city : entry.getValue()) {
                allLocations.add(new Location.Builder()
                    .setCity(city)
                    .setState(state)
                    .build());
            }
        }
    }

    // ---------- Random Utility Methods ----------
    // private static String getRandomState() {
    //     ensureLocationsLoaded();
    //     List<String> states = new ArrayList<>(locationsByState.keySet());
    //     return states.get(rand.nextInt(states.size()));
    // }

    private static String getRandomCity(String state) {
        ensureLocationsLoaded();
        List<String> cities = locationsByState.get(state);
        if (cities == null || cities.isEmpty()) {
            return "Unknown City";
        }
        return cities.get(rand.nextInt(cities.size()));
    }

    public static Location getRandomLocation() {
        ensureLocationsLoaded();
        return allLocations.get(rand.nextInt(allLocations.size()));
    }

    // ---------- Data Access Methods ----------
    public static List<Location> getAllLocations() {
        ensureLocationsLoaded();
        return new ArrayList<>(allLocations);
    }

    public static List<String> getAllStates() {
        ensureLocationsLoaded();
        return new ArrayList<>(locationsByState.keySet());
    }

    public static List<String> getCitiesInState(String state) {
        ensureLocationsLoaded();
        List<String> cities = locationsByState.get(state);
        return cities != null ? new ArrayList<>(cities) : Collections.emptyList();
    }

    public static boolean isValidState(String state) {
        ensureLocationsLoaded();
        return locationsByState.containsKey(state);
    }

    public static boolean isValidLocation(String city, String state) {
        ensureLocationsLoaded();
        List<String> cities = locationsByState.get(state);
        return cities != null && cities.contains(city);
    }
 
    // ---------- Debug Helper ----------
    public static void printLocationStats() {
        ensureLocationsLoaded();
        System.out.println("Location Statistics:");
        System.out.println("Total states: " + locationsByState.size());
        System.out.println("Total cities: " + allLocations.size());

        locationsByState.forEach((state, cities) ->
            System.out.println(state + ": " + cities.size() + " cities")
        );
    }

    // ---------- Builder Class ----------
    public static class Builder {
        private String city;
        private String state;

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}

