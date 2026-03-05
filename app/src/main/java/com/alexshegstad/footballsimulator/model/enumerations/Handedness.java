package com.alexshegstad.footballsimulator.model.enumerations;

public enum Handedness {
    LEFT("left-handed", "Almost completely left-handed."),
    LEFT_MOST("Mostly left-handed", "Can use both hands, but their left is stronger."),
    RIGHT("right", "Almost completely right-handed"),
    RIGHT_MOST("Mostly right-handed", "Can use both hands, but their left is stronger."),
    AMBIDEXTROUS("ambidextrous", "Can use both hands equally well.");


    private final String name;
    private String description;

    Handedness(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String[] getHandedness() {
        String[] handednessInfo = {name, description};
        return handednessInfo;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }
}


