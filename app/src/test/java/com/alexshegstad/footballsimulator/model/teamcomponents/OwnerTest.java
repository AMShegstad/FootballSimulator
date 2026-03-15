package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;
//import com.alexshegstad.footballsimulator.model.enumerations.*;

public class OwnerTest {
    
    @Test
    @DisplayName("Should create Owner object with builder pattern")
    void testOwnerGeneration() {
        Owner owner = new Owner.Builder().build();

        assertThat(owner).isNotNull();
        assertThat(owner.getFirstName()).isNotEmpty();
        assertThat(owner.getLastName()).isNotEmpty();
        assertThat(owner.getAge()).isNotNull();
        assertThat(owner.getNetWorth()).isNotNull();
        assertThat(owner.getSpendingHabit()).isNotNull();
        assertThat(owner.toString()).isNotEmpty();

        System.out.println(owner.toString());
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

            assertThat(owner.getFirstName()).isEqualTo("Alexander");
            assertThat(owner.getLastName()).isEqualTo("Shegstad");
            assertThat(owner.getAge()).isEqualTo(36);
            assertThat(owner.getNetWorth()).isEqualTo(10_000_000.00);
    }
}
