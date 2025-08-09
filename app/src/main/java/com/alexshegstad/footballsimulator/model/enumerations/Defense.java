package com.alexshegstad.footballsimulator.model.enumerations;

public enum Defense {
    FOUR_THREE("4-3", "4 Linemen, 3 Linebackers"),
    THREE_FOUR("3-4", "3 Linemen, 4 Linebackers"),
    NICKEL("Nickel", "5 Defensive Backs"),
    DIME("Dime", "6 Defensive Backs"),
    GOAL_LINE("Goal Line", "Heavy Run Defense");

    private final String name;
    private String description;

    Defense(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isSpecialty() {
        return this == NICKEL || this == DIME || this == GOAL_LINE;
    }

    @Override 
    public String toString() {
        return name;
    }
}
