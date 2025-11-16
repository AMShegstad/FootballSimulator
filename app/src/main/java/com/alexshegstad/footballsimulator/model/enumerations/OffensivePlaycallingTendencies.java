package com.alexshegstad.footballsimulator.model.enumerations;

public enum OffensivePlaycallingTendencies {
    AGGRESSIVE("Aggressive", "Takes risks, goes for big plays", 8),
    CONSERVATIVE("Conservative", "Plays it safe, minimizes mistakes", 4),
    BALANCED("Balanced", "Mix of aggressive and conservative calls", 6),
    INNOVATIVE("Innovative", "Uses creative, unexpected strategies", 9),
    DISCIPLINED("Disciplined", "Focuses on fundamentals and execution", 5);

    private final String displayName;
    private final String description;
    private final int riskLevel; // 1-10 scale

    OffensivePlaycallingTendencies(String displayName, String description, int riskLevel) {
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


/**
 * 💡 Descriptions & Behavioral Guidelines

BALANCED

Description: Mixes run and pass plays evenly (e.g., 50/50 or situation-dependent).

AI Behavior: Chooses plays based on down and distance rather than preference.

Use Case: Default or average-style coach.

AGGRESSIVE_PASS

Description: Prefers to pass often, even in risky situations.

AI Behavior:

High pass percentage (e.g., 70–80%).

More deep routes or “go for it” decisions on 4th down.

Personality Type: Think Andy Reid or Sean McVay.

RUN_HEAVY

Description: Prioritizes establishing the run game.

AI Behavior:

High run percentage (e.g., 65–75%).

Uses play-action occasionally but avoids long passing downs.

Personality Type: Mike Vrabel or Kyle Shanahan.

CONSERVATIVE

Description: Focuses on safe plays, field position, and avoiding turnovers.

AI Behavior:

Runs often on early downs.

Avoids deep passes.

Punts or kicks field goals on 4th down, even when trailing.

Personality Type: Bill Belichick’s situational caution.

BIG_PLAY_HUNTER

Description: Always looking for explosive plays, regardless of risk.

AI Behavior:

Calls frequent deep shots or trick plays.

May ignore short gains for potential long passes.

Takes risks on 4th down.

Personality Type: Bruce Arians or Mike McDaniel.

CLOCK_CONTROLLER (bonus)

Description: Focused on time of possession and wearing down the opponent.

AI Behavior:

Prefers short runs, short passes, and long drives.

Avoids incomplete passes and turnovers.

Great for late-game management.
 */
