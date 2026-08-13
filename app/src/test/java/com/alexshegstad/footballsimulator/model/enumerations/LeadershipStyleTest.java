package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class LeadershipStyleTest {

    @Test
    @DisplayName("Should have exactly 7 leadership style types")
    void should_have_seven_leadership_styles() {
        assertThat(LeadershipStyle.values()).hasSize(7);
    }

    @Test
    @DisplayName("Should contain all expected leadership style values")
    void should_contain_all_leadership_style_values() {
        assertThat(LeadershipStyle.values()).contains(
            LeadershipStyle.AUTOCRATIC,
            LeadershipStyle.DEMOCRATIC,
            LeadershipStyle.HOLISTIC,
            LeadershipStyle.LAISSEZFAIRE,
            LeadershipStyle.BUREACRATIC,
            LeadershipStyle.MINDFUL,
            LeadershipStyle.DEVELOPMENTAL
        );
    }

    @Test
    @DisplayName("Should be able to look up leadership style by name")
    void should_be_able_to_lookup_style_by_name() {
        assertThat(LeadershipStyle.valueOf("AUTOCRATIC")).isEqualTo(LeadershipStyle.AUTOCRATIC);
        assertThat(LeadershipStyle.valueOf("DEMOCRATIC")).isEqualTo(LeadershipStyle.DEMOCRATIC);
        assertThat(LeadershipStyle.valueOf("HOLISTIC")).isEqualTo(LeadershipStyle.HOLISTIC);
        assertThat(LeadershipStyle.valueOf("LAISSEZFAIRE")).isEqualTo(LeadershipStyle.LAISSEZFAIRE);
        assertThat(LeadershipStyle.valueOf("BUREACRATIC")).isEqualTo(LeadershipStyle.BUREACRATIC);
        assertThat(LeadershipStyle.valueOf("MINDFUL")).isEqualTo(LeadershipStyle.MINDFUL);
        assertThat(LeadershipStyle.valueOf("DEVELOPMENTAL")).isEqualTo(LeadershipStyle.DEVELOPMENTAL);
    }

    @Test
    @DisplayName("Leadership style names should not be blank")
    void leadership_style_names_should_not_be_blank() {
        for (LeadershipStyle style : LeadershipStyle.values()) {
            assertThat(style.name()).isNotBlank();
        }
    }

    @Test
    @DisplayName("Leadership style ordinals should be sequential")
    void leadership_style_ordinals_should_be_sequential() {
        LeadershipStyle[] values = LeadershipStyle.values();
        for (int i = 0; i < values.length; i++) {
            assertThat(values[i].ordinal()).isEqualTo(i);
        }
    }
}
