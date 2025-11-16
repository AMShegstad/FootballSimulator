package com.alexshegstad.footballsimulator.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
//import com.alexshegstad.footballsimulator.resources.*;
import java.io.*;
import java.util.*;

public class NameGenerator {
    
    private static final Random rand = new Random();
    private List<String> firstNames;
    private List<String> lastNames;
    
    public NameGenerator() {
        loadNames();
    }
    
    private void loadNames() {
        firstNames = loadNamesFromJsonFile("/com/alexshegstad/footballsimulator/resources/firstNames.json");
        lastNames = loadNamesFromJsonFile("/com/alexshegstad/footballsimulator/resources/lastNames.json");
    }
    
    private List<String> loadNamesFromJsonFile(String fileName) {
        List<String> nameList = new ArrayList<>();
        
        try {
            InputStream inputStream = getClass().getResourceAsStream(fileName);
            
            if (inputStream == null) {
                throw new RuntimeException(fileName + " file not found in resources...");
            }
            
            ObjectMapper mapper = new ObjectMapper();
            nameList = mapper.readValue(inputStream, new TypeReference<List<String>>() {});
            
            inputStream.close();
            
        } catch (IOException e) {
            throw new RuntimeException("Error reading " + fileName, e);
        }
        
        return nameList;
    }
    
    public String getRandomName() {
        if (firstNames.isEmpty() || lastNames.isEmpty()) {
            return "Unknown Player";
        }
        
        String firstName = firstNames.get(rand.nextInt(firstNames.size()));
        String lastName = lastNames.get(rand.nextInt(lastNames.size()));
        
        return firstName + " " + lastName;
    }
    
    public String getRandomFirstName() {
        if (firstNames.isEmpty()) {
            return "Unknown";
        }
        return firstNames.get(rand.nextInt(firstNames.size()));
    }
    
    public String getRandomLastName() {
        if (lastNames.isEmpty()) {
            return "Player";
        }
        return lastNames.get(rand.nextInt(lastNames.size()));
    }
}