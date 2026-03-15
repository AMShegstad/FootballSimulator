package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.alexshegstad.footballsimulator.model.enumerations.ColorSchemes;
import java.util.*;

public class TeamTest {

    @Test
    void CreateTeam() { 
        Team a = new Team.Builder().build();
        assertTrue(a != null);
    }

    @Test 
    void testMascotCreation() {
        Team b = new Team.Builder().build();
        String mascot = b.getMascot();
        assertTrue(mascot != null);
        System.out.println("Mascot is " + mascot);
    }
    
    @Test
    void testVariableGeneration() {
        Team t = new Team.Builder().build();
        String mascot = t.getMascot();
        Location location = t.getLocation();
        Stadium stadium = t.getStadium();
        Owner owner = t.getOwner();
        Coach coach = t.getCoach();
        List<Player> roster = t.getRoster();
        ColorSchemes colors = t.getColorScheme();

        System.out.println(t.toString());

        assertTrue(mascot != null);
        assertTrue(location != null);
        assertTrue(stadium != null);
        assertTrue(owner != null);
        assertTrue(coach != null);
        assertTrue(roster != null);
        assertTrue(colors != null);
    }
}
