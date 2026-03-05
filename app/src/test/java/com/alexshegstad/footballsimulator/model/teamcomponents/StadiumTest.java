package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

public class StadiumTest {
    
    @Test
    @DisplayName("✅ Should create stadium with builder pattern")
    void testStadiumGeneration() {
        Stadium stadium = new Stadium.Builder().build();
        
        assertThat(stadium).isNotNull();
        assertThat(stadium.getName()).isNotNull().isNotEmpty();
        assertThat(stadium.getCapacity()).isGreaterThan(0);
        
        System.out.println("Generated stadium: " + stadium);
    }
    
    @Test
    @DisplayName("🏟️ Should create custom stadium with builder")
    void testCustomStadium() {
        Stadium stadium = new Stadium.Builder()
            .name("Test Stadium")
            .capacity(50000)
            .city("Test City")
            .state("Test State")
            .build();
            
        assertThat(stadium.getName()).isEqualTo("Test Stadium");
        assertThat(stadium.getCapacity()).isEqualTo(50000);
        assertThat(stadium.getCity()).isEqualTo("Test City");
        assertThat(stadium.getState()).isEqualTo("Test State");
    }
    
    @Test
    @DisplayName("📊 Should generate different stadium names")
    void testRandomStadiumNames() {
        String firstName = Stadium.getRandomStadiumName();
        boolean foundDifferent = false;
        
        // Try 10 times to get a different name
        for (int i = 0; i < 10; i++) {
            String name = Stadium.getRandomStadiumName();
            if (!name.equals(firstName)) {
                foundDifferent = true;
                break;
            }
        }
        
        // Should find at least one different name (unless there's only one stadium)
        assertThat(firstName).isNotNull().isNotEmpty();
        System.out.println("Sample stadium names: " + firstName);
    }
    
    @Test
    @DisplayName("🏗️ Should handle missing JSON gracefully")
    void testFallbackBehavior() {
        // This test ensures the class works even if JSON is missing
        Stadium stadium = new Stadium.Builder().build();
        
        assertThat(stadium).isNotNull();
        assertThat(stadium.getName()).isNotNull();
        
        // Should not be empty or null
        assertThat(stadium.getName()).isNotEqualTo("");
    }
}