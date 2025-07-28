package com.alexshegstad.footballsimulator.resources;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class namesToJson {
    public static void main(String[] args) {
        try {
            // Read names from file
            List<String> names = Files.readAllLines(
                Paths.get("c:/Users/Alex's Lenovo/Desktop/Code-Work/FootballSimulator/app/src/main/resources/names.txt")
            );
            
            // Build JSON manually
            StringBuilder json = new StringBuilder();
            json.append("[\n");
            
            for (int i = 0; i < names.size(); i++) {
                json.append("  \"").append(names.get(i)).append("\"");
                if (i < names.size() - 1) {
                    json.append(",");
                }
                json.append("\n");
            }
            
            json.append("]");
            
            // Write to JSON file
            Files.write(
                Paths.get("names.json"), 
                json.toString().getBytes()
            );
            
            System.out.println("Conversion complete! Created names.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
