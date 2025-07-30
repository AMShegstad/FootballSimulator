package com.alexshegstad.footballsimulator.logic;

import com.alexshegstad.footballsimulator.model.Matchup;
import com.alexshegstad.footballsimulator.model.Team;
import java.util.*;
import java.util.Scanner;

public class CoinFlip {
    
    private Team team1;
    private Team team2;

    public Boolean getGuess() {

        Scanner input = new Scanner(System.in);
        Boolean choiceAsBool = true;
        // Implement code for taking a true or false from the user.
        System.out.println("Head or Tails?");
        String choice = input.nextLine();

        String formattedChoice = choice.replaceAll("\\s", "").toLowerCase();
        if (formattedChoice == "heads") {
            choiceAsBool = true;
        } else if (formattedChoice == "tails") {
            choiceAsBool = false;
        } else {
            System.out.println("Error: Input Not Recognized, Reverting to RNG: ");
            int rand = (int)(Math.random() * 101);
            if (rand % 2 == 0) {
                choiceAsBool = true;
            } else {
                choiceAsBool = false;
            }
        }

        return choiceAsBool;
    }
    
    public Boolean headsOrTails() {

        Boolean flipResult = true;

        int flip = (int)(Math.random() * 101);
        if (flip % 2 == 0) {
            flipResult = true;
        } else {
            flipResult = false;
        }

        return flipResult;
    }

    // Create a method that
}
