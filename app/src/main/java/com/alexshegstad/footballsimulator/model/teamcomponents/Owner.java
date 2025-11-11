package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.data.NameGenerator;
import com.alexshegstad.footballsimulator.model.enumerations.SpendingHabit;

public class Owner {
    
    private Integer age;
    private final String firstName;
    private final String lastName;
    private double netWorth;
    private final SpendingHabit spendingHabit;

    public Owner(Builder builder) {
        this.firstName = builder.firstName != null ? builder.firstName : randomFirstName();
        this.lastName = builder.lastName != null ? builder.lastName : randomLastName();
        this.age = builder.age != null ? builder.age : randomAge();
        this.netWorth = builder.netWorth != null ? builder.netWorth : randomNetWorth();
        this.spendingHabit = builder.spendingHabit != null ? builder.spendingHabit : randomSpendingHabit();
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public String getSpendingHabit() {
        return spendingHabit.toString();
    }

    // ToString method
    public String toString() {
        String text = firstName + " " + lastName + ", " + netWorth + ", " + spendingHabit;
        return text;
    }

    // Random Generation Methods
    private static int randomAge() {
        return (int) (50 + Math.random() * 35);
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

    private static SpendingHabit randomSpendingHabit() {

    }

    private static double randomNetWorth() {

    }
    

    public static class Builder {

        private String firstName;
        private String lastName;
        private Integer age;
        private SpendingHabit spendingHabit;
        private Double netWorth;

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setSpendingHabit(SpendingHabit spendingHabit) {
            this.spendingHabit = spendingHabit;
            return this;
        }

        public Builder setNetWorth(Double netWorth) {
            this.netWorth = netWorth;
            return this;
        }

        public Owner build() {
            return new Owner(this);
        }
    }
}
