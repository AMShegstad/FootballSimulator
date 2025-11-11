package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.enumerations.SpendingHabit;
import com.alexshegstad.footballsimulator.model.teamcomponents.Owner;

//import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class OwnerGenerator {
    
    private String firstName;
    private String lastName;
    private double netWorth;
    private SpendingHabit spendingHabit;

    // For calculating net worth
    private long min = 10_000_000L;
    private long max = 4_000_000_000L;

    NameGenerator name = new NameGenerator();

    // Different constructors
    public Owner generatorOwner() {
        this.firstName = name.getRandomFirstName();
        this.lastName = name.getRandomLastName();
        this.netWorth = setRandomNetWorth();
        this.spendingHabit = chooseSpendingHabit();

         Owner owner = new Owner(firstName, lastName, netWorth, spendingHabit);
         return owner;
    }

    public Owner generateOwner(String firstName) {
        this.firstName = firstName;
        this.lastName = name.getRandomLastName();
        this.netWorth = setRandomNetWorth();
        this.spendingHabit = chooseSpendingHabit();

        Owner owner = new Owner(firstName, lastName, netWorth, spendingHabit);
        return owner;
    }

    public Owner generateOwner(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.netWorth = setRandomNetWorth();
        this.spendingHabit = chooseSpendingHabit();        
        Owner owner = new Owner(firstName, lastName, netWorth, spendingHabit);
        return owner;
    }

    public Owner generateOwner(String firstName, String lastName, long netWorth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.netWorth = netWorth;
        this.spendingHabit = chooseSpendingHabit();
        Owner owner = new Owner(firstName, lastName, netWorth, spendingHabit);
        return owner;
    }

    public Owner generateOwner(String firstName, String lastName, long netWorth, SpendingHabit spendingHabit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.netWorth = netWorth;
        this.spendingHabit = spendingHabit;
        Owner owner = new Owner(firstName, lastName, netWorth, spendingHabit);
        return owner;
    }

    private SpendingHabit chooseSpendingHabit() {
        Random rand = new Random();
        SpendingHabit[] habits = SpendingHabit.values();
        SpendingHabit sh = habits[rand.nextInt(habits.length)];
        return sh;
    }

    private long setRandomNetWorth() {
        Random rand = new Random();
        long nw = rand.nextLong(min, max + 1);
        return nw;
    }

}
