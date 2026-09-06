package com.alexshegstad.footballsimulator.model.enumerations;

public enum DefensivePlaycallingTendencies {
    BALANCED("Balanced", "Mixes man and zone coverage with moderate blitzing", 5),
    BLITZ_HEAVY("Blitz Heavy", "Prioritizes pressure and disruption, even at the cost of coverage", 8),
    ZONE_FOCUSED("Zone Focused", "Keeps the play in front of defenders and limits long gains", 3),
    MAN_FOCUSED("Man Focused", "Relies on tight man-to-man coverage and matchup-based defense", 6),
    BEND_DONT_BREAK("Bend Don't Break", "Prevents explosive plays and forces long drives", 2);

    private final String displayName;
    private final String description;
    private final int riskLevel;

    DefensivePlaycallingTendencies(String displayName, String description, int riskLevel) {
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
 * 
 * BALANCED
 * 
 * Description: Mixes man and zone coverage with moderate blitzing.
 * 
 * AI Behavior:
 * 
 * Adapts to offensive formation and down/distance.
 * 
 * Blitzes occasionally (e.g., 20–25% of the time).
 * 
 * Personality Type: Flexible, game-plan driven coach.
 * 
 * BLITZ_HEAVY
 * 
 * Description: Prioritizes pressure and disruption, even at the cost of
 * coverage.
 * 
 * AI Behavior:
 * 
 * Blitzes frequently (40–60% of plays).
 * 
 * Leaves secondary exposed.
 * 
 * High sack potential, but vulnerable to big plays.
 * 
 * Personality Type: Gregg Williams, Wink Martindale.
 * 
 * ZONE_FOCUSED
 * 
 * Description: Prefers keeping the play in front of defenders, emphasizing zone
 * coverage.
 * 
 * AI Behavior:
 * 
 * Rarely blitzes.
 * 
 * Allows short completions but limits long gains.
 * 
 * Great against deep pass offenses, weak vs. short throws.
 * 
 * Personality Type: Tony Dungy or Lovie Smith (Tampa 2 style).
 * 
 * MAN_FOCUSED
 * 
 * Description: Relies on tight man-to-man coverage and matchup-based defense.
 * 
 * AI Behavior:
 * 
 * Uses man coverage on most plays.
 * 
 * Blitzes selectively to complement coverage.
 * 
 * Vulnerable if corners are outmatched.
 * 
 * Personality Type: Bill Belichick, Steve Spagnuolo.
 * 
 * BEND_DONT_BREAK
 * 
 * Description: Prevents explosive plays and forces long drives that may stall.
 * 
 * AI Behavior:
 * 
 * Plays conservative coverage (soft zones).
 * 
 * Focuses on red-zone defense.
 * 
 * Blitz rate is low; turnover focus is situational.
 * 
 * Personality Type: Classic defensive coordinators prioritizing containment.
 */