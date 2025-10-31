package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.Coach;
import com.alexshegstad.footballsimulator.model.teamcomponents.Player;
//import com.alexshegstad.footballsimulator.model.teamcomponents.Position;
import java.util.*;

/*/
This class will need to invoke the following other classes in order to construct an entire team's worth of data:
*/

public class TeamGenerator {
    
    // Staff
    private Coach coach;
    private Player[] roster;
    private Player[] startingOffense;
    private Player[] startingDefense;
    private Player[] specialTeams;

    // Team information
    private String teamName;
    private String city;
    private double[] teamStatistics;
    private String[] teamColorScheme;

    // Don't know if I'll use these, but it can't hurt to have them, for now.
    //private static final int ROSTER_SIZE = 53;
    private static final int STARTING_UNIT_SIZE = 11;
    private static final int COACHING_STAFF_SIZE = 8;
    private static final int NUM_COLORS = 3;
    private static final int NUM_STATS = 20;

    // Empty-Argument and Overridden Constructors
    public TeamGenerator() {
        generateTeam();
        initializeArrays();
    }

    public TeamGenerator(String teamName, String city) {
        this.teamName = teamName;
        this.city = teamName;
        initializeArrays();
        generateTeam();
    }

    public TeamGenerator(String teamName, String city, Player[] roster) {
        this.teamName = teamName;
        this.city = city;
        this.roster = roster;
        initializeArrays();
        generateTeam();
    } 

    private void initializeArrays() {
        //roster = new Player[ROSTER_SIZE];
        startingOffense = new Player[STARTING_UNIT_SIZE];
        startingDefense = new Player[STARTING_UNIT_SIZE];
        specialTeams = new Player[15];
        // coachingStaff = new Coach[COACHING_STAFF_SIZE];
        teamStatistics = new double[NUM_STATS];
    }

    private Player[] selectStartingOffense(Player[] roster) {
        // GOAL: return array with the top QB, HB, FB, LT, LG, C, RG, RT, WR1, WR2, TE using roster variable.

            /* Step 1: Select all Player Objects from the roster matching the position */

            /* Step 2: Create a sub-array for the selected position, in order of calculatedOverallValue */

            /* Step 3: Select the appropriate number of starting positions, beginning at array index 0 */

        // Take in the entire array and add it to a variable


        // Initialize the startingOffense array


        // Sort the array using overall statistic (Might need to add that)


        // Add the top-rated QB to startingOffense[], and so on and so forth
    }

    private Player[] selectStartingDefense(Player[] roster) {
        // GOAL: return array with the top CB1, CB2, CBN, DT, RE, LE, LOLB, ROLB, MLB, SS, FS using roster variable.

        // Take in the entire array and add it to a variable

        // Initialize the startingDefense array

        // Sort the array using the overall statistic 

        // Add the top-rated CB1 to startingDefense[], and so on and so forth
    }

    private Player[] selectSpecialTeamsKick(Player[] roster, Player[] startingO, Player [] startingD) {
        // GOAL: return array with the top K, P, C, holder(QB3) and pursuit/blocking team.

        // Take in the entire array and add it to a variable

        // Initialize the specialTeamsKick array

        // Sort the array unsing the overall statistic

        // Add the top-rated
    }

    private Player[] selectSpecialTeamsReturn(Player[] roster) {
        // return array with the top kick returners, punt returners, and blockers.
    }

    private generateCoach() {
        // Return array containing Coach, OC, DC, STC
    }

    private void generateTeam() {
        // generateRoster();
        // selectStarters();
        // generateCoachingStaff();
        // initializeTeamStats();

        // Create Team with generated data
    }


}
