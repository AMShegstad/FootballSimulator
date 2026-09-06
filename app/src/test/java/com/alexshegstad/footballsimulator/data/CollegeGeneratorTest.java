package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.CollegeData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollegeGeneratorTest {

    private List<String> colleges;
    private CollegeGenerator collegeGenerator;

    @BeforeEach
    void setUp() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream is = getClass().getResourceAsStream("/colleges.json")) {
            CollegeData collegeData = mapper.readValue(is, CollegeData.class);
            colleges = collegeData.getTeams().stream()
                    .map(college -> college.getRegion())
                    .toList();
        }

        collegeGenerator = new CollegeGenerator();
    }

    @RepeatedTest(100)
    @DisplayName("getRandomCollege() never returns a null or empty value")
    void randomCollege_should_not_be_null_or_empty() {
        String college = collegeGenerator.getRandomCollege();
        assertThat(college).isNotEmpty();
    }

    @RepeatedTest(10)
    @DisplayName("getRandomCollege() always returns a college from the college list")
    void randomCollege_should_come_from_colleges_list() {
        String college = collegeGenerator.getRandomCollege();
        assertThat(colleges).contains(college);
    }

}
