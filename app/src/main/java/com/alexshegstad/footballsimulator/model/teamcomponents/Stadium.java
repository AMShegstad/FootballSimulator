package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.*;
import java.io.*;

public class Stadium {
    // The stadium model will create a Stadium object containing the name, location, capacity, 
    private String name;
    private Location location;
    private Integer capacity;
    private List<String> stadiumNames;

    Random rand = new Random();
    // For generating a new location
    //LocationGenerator loc = new LocationGenerator();

    // public Stadium() {
    //     this.name = "";
    //     //this.location = "";
    //     this.capacity = 0;
    // }

    // public Stadium(String name, Location location, int capacity) {
    //     this.name = name;
    //     this.location = location;
    //     this.capacity = capacity; 
    // } 

    private Stadium (Builder builder) {
        this.name = builder.name != null ? builder.name : getRandomStadiumName();
        this.location = builder.location != null ? builder.location : getRandomLocation();
        this.capacity = (builder.capacity != null) ? builder.capacity : randomCapacity();
    }

    private void loadStadiumNames() {

        stadiumNames = loadStadiumsFromJsonFile("/stadiums.json");
        
    }

    private static List<String> loadStadiumsFromJsonFile(String fileName) {
        List<String> nameList = new ArrayList<>();

        try {
            InputStream inputStream = nameList.getClass().getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new RuntimeException(fileName + " file not found int resources");
            }

            ObjectMapper mapper = new ObjectMapper();
            nameList = mapper.readValue(inputStream, new TypeReference<List<String>>() {});

            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Error reading " + fileName, e);
        }

        return nameList;
    }

    private Location getRandomLocation() {
        Location location = new Location.Builder().build();
        return location;
    }

    private String getRandomStadiumName() {
        loadStadiumNames();
        if (stadiumNames.isEmpty()) {
            return "Stadium Names Not Loaded!";
        }

        String name = stadiumNames.get(rand.nextInt(stadiumNames.size()));
        return name;
    }

    private Integer randomCapacity() {
        int minCapacity = 5000;
        int maxCapacity = 132000;
        Random rand = new Random();
        int randomCapacity = rand.nextInt(minCapacity, maxCapacity);
        return randomCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        this.location = newLocation;
    }

    public void setRandomLocation() {
        Location loc = new Location.Builder().build();
        location = loc;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    public String toString() {
        String stadiumString = name + ", " + location + ", " + capacity;
        return stadiumString;
    }

    // Builder inner/nested class.
    public static class Builder {
        private String name;
        private Integer capacity;
        private Location location;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Stadium build() {
            return new Stadium(this);
        }
    }


}
