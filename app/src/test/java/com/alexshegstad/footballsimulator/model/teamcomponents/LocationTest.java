package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

public class LocationTest {
  
    @Test
    @DisplayName("Should create Location object with builder pattern")
    void testLocationGeneration() {
        Location location = new Location.Builder().build();

        assertThat(location).isNotNull();
        assertThat(location.getCity()).isNotEmpty();
        assertThat(location.getState()).isNotEmpty();
        System.out.println(location.toString());
    }
}
