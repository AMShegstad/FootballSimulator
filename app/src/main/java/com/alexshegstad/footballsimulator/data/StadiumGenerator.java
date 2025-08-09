package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.Stadium;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class StadiumGenerator {
    
    private static final Random rand = new Random();
    private List<Stadium> stadiums;

    public StadiumGenerator() {
        loadStadiums();
    }

    private void loadStadiums() {
        try {
            // Load JSON file from the resources folder
            InputStream inputStream = getClass().getResourceAsStream("/stadiums.json");

            if (inputStream == null) {
                throw new RuntimeException("stadiums.json file not found in resources");
            }

            ObjectMapper mapper = new ObjectMapper();

        } catch (IOException e) {
            throw new RuntimeException("Error reasing stadiums.json")
        }
    }
}
