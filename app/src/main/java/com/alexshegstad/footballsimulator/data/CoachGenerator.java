package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.Coach;
import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;
import com.alexshegstad.footballsimulator.model.enumerations.Offense;
import com.alexshegstad.footballsimulator.model.enumerations.Defense;
import com.alexshegstad.footballsimulator.model.teamcomponents.Location;

import java.util.*;

/*
 * The CoachGenerator class contains methods for randomly generating the firstName, lastName,
 * hometown, age, defensive and offensive styles, and coachingStyle.
 * 
 * In order to create a new Coach, call CoachGenerator.generateCoach(), with your preferred parameters.
 */

public class CoachGenerator {
    
    private String firstName;
    private String lastName;
    private Location hometown;
    private int age;
    private Defense defense;
    private Offense offense;
    private LeadershipStyle coachingStyle;

    // For calculating age
    private int minAge = 30;
    private int maxAge = 75;

    // For generating the random names
    NameGenerator name = new NameGenerator();

    // For generating random location
    LocationGenerator loc = new LocationGenerator();

    public Coach generateCoach() {
        this.firstName = name.getRandomFirstName();
        this.lastName = name.getRandomLastName();
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = setRandomDefense();
        this.offense = setRandomOffense();
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    }

    public Coach generateCoach(String firstName) {
        this.firstName = firstName;
        this.lastName = name.getRandomLastName();
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = setRandomDefense();
        this.offense = setRandomOffense();
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    } 

    public Coach generateCoach(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = setRandomDefense();
        this.offense = setRandomOffense();
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    }

    public Coach generateCoach(String firstName, String lastName, Defense defense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = defense;
        this.offense = setRandomOffense();
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    }

    public Coach generateCoach(String firstName, String lastName, Offense offense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = setRandomDefense();
        this.offense = offense;
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    }

    public Coach generateCoach(String firstName, String lastName, Defense defense, Offense offense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = defense;
        this.offense = offense;
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    }

    public Coach generateCoach(String firstName, String lastName, Defense defense, Offense offense, LeadershipStyle coachingStyle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = loc.getRandomLocation();
        this.age = setRandomAge();
        this.defense = defense;
        this.offense = offense;
        this.coachingStyle = setRandomCoachingStyle();

        Coach newCoach = new Coach(firstName, lastName, hometown, age, defense, offense, coachingStyle);
        return newCoach;
    }

    // Method for returning a random age.
    public int setRandomAge() {
        Random rand = new Random();
        int randomAge = rand.nextInt(minAge, maxAge +1);
        return randomAge;
    }

    // Method for choosing a random defensive strategy from the enum.
    public Defense setRandomDefense() {
        Random rand = new Random();
        Defense[] defenses = Defense.values();
        Defense def = defenses[rand.nextInt(defenses.length)];
        return def;
    }

    public Offense setRandomOffense() {
        Random rand = new Random();
        Offense[] offenses = Offense.values();
        Offense off = offenses[rand.nextInt(offenses.length)];
        return off;
    }

    public LeadershipStyle setRandomCoachingStyle() {
        Random rand = new Random();
        LeadershipStyle[] coachingStyles = LeadershipStyle.values();
        LeadershipStyle cs = coachingStyles[rand.nextInt(coachingStyles.length)];
        return cs;
    }
}
