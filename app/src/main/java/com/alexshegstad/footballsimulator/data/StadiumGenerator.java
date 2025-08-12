package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.Stadium;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.io.IOException;
import java.util.*;
import com.alexshegstad.footballsimulator.model.teamcomponents.Location;

public class StadiumGenerator {
    
    private static final Random rand = new Random();
    private List<String> stadiumNames;

    public StadiumGenerator() {
        loadStadiums();
    }

    private void loadStadiums() {
        stadiumNames = loadStadiumsFromJsonFile("/stadiums.json");
    }

    private List<String> loadStadiumsFromJsonFile(String filename) {
        List<String> stadiumNameList = new ArrayList<>();

        try {
            InputStream inputStream = getClass().getResourceAsStream(filename);

            if (inputStream == null) {
                throw new RuntimeException(filename + " file not found in resources");
            }

            ObjectMapper mapper = new ObjectMapper();
            stadiumNameList = mapper.readValue(inputStream, new TypeReference<List<String>>() {});

            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException("Error reading " + filename, e);
        }

        return stadiumNameList;
    }

    public String getRandomStadiumName() {
        if (stadiumNames.isEmpty()) {
            return "Unknown";
        }

        return stadiumNames.get(rand.nextInt(stadiumNames.size()));
    }

    public int randomCapacity() {
        Random rand = new Random();
        int min = 60000;
        int max = 200000;
        
        int minStep = min / 100;
        int maxStep = max / 100;

        int capacity = (rand.nextInt(maxStep - minStep +1) + minStep) * 100;

        return capacity;
    }

    public Stadium generateStadium() {
        LocationGenerator locGen = new LocationGenerator();

        int capacity = randomCapacity();
        Location location = locGen.getRandomLocation();
        String stadName = getRandomStadiumName();

        Stadium stadium = new Stadium(stadName, location, capacity);

        return stadium;
    }
}
