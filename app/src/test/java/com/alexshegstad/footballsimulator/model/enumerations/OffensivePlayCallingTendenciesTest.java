package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;


public class OffensivePlayCallingTendenciesTest {

    @Test
    @DisplayName("Does the OffensivePlaycallingTendencies object contain all three values (String displayNAme, String description, int riskLevel)?")
    void should_contain_displayName_description_and_riskLevel() {
        for (OffensivePlaycallingTendencies oplaycalls : OffensivePlaycallingTendencies.values()) {
            assertThat(oplaycalls.getDisplayName()).isInstanceOf(String.class);
            assertThat(oplaycalls.getDescription()).isInstanceOf(String.class);
            assertThat(oplaycalls.getRiskLevel()).isInstanceOf(Integer.class);
            assertTrue(oplaycalls.toString() == oplaycalls.getDisplayName());
        }
    }
    

}
