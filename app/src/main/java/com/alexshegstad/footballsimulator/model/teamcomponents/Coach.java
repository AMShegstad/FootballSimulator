package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;
import com.alexshegstad.footballsimulator.model.enumerations.Defense;
import com.alexshegstad.footballsimulator.model.enumerations.Offense;
import com.alexshegstad.footballsimulator.model.teamcomponents.Location;

public class Coach {
    
    private final String firstName;
    private final String lastName;
    private final Location hometown;
    private final int age;
    private final Defense defense;
    private final Offense offense;
    private final LeadershipStyle leadershipStyle;
    
    private Coach(Builder builder) {
        this.firstName = builder.firstName != null ? builder.firstName : randomFirstName();
        this.firstName = builder.lastName != null ? builder.lastName : randomLastName();
        this.hometown = builder.hometown != null ? builder.hometown : randomHomeTown();
        this.age = builder.age != null ? builder.age : randomAge();
        this.defense = builder.defense != null ? builder.defense : randomDefense();
        this.offense = builder.offense != null ? builder.offense : randomOffense();
        this.leadershipStyle = builder.leadershipStyle != null ? builder.leadershipStyle : randomLeadershipStyle();
    }

    public static class Builder {

        private String firstName;
        private String lastName;
        private Location hometown;
        private int age;
        private Defense defense;
        private Offense offense;
        private LeadershipStyle leadershipStyle ;   

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setOffense(Offense offense) {
            this.offense = offense;
            return this;
        }

        public Builder setDefense(Defense defense) {
            this.defense = defense;
            return this;
        }

        public Coach build() {
            return new Coach(this);  
        }
    }
    


    // public Coach(String firstName, String lastName, Location hometown, int age, Defense defense, Offense offense, LeadershipStyle style) {
    //     this.firstName = firstName;
    //     this.lastName = lastName;
    //     this.hometown = hometown;
    //     this. age = age;
    //     this.defense = defense;
    //     this.offense = offense;
    // }

    // public String getFirstName() {
    //     return firstName;
    // }

    // public String getLastName() {
    //     return lastName;
    // }

    // public String getHometown() {
    //     return hometown.toString();
    // }

    // public int age() {
    //     return age;
    // }

    // public Defense getDefense() {
    //     return defense;
    // }

    // public Offense getOffense() {
    //     return offense;
    // }

    // public LeadershipStyle getCoachingStyle() {
    //     return style;
    // }

    public String toString() {
        String text = firstName + " " + lastName + ", " + hometown + ", " + age + " years old, " + defense + ", " + offense; 
        return text;
    }
}

/*
 *
  public class Coach {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final int offense;
    private final int defense;

    // --- Private constructor (only Builder can call this) ---
    private Coach(Builder builder) {
        this.firstName = builder.firstName != null ? builder.firstName : randomFirstName();
        this.lastName = builder.lastName != null ? builder.lastName : randomLastName();
        this.age = builder.age != null ? builder.age : randomAge();
        this.offense = builder.offense != null ? builder.offense : randomOffense();
        this.defense = builder.defense != null ? builder.defense : randomDefense();
    }

    // --- Builder Inner Class ---
    public static class Builder {
        private String firstName;
        private String lastName;
        private Integer age;
        private Integer offense;
        private Integer defense;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setOffense(int offense) {
            this.offense = offense;
            return this;
        }

        public Builder setDefense(int defense) {
            this.defense = defense;
            return this;
        }

        public Coach build() {
            return new Coach(this);
        }
    }

    // --- Random Generation Helpers ---
    private static int randomAge() { return (int) (30 + Math.random() * 35); }
    private static int randomOffense() { return (int) (50 + Math.random() * 51); }
    private static int randomDefense() { return (int) (50 + Math.random() * 51); }

    private static String randomFirstName() {
        String[] names = {"Alex", "Jordan", "Taylor", "Sam", "Casey"};
        return names[(int) (Math.random() * names.length)];
    }

    private static String randomLastName() {
        String[] names = {"Smith", "Johnson", "Brown", "Davis", "Miller"};
        return names[(int) (Math.random() * names.length)];
    }

    // --- Getters ---
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public int getAge() { return age; }
    public int getOffense() { return offense; }
    public int getDefense() { return defense; }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Age " + age + ") | Offense: " + offense + " | Defense: " + defense;
    }
}
 
 *
 */
