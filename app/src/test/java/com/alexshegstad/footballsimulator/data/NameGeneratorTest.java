package com.alexshegstad.footballsimulator.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
//import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NameGeneratorTest {

    private List<String> firstNames;
    private List<String> lastNames;
    private NameGenerator nameGenerator;

    @BeforeEach
    void setUp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream fn = getClass().getResourceAsStream("/firstNames.json")) {
            firstNames = mapper.readValue(fn, new TypeReference<List<String>>() {
            });
        }

        try (InputStream ln = getClass().getResourceAsStream("/lastNames.json")) {
            lastNames = mapper.readValue(ln, new TypeReference<List<String>>() {
            });
        }

        nameGenerator = new NameGenerator();
    }

    @RepeatedTest(100)
    @DisplayName("getRandomFirstName() never returns a null or empty value")
    void randomFirstName_should_not_be_null_or_empty() {
        String firstName = nameGenerator.getRandomFirstName();
        assertThat(firstName).isNotEmpty();
    }

    @RepeatedTest(100)
    @DisplayName("getRandomLastName() never returns a null or empty value")
    void randomLastName_should_not_be_null_or_empty() {
        String lastName = nameGenerator.getRandomLastName();
        assertThat(lastName).isNotEmpty();
    }

    @RepeatedTest(10)
    @DisplayName("getRandomFirstName() always returns a name from the first name list")
    void randomFirstName_should_come_from_firstNames_list() {
        String firstName = nameGenerator.getRandomFirstName();
        assertThat(firstNames).contains(firstName);
    }

    @RepeatedTest(10)
    @DisplayName("getRandomLastName() always returns a name from the last name list")
    void randomLastName_should_come_from_lastNames_list() {
        String lastName = nameGenerator.getRandomLastName();
        assertThat(lastNames).contains(lastName);
    }

}
