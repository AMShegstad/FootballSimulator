// package com.alexshegstad.footballsimulator.data;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.core.type.TypeReference;
// import com.alexshegstad.footballsimulator.model.enumerations.ColorSchemes;
// import java.io.*;
// import java.util.*;

// public class ColorSchemeGenerator {
    
//     private static final Random rand = new Random();
//     private List<ColorSchemes> colorSchemes;

//     public ColorSchemeGenerator() {
//         loadColorSchemes();
//     }

//     private void loadColorSchemes() {
//         try {
//             InputStream inputStream = getClass().getResourceAsStream("/colorSchemes.json");

//             if (inputStream == null) {
//                 throw new RuntimeException("colorSchemes.json file not found in resources folder");
//             }
            
//             ObjectMapper mapper = new ObjectMapper();

//             ColorSchemes selectedColorScheme = mapper.readValue(inputStream, new TypeReference<List<String>>() {});
        
//         }
//     }

//     public String getRandomColorScheme() {
//         if (colorSchemes == null || colorSchemes.isEmpty()) {
//             return "unknown Color Scheme";
//         }
//     }
// }
