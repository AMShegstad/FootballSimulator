package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;
import com.alexshegstad.footballsimulator.model.enumerations.*;

public class OwnerTest {
    
    @Test
    @DisplayName("Should create Owner object with builder pattern")
    void testOwnerGeneration() {
        Owner owner = new Owner.Builder().build();

        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isNotNull().isNotEmpty();
        assertThat(owner.getLastName()).isNotNull().isNotEmpty();
        assertThat(owner.getAge()).isNotNull();
        assertThat(owner.getNetWorth()).isNotNull();
        assertThat(owner.getSpendingHabit()).isNotNull();
        assertThat(owner.toString()).isNotNull().isNotEmpty();
    }

    @Test
    @DisplayName("Should create Owner object using supplied fields")
    void testParameterizedOwnerGeneration() {
        Owner owner = new Owner.Builder()
            .setFirstName("Alexander")
            .setLastName("Shegstad")
            .setAge(36)
            .setNetWorth(10_000_000.00)
            .build();

            assertThat(owner.getFirstName() == "Alexander");
            assertThat(owner.getLastName() == "Shegstad");
            assertThat(owner.getAge() == 36);
            assertThat(owner.getNetWorth() == 10_000_000.00);
    }
}
