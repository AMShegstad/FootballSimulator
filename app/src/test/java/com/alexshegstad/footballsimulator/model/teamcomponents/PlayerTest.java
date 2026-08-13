package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;

public class PlayerTest {

    @Test
    @DisplayName("No null values on default QB build")
    void no_null_values() {
        Player testPlayer = new Player.Builder(Position.QB).build();
        System.out.println(testPlayer.toString());

        assertThat(testPlayer.getFirstName()).isNotNull().isNotEmpty();
        assertThat(testPlayer.getLastName()).isNotNull().isNotEmpty();
        assertThat(testPlayer.getPosition()).isNotNull();
    }

    @Test
    @DisplayName("getFullName() should combine first and last name")
    void full_name_should_combine_first_and_last() {
        Player player = new Player.Builder(Position.WR)
            .firstName("Alex")
            .lastName("Smith")
            .build();

        assertThat(player.getFullName()).isEqualTo("Alex Smith");
    }

    @Test
    @DisplayName("Position should be preserved when set via builder")
    void position_should_be_preserved() {
        for (Position pos : Position.values()) {
            Player player = new Player.Builder(pos).build();
            assertThat(player.getPosition()).isEqualTo(pos);
        }
    }

    @Test
    @DisplayName("Hometown and college should not be null on default build")
    void hometown_and_college_should_not_be_null() {
        Player player = new Player.Builder(Position.HB).build();
        assertThat(player.getHometown()).isNotNull();
        assertThat(player.getCollege()).isNotNull();
    }

    @Test
    @DisplayName("Preferred leadership style should not be null")
    void preferred_leadership_style_should_not_be_null() {
        Player player = new Player.Builder(Position.MLB).build();
        assertThat(player.getPreferredLeadershipStyle()).isNotNull();
        assertThat(player.getPreferredLeadershipStyle()).isInstanceOf(LeadershipStyle.class);
    }

    @Test
    @DisplayName("Handedness should not be null")
    void handedness_should_not_be_null() {
        Player player = new Player.Builder(Position.QB).build();
        assertThat(player.getHandedness()).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName("Tracked stats should start at zero for a new player")
    void tracked_stats_should_start_at_zero() {
        Player player = new Player.Builder(Position.FS).build();
        assertThat(player.getStarts()).isZero();
        assertThat(player.getWins()).isZero();
        assertThat(player.getLosses()).isZero();
        assertThat(player.getDraws()).isZero();
        assertThat(player.getGamesPlayed()).isZero();
        assertThat(player.getSeasonsPlayed()).isZero();
        assertThat(player.getDownsPlayed()).isZero();
        assertThat(player.getMatchupWins()).isZero();
    }

    @Test
    @DisplayName("addStart() should increment starts")
    void add_start_should_increment() {
        Player player = new Player.Builder(Position.QB).build();
        player.addStart(1);
        assertThat(player.getStarts()).isEqualTo(1);
        player.addStart(4);
        assertThat(player.getStarts()).isEqualTo(5);
    }

    @Test
    @DisplayName("addWins() and addLosses() should increment independently")
    void wins_and_losses_should_increment_independently() {
        Player player = new Player.Builder(Position.CB).build();
        player.addWins(3);
        player.addLosses(2);
        assertThat(player.getWins()).isEqualTo(3);
        assertThat(player.getLosses()).isEqualTo(2);
    }

    @Test
    @DisplayName("toString() should not return null or empty")
    void to_string_should_not_be_null_or_empty() {
        Player player = new Player.Builder(Position.K).build();
        assertThat(player.toString()).isNotNull().isNotEmpty();
    }
}
