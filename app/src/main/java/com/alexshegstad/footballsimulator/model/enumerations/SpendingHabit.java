 package com.alexshegstad.footballsimulator.model.enumerations;

public enum SpendingHabit {
    MISERLY("Miserly", 0.6, 
        "This owner is extremely averse to financial risk. If there is a player that the team could do without, the team will likely do without. The fans are lucky there are seats available. This owner would prefer standing room only to save on the upholstery costs!"),
    FRUGAL("Frugal", 0.8,
        "This owner knows that you need to spend money in order to make a contender, but they also believe that there is little need to blow all of his funds on player after player. Owner is not likely to make a splash, but it could happen..."),
    AVERAGE("Average", 1.0,
        "This owner is neither likely nor unlikely to spend large amounts of money on acquiring new players. Depending on the salary cap, or the team's performance, they may spend a lot, or a little."),
    GENEROUS("Generous", 1.3,
        "This owner believes that you don't make an omelette without cracking a few eggs. While they know to make sure they are sound financially, they are ready, willing, and able to spend the money they believe is necessary to make their team a contender. Will almost certainly reach for a high-profile free agent when the opportunity arises."),
    EXTRAVAGANT("Extravagant", 1.7,
        "This owner spends money like it's his dad's money. Having little to no sense of what can be called a financial survival instinct, they are eager to spend money on the most expensive players available. Ticket prices might need to be raised to make up for the upcoming shopping spree.");

    private final String name;
    private final double spendingMultiplier;
    private final String description;

    SpendingHabit(String name, double spendingMultiplier, String description) {
        this.name = name;
        this.spendingMultiplier = spendingMultiplier;
        this.description = description;
    }

    public String getHabit() {
        return name;
    }

    /**
     * Get the spending multiplier for budget calculations
     * MISERLY: 0.6x spending (60% of normal)
     * FRUGAL: 0.8x spending (80% of normal)
     * AVERAGE: 1.0x spending (100% - baseline)
     * GENEROUS: 1.3x spending (130% of normal)
     * EXTRAVAGANT: 1.7x spending (170% of normal)
     */
    public double getSpendingMultiplier() {
        return spendingMultiplier;
    }

    public String getDescription() {
        return description;
    }
    
    /**
     * Calculate actual spending based on base budget
     */
    public double calculateSpending(double baseBudget) {
        return baseBudget * spendingMultiplier;
    }
    
    /**
     * Check if this owner is willing to spend on a player at this price
     */
    public boolean isWillingToSpend(double playerCost, double teamBudget) {
        double affordableAmount = teamBudget * spendingMultiplier;
        return playerCost <= affordableAmount;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
