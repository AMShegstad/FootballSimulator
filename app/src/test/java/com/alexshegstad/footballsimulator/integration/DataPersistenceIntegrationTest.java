package com.alexshegstad.footballsimulator.integration;

import com.alexshegstad.footballsimulator.data.NameGenerator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class DataPersistenceIntegrationTest {

    @Test
    @DisplayName("NameGenerator should load first names from JSON resource")
    void name_generator_should_load_first_names() {
        NameGenerator generator = new NameGenerator();
        String firstName = generator.getRandomFirstName();
        assertThat(firstName).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName("NameGenerator should load last names from JSON resource")
    void name_generator_should_load_last_names() {
        NameGenerator generator = new NameGenerator();
        String lastName = generator.getRandomLastName();
        assertThat(lastName).isNotNull().isNotEmpty();
    }

    @Test
    @Disabled("Pending implementation of save/load functionality")
    @DisplayName("A saved team should be loadable and equal to the original")
    void saved_team_should_be_loadable() {
        // Placeholder: once serialization/persistence is implemented,
        // save a Team object, reload it, and assert equality.
    }

    @Test
    @Disabled("Pending implementation of save/load functionality")
    @DisplayName("Saving and loading player stats should preserve all values")
    void saved_player_stats_should_be_preserved() {
        // Placeholder: verify that stat values survive a round-trip
        // through the persistence layer.
    }
}
