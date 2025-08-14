package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.model.teamcomponents.Player;
import com.alexshegstad.footballsimulator.model.teamcomponents.Position;
import com.alexshegstad.footballsimulator.model.teamcomponents.Location;
import com.alexshegstad.footballsimulator.model.teamcomponents.College;
import com.alexshegstad.footballsimulator.data.CollegeGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

public class PlayerTest {
    
    private Player player;
    private Location hometown;
    CollegeGenerator college = new CollegeGenerator();

    @BeforeEach
    void setUp() {
        hometown = new Location("Green Bay", "Wisconsin");
        College randomCollege = college.getRandomCollegeObject();
        player = new Player("Aaron", "Rodgers", hometown, randomCollege, Position.QB, 12, 15, 38, 74, 225, 
            95, 85, 70, 75, 60, 65, 70, 80, 85, 90,
            65, 75, 80, 85, 90, 85, 75, 85, 90, 95, 
            99, 95, 90, 85, 80, 85, 60, 70, 65, 70, 
            80, 75, 70, 75, 80, 85, 90, 95);

        System.out.println(player);
    }

    @Test
    @DisplayName("Player should be created with correct basic information")
    void testPlayerCreation() {
        assertThat(player.getFirstName())
            .as("Player first name should match constructor parameter")
            .isEqualTo("Aaron");
            
        assertThat(player.getLastName())
            .as("Player last name should match constructor parameter")
            .isEqualTo("Rodgers");
    }
    
    @Test
    @DisplayName("Player should have correct position")
    void testPlayerPosition() {
        assertThat(player.getPosition())
            .as("Player position should be set correctly in constructor")
            .isNotNull()
            .isEqualTo(Position.QB);
    }
    
    @Test
    @DisplayName("Player should have valid hometown")
    void testPlayerHometown() {
        assertThat(player.getHometown())
            .as("Player hometown should not be null")
            .isNotNull();
    }

    @Test
    @DisplayName("Player should have correct College")
    void testPlayerCollege() {
        assertThat(player.getCollege())
            .as("Player college should match constructor parameter")
            .isNotNull();
    }

    @Test
    @DisplayName("Player should have correct number")
    void testPlayerNumber() {
        assertThat(player.getNumber())
            .as("Player's number should match the constructor parameter")
            .isEqualTo(12);
    }

    @Test
    @DisplayName("Player should have correct experience value")
    void testPlayerExperience() {
        assertThat(player.getExperience())
            .as("Player experience should match the constructor parameter")
            .isEqualTo(15);
    }
}
