package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.data.LocationGenerator;
//import java.util.Random;

public class Stadium {
    // The stadium model will create a Stadium object containing the name, location, capacity, 
    private String name;
    private Location location;
    private int capacity;

    // For generating a new location
    LocationGenerator loc = new LocationGenerator();

    public Stadium() {
        this.name = "";
        //this.location = "";
        this.capacity = 0;
    }

    public Stadium(String name, Location location, int capacity) {
        this.name = name;
        this.location = location;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location newLocation) {
        this.location = newLocation;
    }

    public void setRandomLocation() {
        loc.getRandomLocation();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int newCapacity) {
        this.capacity = newCapacity;
    }

    
    public String toString() {
        String stadiumString = name + ", " + location + ", " + capacity;
        return stadiumString;
    }

}
