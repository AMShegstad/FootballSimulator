package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.Coach;
import com.alexshegstad.footballsimulator.model.teamcomponents.Player;
//import com.alexshegstad.footballsimulator.model.teamcomponents.Position;
import com.alexshegstad.footballsimulator.model.teamcomponents.Location;
import com.alexshegstad.footballsimulator.model.teamcomponents.ColorScheme;
import com.alexshegstad.footballsimulator.data.PlayerGenerator;
import java.util.*;

/*/
This class will need to invoke the following other classes in order to construct an entire team's worth of data:
*/

public class TeamGenerator {
    
    // Staff
    private final Coach coach;
    private final List<Player> roster;
    private List<Player> startingOffense;
    private List<Player> startingDefense;
    private List<Player> startingSpecialTeams;

    // Team information
    private final String teamName;
    private final Location location;
    private final ColorScheme colorScheme;

    // Don't know if I'll use these, but it can't hurt to have them, for now.
    private static final int STARTING_UNIT_SIZE = 11;
    //private static final int COACHING_STAFF_SIZE = 8;
    //private static final int NUM_STATS = 20;

    // constructor using Builder object
    private Team (Builder builder) {
        this.coach = builder.coach != null ? builder.coach : generateCoach();
        this.roster = builder.roster != null ? builder.roster : generateRoster();
        this.startingOffense = selectStartingOffense();
        this.startingDefense = selectStartingDefense();
        this.startingSpecialTeams = selectStartingSpecialTeams();
        this.teamName = builder.teamName != null ? builder.teamName : generateTeamName();
        this.location = builder.location != null ? builder.location : generateLocation();
        this.colorScheme = builder.colorScheme != null ? builder.colorScheme : generateColorScheme();
    }

    private static Coach generateCoach() {
        Coach coach = new Coach.Builder().build();
        return coach;
    }

}
