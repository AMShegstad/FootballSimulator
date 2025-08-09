package com.alexshegstad.footballsimulator.model.enumerations;

public enum PlaycallingTendencies {
    AGGRESSIVE("Aggressive", "Takes risks, goes for big plays", 8),
    CONSERVATIVE("Conservative", "Plays it safe, minimizes mistakes", 4),
    BALANCED("Balanced", "Mix of aggressive and conservative calls", 6),
    INNOVATIVE("Innovative", "Uses creative, unexpected strategies", 9),
    DISCIPLINED("Disciplined", "Focuses on fundamentals and execution", 5);

    private final String displayName;
    private final String description;
    private final int riskLevel; // 1-10 scale

    PlaycallingTendencies(String displayName, String description, int riskLevel) {
        this.displayName = displayName;
        this.description = description;
        this.riskLevel = riskLevel;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    @Override
    public String toString() {
        return displayName;
    }
}

