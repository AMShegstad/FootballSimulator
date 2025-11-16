package com.alexshegstad.footballsimulator.model.teamcomponents;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import com.alexshegstad.footballsimulator.data.PlayerGenerator;
import com.alexshegstad.footballsimulator.model.enumerations.ColorSchemes;

public class Team {

    private final String mascot;
    private final Location location;
    private final Stadium stadium;
    private final Owner owner;
    private final Coach coach;
    private final List<Player> roster;
    private final ColorSchemes colorScheme;

    List<String> mascots;
    Random rand = new Random();

    public Team(Builder builder) {
        this.mascot = builder.mascot != null ? builder.mascot : generateMascot();
        this.stadium = builder.stadium != null ? builder.stadium : generateStadium();
        this.location = builder.location != null ? builder.location : generateLocation();
        this.owner = builder.owner != null ? builder.owner : generateOwner();
        this.coach = builder.coach != null ? builder.coach : generateCoach();
        this.roster = builder.roster != null ? builder.roster : generateRoster();
        this.colorScheme = builder.colorScheme != null ? builder.colorScheme : generateColorScheme();
    }

    private List<String> loadMascotsFromJsonFile(String fileName) {
        List<String> mascotList = new ArrayList<>();

        try {
            InputStream inputStream = getClass().getResourceAsStream(fileName);

            if (inputStream == null) {
                throw new RuntimeException(fileName + " file not found in resources...");
            }

            ObjectMapper mapper = new ObjectMapper();
            mascotList = mapper.readValue(inputStream, new TypeReference<List<String>>() {
            });

            inputStream.close();

        } catch (IOException e) {
            throw new RuntimeException("Error reading " + fileName, e);
        }

        return mascotList;
    }

    private void loadMascots() {

        mascots = loadMascotsFromJsonFile("/com/alexshegstad/footballsimulator/resources/mascots.json");

    }

    // Create the mascot from the JSON list.
    public String generateMascot() {
        // Import mascots
        loadMascots();
        // Make sure the names are load, with contingency, Just in case...
        if (mascots.isEmpty()) {
            return "unknown mascot...";
        }
        // Assign random name to variable
        String mascot = mascots.get(rand.nextInt(mascots.size()));
        // Return variable
        return mascot;
    }

    // return the selected mascot.
    public String getMascot() {
        return mascot;
    }

    // Generate a location from the JSON list.
    public Location generateLocation() {

        Location loc = new Location.Builder().build();
        return loc;
    }

    // Return the selected location object.
    public Location getLocation() {
        return location;
    }

    // Create first and last name of owner using the JSON list.
    public Owner generateOwner() {
        Owner owner = new Owner.Builder().build();
        return owner;
    }

    // return the owner's full name.
    public Owner getOwner() {

        return this.owner;
    }

    // Generate an entire Coach object.
    public Coach generateCoach() {
        Coach newCoach = new Coach.Builder().build();
        return newCoach;
    }

    // Return the entire coach object
    public Coach getCoach() {
        return coach;
    }

    public Stadium generateStadium() {
        Stadium stadium = new Stadium.Builder().build();
        return stadium;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public ColorSchemes getColorScheme() {
        return colorScheme;
    }

    public List<Player> generateRoster() {
        PlayerGenerator pg = new PlayerGenerator();
        List<Player> newRoster = pg.generateTeamPlayers();
        return newRoster;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public ColorSchemes generateColorScheme() {
        ColorSchemes[] colors = ColorSchemes.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(colors.length);
        return colors[randomIndex];
    }

    @Override
    public String toString() {
        return "Team: " + mascot + "\nOwner: " + owner.getLastName() + " " + owner.getLastName() + "\nCoach: " + coach
                + "\nPlayers:\n " + roster;
    }

    // Builder inner class to add flexibility to the constructor
    public static class Builder {
        private Coach coach;
        private List<Player> roster;
        private Owner owner;
        private Stadium stadium;
        private String mascot;
        private Location location;
        private ColorSchemes colorScheme;

        public Builder setCoach(Coach coach) {
            this.coach = coach;
            return this;
        }

        public Builder setPlayerRoster(List<Player> roster) {
            this.roster = roster;
            return this;
        }

        public Builder setMascot(String mascot) {
            this.mascot = mascot;
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setColorScheme(ColorSchemes colorScheme) {
            this.colorScheme = colorScheme;
            return this;
        }

        public Builder setStadium(Stadium stadium) {
            this.stadium = stadium;
            return this;
        }

        public Team build() {
            return new Team(this);
        }
    }
}
