package com.alexshegstad.footballsimulator.integration;

import com.alexshegstad.footballsimulator.model.game.Gridiron;
import com.alexshegstad.footballsimulator.model.teamcomponents.Team;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class GameSimulationIntegrationTest {

    @Test
    @DisplayName("Gridiron should initialize with correct field dimensions")
    void gridiron_should_have_correct_dimensions() {
        assertThat(Gridiron.TOTAL_LENGTH).isEqualTo(120);
        assertThat(Gridiron.FIELD_LENGTH).isEqualTo(100);
        assertThat(Gridiron.ENDZONE_DEPTH).isEqualTo(10);
        assertThat(Gridiron.FIELD_WIDTH).isEqualTo(53);
    }

    @Test
    @DisplayName("Gridiron should be instantiable")
    void gridiron_should_be_instantiable() {
        Gridiron gridiron = new Gridiron();
        assertThat(gridiron).isNotNull();
    }

    @Test
    @Disabled("Pending full implementation of Matchup / game simulation")
    @DisplayName("A full game between two teams should produce a winner")
    void full_game_should_produce_a_winner() {
        Team home = new Team.Builder().build();
        Team away = new Team.Builder().build();
        // Placeholder: once Matchup is implemented, simulate a game and assert
        // that one team's score is greater than the other.
    }

    @Test
    @Disabled("Pending full implementation of Matchup / game simulation")
    @DisplayName("Scores should be non-negative after game simulation")
    void scores_should_be_non_negative() {
        // Placeholder: verify that neither team can have a negative score.
    }
}
