package com.alexshegstad.footballsimulator.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.alexshegstad.footballsimulator.model.teamcomponents.ColorScheme;
import java.io.*;
import java.util.*;

public class ColorSchemeGenerator {
    
    private static final Random rand = new Random();
    private List<ColorScheme> colorSchemes;

    public ColorSchemeGenerator() {
        loadColorSchemes();
    }

    private void loadColorSchemes() {
        try {
            InputStream inputStream = getClass().getResourceAsStream("/colorSchemes.json");

            if (inputStream == null) {
                throw new RuntimeException("colorSchemes.json file not found in resources folder");
            }
            
            ObjectMapper mapper = new ObjectMapper();

            selectedColorScheme = mapper.readValue(inputStream, new TypeReference<String)
        
        }
    }

    public String getRandomColorScheme() {
        if (colorSchemes == null || colorSchemes.isEmpty()) {
            return "unknown Color Scheme";
        }
    }
}
