package com.alexshegstad.footballsimulator.model;

import java.util.List;
import com.alexshegstad.footballsimulator.data.PlayerGenerator;

public class Team {

    private String name;
    private String location;
    private String stadiumName;
    private String ownerName;
    private Coach coach;
    private List<Player> roster;
    private Boolean coinFlipChoice;
    private int seed;

    // When teams are created, 8 of them return true, and the other 8 false.
    private boolean division;

    public Team(String name, String location, String stadiumName, String ownerName, Coach coach) {
        this.name = name;
        this.stadiumName = stadiumName;
        this.location = location;
        this.ownerName = ownerName;
        this.coach = coach;
        this.roster = PlayerGenerator.generateTeamPlayers();
    }

    public String getTeamName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public List<Player> getRoster() {
        return roster;
    }

    public String getDivision() {
        if (division) {
            return "East";
        } else {
            return "West";
        }
    }

    public void setCoinFlipChoice(Boolean coinFlipChoice) {
        this.coinFlipChoice = coinFlipChoice;
    }

    public Boolean getCoinFlipChoice() {
        return coinFlipChoice;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public int getSeed() {
        return seed;
    }

    @Override
    public String toString() {
        return "Team: " + name + "\nOwner: " + ownerName + "\nCoach: " + coach + "\nPlayers:\n " + roster;
    }
}
