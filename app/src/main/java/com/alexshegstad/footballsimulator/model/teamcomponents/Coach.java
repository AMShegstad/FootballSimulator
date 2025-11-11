package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;
import com.alexshegstad.footballsimulator.model.enumerations.Defense;
import com.alexshegstad.footballsimulator.model.enumerations.Offense;
import com.alexshegstad.footballsimulator.data.NameGenerator;
import com.alexshegstad.footballsimulator.data.LocationGenerator;
import java.util.concurrent.ThreadLocalRandom;

public class Coach {
    
    private final String firstName;
    private final String lastName;
    private final Location hometown;
    private Integer age;
    private final Defense defense;
    private final Offense offense;
    private final LeadershipStyle leadershipStyle;
    
    private Coach (Builder builder) {
        this.firstName = builder.firstName != null ? builder.firstName : randomFirstName();
        this.lastName = builder.lastName != null ? builder.lastName : randomLastName();
        this.hometown = builder.hometown != null ? builder.hometown : randomHometown();
        this.age = (builder.age != null) ? builder.age : randomAge();
        this.defense = builder.defense != null ? builder.defense : randomDefense();
        this.offense = builder.offense != null ? builder.offense : randomOffense();
        this.leadershipStyle = builder.leadershipStyle != null ? builder.leadershipStyle : randomLeadershipStyle();
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Location getHometown() {
        return hometown;
    }

    public Defense getDefense() {
        return defense;
    }

    public Offense getOffense() {
        return offense;
    }

    public LeadershipStyle getLeadershipStyle() {
        return leadershipStyle;
    }

    // Random Generation methods
    private static int randomAge() {
        return (int) (30 + Math.random() * 35);
    }

    private static Offense randomOffense() {
        Offense[] offenses = Offense.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(offenses.length);
        return offenses[randomIndex];
    } 

    private static Defense randomDefense() {
        Defense[] defenses = Defense.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(defenses.length);
        return defenses[randomIndex];
    }

    private static String randomFirstName() {
        NameGenerator names = new NameGenerator();
        String firstName = names.getRandomFirstName();
        return firstName;
    }

    private static String randomLastName() {
        NameGenerator names = new NameGenerator();
        String lastName = names.getRandomLastName();
        return lastName;
    }

    private static LeadershipStyle randomLeadershipStyle() {
        LeadershipStyle[] leadershipStyles = LeadershipStyle.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(leadershipStyles.length);
        return leadershipStyles[randomIndex];
    }

    private static Location randomHometown() {
        Location location = new Location.Builder().build();
        return location;
    }
        
    public String toString() {
        String text = firstName + " " + lastName + ", " + hometown + ", " + age + " years old, " + defense + ", " + offense + ", " + leadershipStyle; 
        return text;
    }

    // Builder inner class to add flexibility to the constructor.
    public static class Builder {

        private String firstName;
        private String lastName;
        private Location hometown;
        private Integer age;
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

        public Builder setLeadershipStyle(LeadershipStyle leadershipStyle) {
            this.leadershipStyle = leadershipStyle;
            return this;
        }

        public Coach build() {
            return new Coach(this);  
        }
    }
}
