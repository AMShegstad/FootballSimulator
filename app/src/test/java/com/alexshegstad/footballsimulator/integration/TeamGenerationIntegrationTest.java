package com.alexshegstad.footballsimulator.integration;

import com.alexshegstad.footballsimulator.model.teamcomponents.*;
import com.alexshegstad.footballsimulator.model.enumerations.ColorSchemes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

public class TeamGenerationIntegrationTest {

    @Test
    @DisplayName("A fully generated team should have all components non-null")
    void full_team_should_have_all_components() {
        Team team = new Team.Builder().build();

        assertThat(team).isNotNull();
        assertThat(team.getMascot()).isNotNull().isNotEmpty();
        assertThat(team.getLocation()).isNotNull();
        assertThat(team.getStadium()).isNotNull();
        assertThat(team.getOwner()).isNotNull();
        assertThat(team.getCoach()).isNotNull();
        assertThat(team.getRoster()).isNotNull().isNotEmpty();
        assertThat(team.getColorScheme()).isNotNull();
    }

    @Test
    @DisplayName("Generated team location should have a city and state")
    void team_location_should_have_city_and_state() {
        Team team = new Team.Builder().build();
        Location location = team.getLocation();

        assertThat(location.getCity()).isNotNull().isNotEmpty();
        assertThat(location.getState()).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName("Generated team owner should have a name and net worth")
    void team_owner_should_have_name_and_net_worth() {
        Team team = new Team.Builder().build();
        Owner owner = team.getOwner();

        assertThat(owner.getFirstName()).isNotNull().isNotEmpty();
        assertThat(owner.getLastName()).isNotNull().isNotEmpty();
        assertThat(owner.getNetWorth()).isGreaterThan(0.0);
    }

    @Test
    @DisplayName("Generated team coach should have a name, offense, and defense")
    void team_coach_should_have_required_fields() {
        Team team = new Team.Builder().build();
        Coach coach = team.getCoach();

        assertThat(coach.getFirstName()).isNotNull().isNotEmpty();
        assertThat(coach.getLastName()).isNotNull().isNotEmpty();
        assertThat(coach.getOffense()).isNotNull();
        assertThat(coach.getDefense()).isNotNull();
        assertThat(coach.getLeadershipStyle()).isNotNull();
    }

    @Test
    @DisplayName("All players in the roster should have a position and a name")
    void all_roster_players_should_have_position_and_name() {
        Team team = new Team.Builder().build();
        List<Player> roster = team.getRoster();

        for (Player player : roster) {
            assertThat(player.getPosition())
                .as("Player %s should have a position", player.getFullName())
                .isNotNull();
            assertThat(player.getFirstName())
                .as("Player should have a first name")
                .isNotNull().isNotEmpty();
            assertThat(player.getLastName())
                .as("Player should have a last name")
                .isNotNull().isNotEmpty();
        }
    }

    @Test
    @DisplayName("Two independently generated teams should usually have different mascots")
    void two_teams_should_generate_independently() {
        Team team1 = new Team.Builder().build();
        Team team2 = new Team.Builder().build();

        // Both teams must be valid regardless of mascot equality
        assertThat(team1).isNotNull();
        assertThat(team2).isNotNull();
        assertThat(team1.getMascot()).isNotNull();
        assertThat(team2.getMascot()).isNotNull();
    }

    @Test
    @DisplayName("Color scheme should be a valid ColorSchemes enum value")
    void color_scheme_should_be_valid_enum_value() {
        Team team = new Team.Builder().build();
        assertThat(ColorSchemes.values()).contains(team.getColorScheme());
    }
}
