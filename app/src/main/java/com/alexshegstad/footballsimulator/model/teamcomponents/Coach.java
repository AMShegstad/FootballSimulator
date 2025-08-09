package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;
import com.alexshegstad.footballsimulator.model.enumerations.Defense;
import com.alexshegstad.footballsimulator.model.enumerations.Offense;
import com.alexshegstad.footballsimulator.model.teamcomponents.Location;

public class Coach {
    
    private String firstName;
    private String lastName;
    private Location hometown;
    private int age;
    private Defense defense;
    private Offense offense;
    private LeadershipStyle style;

    public Coach() {
        this.firstName = "Error: undefined";
        this.lastName = "Error: undefined";
        this.hometown = new Location();
        this.age = 0;
        
    }

    public Coach(String firstName, String lastName, Location hometown, int age, Defense defense, Offense offense, LeadershipStyle style) {
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
        return hometown.toString();
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

    public LeadershipStyle getCoachingStyle() {
        return style;
    }

    public String toString() {
        String text = firstName + " " + lastName + ", " + hometown + ", " + age + " years old, " + defense + ", " + offense; 
        return text;
    }
}
