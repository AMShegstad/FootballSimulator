package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertTrue;

public class DefenseTest {

    @Test
    @DisplayName("Defenses all have a name and description")
    void defense_should_have_both_name_and_description() {
        for (Defense defense : Defense.values()) {
            String[] def = defense.getDefense();
            assertThat(def).isNotNull().hasSize(2);
            assertThat(def[0]).isInstanceOf(String.class);
            assertThat(def[1]).isInstanceOf(String.class);
        }
    }
}
