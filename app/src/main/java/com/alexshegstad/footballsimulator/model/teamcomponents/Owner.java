package com.alexshegstad.footballsimulator.model.teamcomponents;

public class Owner {
    
    private String firstName;
    private String lastName;
    private double netWorth;
    private SpendingHabit spendingHabit;

    public Owner(String firstName, String lastName, double netWorth, SpendingHabit spendingHabit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.netWorth = netWorth;
        this.spendingHabit = spendingHabit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(double netWorth) {
        this.netWorth = netWorth;
    }

    public String getSpendingHabit() {
        return spendingHabit.toString();
    }

    public void setSpendingHabit(SpendingHabit spendingHabit) {
        this.spendingHabit = spendingHabit;
    }

    public String toString() {
        String text = firstName + " " + lastName + ", " + netWorth + ", " + spendingHabit;
        return text;
    }
}
