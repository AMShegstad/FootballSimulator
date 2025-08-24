package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class CollegeData {

    @JsonProperty("teams")
    private List<College> teams;

    public CollegeData() {
        // Default constructor for Jackson
    }

    public CollegeData(List<College> teams) {
        this.teams = teams;
    }

    public List<College> getTeams() {
        return teams;
    }

    public void setTeams(List<College> teams) {
        this.teams = teams;
    }
    
    /**
     * Get the number of colleges
     */
    public int size() {
        return teams != null ? teams.size() : 0;
    }
    
    /**
     * Check if any colleges are loaded
     */
    public boolean isEmpty() {
        return teams == null || teams.isEmpty();
    }

    @Override
    public String toString() {
        return "CollegeData{" +
                "teams=" + (teams != null ? teams.size() + " colleges" : "null") +
                '}';
    }
}
