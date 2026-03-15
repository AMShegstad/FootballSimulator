package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;

// import com.alexshegstad.footballsimulator.model.enumerations.*;

public class PlayerTest {
  
    @Test
    @DisplayName("No null values")
    void no_null_values() {
        Player testPlayer = new Player.Builder(Position.QB).build();
        System.out.println(testPlayer.toString());

        assertTrue(testPlayer.getFirstName() != null);
        assertTrue(testPlayer.getLastName() != null);
        assertTrue(testPlayer.getPosition() != null);
    }
}
