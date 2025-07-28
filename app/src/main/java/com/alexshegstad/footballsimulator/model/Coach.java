package com.alexshegstad.footballsimulator.model;

public class Coach {
    
    private String firstName;
    private String lastName;
    private String hometown;
    private int age;
    private Defense defense;
    private Offense offense;
    private CoachingStyle style;

    public Coach(String firstName, String lastName, String hometown, int age, Defense defense, Offense offense, CoachingStyle style) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = hometown;
        this. age = age;
        this.defense = defense;
        this.offense = offense;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHometown() {
        return hometown;
    }

    public int age() {
        return age;
    }

    public Defense getDefense() {
        return defense;
    }

    public Offense getOffense() {
        return offense;
    }

    public CoachingStyle getCoachingStyle() {
        return style;
    }
}
