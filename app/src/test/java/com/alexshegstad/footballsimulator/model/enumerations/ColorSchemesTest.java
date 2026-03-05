package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColorSchemesTest {
    
    @Test
    @DisplayName("Do ColorSchemes all have a name and three color codes?")
    void should_have_name_and_three_color_codes_for_every_scheme() {
        for (ColorSchemes scheme : ColorSchemes.values()) {
            String[] cs = scheme.getColorScheme();
            assertThat(cs).hasSize(4);
            assertThat(cs[0]).isNotBlank();
        }
    }

    @Test
    @DisplayName("Does ColorCode1 hexcode have the '#'?") 
    void getColorCode1_should_return_String_starting_with_hashtag() {
        ColorSchemes cs = ColorSchemes.values()[0];
        String color1 = cs.getColorCode1();
        assertTrue(color1.charAt(0) == '#');

    }

    @Test
    @DisplayName("Does ColorCode2 hexcode have the '#'?")
    void getColorCode2_should_return_String_starting_with_hashtag() {
        ColorSchemes cs = ColorSchemes.values()[0];
        String color2 = cs.getColorCode2();
        assertTrue(color2.charAt(0) == '#');
    }

    @Test
    @DisplayName("Does ColorCode3 hexcode have the'#'?")
    void getColorCode3_should_return_String_starting_with_hashtag() {
        ColorSchemes cs = ColorSchemes.values()[0];
        String color3 = cs.getColorCode3();
        assertTrue(color3.charAt(0) == '#');
    }
}
