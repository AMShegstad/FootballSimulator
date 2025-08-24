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
    private CollegeGenerator college = new CollegeGenerator();

    @BeforeEach
    void setUp() {
        hometown = new Location("Green Bay", "Wisconsin");
        College randomCollege = college.getRandomCollegeObject();
        
        // Debug output
        System.out.println("Selected college: " + randomCollege);
        System.out.println("College region: " + randomCollege.getRegion());
        
        player = new Player("Aaron", "Rodgers", hometown, randomCollege, Position.QB, 12, 15, 38, 74, 225, 
            95, 85, 70, 75, 60, 65, 70, 80, 85, 90,
            65, 75, 80, 85, 90, 85, 75, 85, 90, 95, 
            99, 95, 90, 85, 80, 85, 60, 70, 65, 70, 
            80, 75, 70, 75, 80, 85, 90, 95);

        System.out.println("Player created: " + player);
    }

    @Test
    @DisplayName("✅ Player should be created with correct basic information")
    void testPlayerCreation() {
        assertThat(player).isNotNull();
        assertThat(player.getFirstName()).isEqualTo("Aaron");
        assertThat(player.getLastName()).isEqualTo("Rodgers");
        assertThat(player.getNumber()).isEqualTo(12);
        assertThat(player.getAge()).isEqualTo(38);
    }
    
    @Test
    @DisplayName("🏈 Player should have correct position")
    void testPlayerPosition() {
        assertThat(player.getPosition())
            .as("Player position should be set correctly in constructor")
            .isNotNull()
            .isEqualTo(Position.QB);
    }
    
    @Test
    @DisplayName("📍 Player should have valid hometown")
    void testPlayerHometown() {
        assertThat(player.getHometown())
            .as("Player hometown should not be null")
            .isNotNull();
            
        assertThat(player.getHometown().getCity()).isEqualTo("Green Bay");
        assertThat(player.getHometown().getState()).isEqualTo("Wisconsin");
    }

    @Test
    @DisplayName("🎓 Player should have valid college")
    void testPlayerCollege() {
        assertThat(player.getCollege())
            .as("Player college should not be null")
            .isNotNull();
            
        assertThat(player.getCollege().getRegion())
            .as("College should have a region")
            .isNotNull()
            .isNotEmpty();
    }
}
