package com.alexshegstad.footballsimulator.model.enumerations;

public enum SpendingHabit {
    MISERLY("Miserly", "This owner is extremely averse to financial risk. If there is a player that the team could do without, the team will likely do without. The fans are lucky there are seats available. This owner would prefer standing room only to save on the upholstery costs!"),
    FRUGAL("Frugal","This owner knows that you need to spend money in order to make a contender, but they also believe that there is little need to blow all of his funds on player after player. Owner is not likely to make a splash, but it could happen..."),
    AVERAGE("Average","This owner is neither likely nor unlikely to spend large amounts of money on acquiring new players. Depending on the salary cap, or the team's performance, they may spend a lot, or a little."),
    GENEROUS("Generous","This owner believes that you don't make an omelette without cracking a few eggs. While they know to make sure they are sound financially, they are ready, willing, and able to spend the money they believe is necessary to make their team a contender. Will almost certainly reach for a high-profile free agent when the opportunity arises."),
    EXTRAVAGANT("Extravagant", "This owner spends money like it's his dad's money. Having little to no sense of what can be called a financial survival instinct, they are eager to spend money on the most expensive players available. Ticket prices might need to be raised to make up for the upcoming shopping spree.");

    private final String name;
    private final String description;

    SpendingHabit(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getHabit() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + ": " + description;
    }
}
