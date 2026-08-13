package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class OffenseTest {

    @Test
    @DisplayName("Should have exactly 4 offensive scheme types")
    void should_have_four_offense_types() {
        assertThat(Offense.values()).hasSize(4);
    }

    @Test
    @DisplayName("Should contain all expected offensive scheme values")
    void should_contain_all_expected_offense_values() {
        assertThat(Offense.values()).contains(
            Offense.run_heavy,
            Offense.pass_heavy,
            Offense.balanced,
            Offense.west_coast
        );
    }

    @Test
    @DisplayName("Should be able to look up offense by name")
    void should_be_able_to_lookup_offense_by_name() {
        assertThat(Offense.valueOf("run_heavy")).isEqualTo(Offense.run_heavy);
        assertThat(Offense.valueOf("pass_heavy")).isEqualTo(Offense.pass_heavy);
        assertThat(Offense.valueOf("balanced")).isEqualTo(Offense.balanced);
        assertThat(Offense.valueOf("west_coast")).isEqualTo(Offense.west_coast);
    }

    @Test
    @DisplayName("Offense ordinals should be sequential")
    void offense_ordinals_should_be_sequential() {
        Offense[] values = Offense.values();
        for (int i = 0; i < values.length; i++) {
            assertThat(values[i].ordinal()).isEqualTo(i);
        }
    }
}
