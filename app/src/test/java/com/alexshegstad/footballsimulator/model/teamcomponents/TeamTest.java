package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.alexshegstad.footballsimulator.model.enumerations.*;
import java.util.*;

public class TeamTest {
    
    @Test void testVariableGeneration() {
        Team t = new Team.Builder().build();
        System.out.println(t);
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
