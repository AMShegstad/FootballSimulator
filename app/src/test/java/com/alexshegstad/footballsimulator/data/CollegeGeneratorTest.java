package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.teamcomponents.College;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

class CollegeGeneratorTest {
    
    private CollegeGenerator collegeGenerator;
    
    @BeforeEach
    void setUp() {
        collegeGenerator = new CollegeGenerator();
    }
    
    @Test
    @DisplayName("✅ Should load 320 colleges from JSON")
    void testCollegeLoading() {
        assertThat(collegeGenerator.isLoaded()).isTrue();
        assertThat(collegeGenerator.getCollegeCount()).isEqualTo(320); // Based on your JSON
    }
    
    @Test
    @DisplayName("🏫 Should generate random college names")
    void testRandomCollege() {
        String collegeName = collegeGenerator.getRandomCollege();
        
        assertThat(collegeName).isNotNull();
        assertThat(collegeName).isNotEmpty();
        assertThat(collegeName).isNotEqualTo("Unknown College");
    }
    
    @Test
    @DisplayName("🎓 Should generate valid college objects")
    void testRandomCollegeObject() {
        College college = collegeGenerator.getRandomCollegeObject();
        
        assertThat(college).isNotNull();
        assertThat(college.getRegion()).isNotNull().isNotEmpty();
        assertThat(college.getName()).isNotNull().isNotEmpty();
        assertThat(college.getAbbrev()).isNotNull().isNotEmpty();
    }
    
    @Test
    @DisplayName("🔍 Should find specific colleges")
    void testFindSpecificColleges() {
        // Test finding colleges that exist in your JSON
        College duke = collegeGenerator.getCollegeByRegion("Duke");
        assertThat(duke).isNotNull();
        assertThat(duke.getName()).isEqualTo("Blue Devils");
        
        College wisconsin = collegeGenerator.getCollegeByRegion("Wisconsin");
        assertThat(wisconsin).isNotNull();
        assertThat(wisconsin.getName()).isEqualTo("Badgers");
    }
}
