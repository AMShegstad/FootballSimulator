package com.alexshegstad.footballsimulator.model.teamcomponents;

import java.util.*;
//import java.util.ArrayList;

import com.alexshegstad.footballsimulator.data.LocationGenerator;
import com.alexshegstad.footballsimulator.data.PlayerGenerator;
import com.alexshegstad.footballsimulator.model.enumerations.ColorSchemes;
import com.alexshegstad.footballsimulator.model.teamcomponents.Coach;
import com.alexshegstad.footballsimulator.model.teamcomponents.Owner;
import com.alexshegstad.footballsimulator.model.teamcomponents.Stadium;

public class Team {

    private String teamName;
    private Location location;
    private Stadium stadium;
    private String ownerName;
    private Coach coach;
    private List<Player> roster;
    private List<Player> startingOffense;
    private List<Player> startingDefense;
    private List<Player> startingSpecialTeams;
    private final ColorScheme colorScheme; 

    //private Boolean coinFlipChoice;
    //private int seed;

    public Team (Builder builder) {
        this.teamName = builder.teamName != null ? builder.teamName : generateTeamName();
        this.stadium = builder.stadium != null ? builder.stadium : generateStadium();
        this.location = builder.location != null ? builder.location : generateLocation();
        this.ownerName = builder.ownerName != null ? builder.ownerName : generateOwnerName();
        this.coach = builder.coach != null ? builder.coach : generateCoach();
        this.roster = builder.roster != null ? builder.roster : generateRoster();
        this.startingOffense = selectStartingOffense();
        this.startingDefense = selectStartingDefense();
        this.startingSpecialTeams = selectStartingSpecialTeams();
        this.colorScheme = builder.colorScheme != null ? builder.colorScheme : generateColorScheme();
    }

    // Create the teamName from the JSON list.
    public String generateTeamName() {
        String teamName = "x";
        // TODO: Implement code to select a mastcot.
        return teamName;
    }

    // return the selected teamName.
    public String getTeamName() {
        return teamName;
    }

    // Generate a location from the JSON list.
    public Location generateLocation() {
        Location loc = new Location.Builder().build();
        return location;
    }

    // Return the selected location object.
    public Location getLocation() {
        return location;
    }

    // Create first and last name of owner using the JSON list.
    public String generateOwnerName() {
        
        return ownerName;
    }

    // return the owner's full name.
    public String getOwnerName() {

    }

    // Generate an entire Coach object.
    public Coach generateCoach() {
        Coach newCoach = new Coach.Builder().build();
        return newCoach;
    }

    // Return the entire coach object
    public Coach getCoach() {
        return Coach;
    }

    public Stadium generateStadium() {
        Stadium stadium = new Stadium.Builder().build(); 
    }

    public Stadium getStadium() {

    }

    public List<Player> generateRoster() {
        PlayerGenerator pg = new PlayerGenerator();
        List<Player> newRoster = pg.generateTeamPlayers();
        return newRoster;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public List<Player> selectStartingOffense() {

    }

    public List<Player> selectStartingDefense() {

    }

    public List<Player> selectStartingSpecialTeams() {

    }

    public ColorScheme generateColorScheme() {

    }

    // public String generateDivision() {
    //     if (division) {
    //         return "East";
    //     } else {
    //         return "West";
    //     }
    // }

    // public void setCoinFlipChoice(Boolean coinFlipChoice) {
    //     this.coinFlipChoice = coinFlipChoice;
    // }

    // public Boolean getCoinFlipChoice() {
    //     return coinFlipChoice;
    // }

    // public void setSeed(int seed) {
    //     this.seed = seed;
    // }

    // public int getSeed() {
    //     return seed;
    // }

    @Override
    public String toString() {
        return "Team: " + teamName + "\nOwner: " + ownerName + "\nCoach: " + coach + "\nPlayers:\n " + roster;
    }

        // Builder inner class to add flexibility to the constructor
    public static class Builder {
        private Coach coach;
        private List<Player> roster;
        private List<Player> startingOffense;
        private List<Player> startingDefense;
        private List<Player> startingSpecialTeams;
        private String ownerName;
        private Stadium stadium;
        private String teamName;
        private Location location;
        private ColorScheme colorScheme;

        private Builder setCoach() {
        this.coach = coach;
        return this;
        }

        private Builder setPlayerRoster() {
        this.roster = roster;
        return this;
        }

        private Builder setStartingOffense() {
        this.startingOffense = startingOffense;
        return this;
        }

        private Builder setStartingDefense() {
        this.startingDefense = startingDefense;
        return this;
        }

        private Builder setStartingSpecialTeams() {
        this.startingSpecialTeams = startingSpecialTeams;
        return this;
        }

        private Builder setTeamName() {
        this.teamName = teamName;
        return this;
        }

        private Builder setTeamLocation() {
        this.location = location;
        return this;
        }

        private Builder setColorScheme() {
        this.colorScheme = colorScheme; 
            return this;
        }

        private Team build() {
            return new Team(this);
        }
    }
}
