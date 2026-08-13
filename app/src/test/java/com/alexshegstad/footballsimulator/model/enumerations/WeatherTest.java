package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;

public class WeatherTest {

    @Test
    @DisplayName("Should have exactly 6 weather types")
    void should_have_six_weather_types() {
        assertThat(Weather.values()).hasSize(6);
    }

    @Test
    @DisplayName("Should contain all expected weather values")
    void should_contain_all_expected_weather_values() {
        assertThat(Weather.values()).contains(
                Weather.CLEAR,
                Weather.SNOWY,
                Weather.SWELTERING,
                Weather.RAINY,
                Weather.FOGGY,
                Weather.OVERCAST);
    }

    @Test
    @DisplayName("Weather enum names should match their declared names")
    void weather_name_should_match_declaration() {
        assertThat(Weather.CLEAR.name()).isEqualTo("CLEAR");
        assertThat(Weather.SNOWY.name()).isEqualTo("SNOWY");
        assertThat(Weather.SWELTERING.name()).isEqualTo("SWELTERING");
        assertThat(Weather.RAINY.name()).isEqualTo("RAINY");
        assertThat(Weather.FOGGY.name()).isEqualTo("FOGGY");
        assertThat(Weather.OVERCAST.name()).isEqualTo("OVERCAST");
    }

    @Test
    @DisplayName("Should be able to look up weather by name")
    void should_be_able_to_lookup_weather_by_name() {
        assertThat(Weather.valueOf("CLEAR")).isEqualTo(Weather.CLEAR);
        assertThat(Weather.valueOf("SNOWY")).isEqualTo(Weather.SNOWY);
        assertThat(Weather.valueOf("RAINY")).isEqualTo(Weather.RAINY);
    }

    @Test
    @DisplayName("Weather ordinals should be sequential starting at 0")
    void weather_ordinals_should_be_sequential() {
        Weather[] values = Weather.values();
        for (int i = 0; i < values.length; i++) {
            assertThat(values[i].ordinal()).isEqualTo(i);
        }
    }
}
