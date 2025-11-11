package com.alexshegstad.footballsimulator.model.teamcomponents;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.alexshegstad.footballsimulator.model.enumerations.*;

public class CoachTest {

    @Test
    void testRandomAge() {
        Coach c = new Coach.Builder().build();
        int age = c.getAge();
        assertTrue(age >= 30 && age <= 70, "Age should be within realistic age");
    }

    @Test
    void testVariableGeneration() {
         Coach c = new Coach.Builder().build();
         Integer age = c.getAge();
         String firstName = c.getFirstName();
         String lastName = c.getLastName();
         Location hometown = c.getHometown();
         Defense defense = c.getDefense();
         Offense offense = c.getOffense();
         LeadershipStyle leadershipStyle = c.getLeadershipStyle();
         String coachString = c.toString();
         System.out.println(c.toString());
         
         assertTrue(age != null);
         assertTrue(firstName != null);
         assertTrue(lastName != null);
         assertTrue(hometown != null);
         assertTrue(defense != null);
         assertTrue(offense != null);
         assertTrue(leadershipStyle != null);
         assertTrue(coachString != null);
    }

    // @Test
    // void failingTest() {
    //     fail("This test should fail to prove the runner is working.");
    // }
}
