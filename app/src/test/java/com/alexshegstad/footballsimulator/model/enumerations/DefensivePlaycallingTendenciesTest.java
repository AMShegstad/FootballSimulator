package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class DefensivePlaycallingTendenciesTest {

    @Test
    @DisplayName("Should have BALANCED, BLITZ_HEAVY, ZONE_FOCUSED, MAN_FOCUSED, BEND_DONT_BREAK tendencies")
    void should_have_all_defensive_tendencies() {
        assertThat(DefensivePlaycallingTendencies.values())
                .extracting(Enum::name)
                .containsExactly(
                        "BALANCED",
                        "BLITZ_HEAVY",
                        "ZONE_FOCUSED",
                        "MAN_FOCUSED",
                        "BEND_DONT_BREAK");
    }

    @Test
    @DisplayName("Each defensive tendency should have valid metadata")
    void should_have_valid_metadata() {
        for (DefensivePlaycallingTendencies tendency : DefensivePlaycallingTendencies.values()) {
            assertThat(tendency.getDisplayName()).isNotBlank();
            assertThat(tendency.getDescription()).isNotBlank();
            assertThat(tendency.getRiskLevel()).isBetween(1, 10);
            assertThat(tendency.toString()).isEqualTo(tendency.getDisplayName());
        }
    }
}
