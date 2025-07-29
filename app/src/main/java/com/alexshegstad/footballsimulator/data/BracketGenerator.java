package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.Matchup;
import com.alexshegstad.footballsimulator.model.Team;

public class BracketGenerator {

    public Matchup round1Game1;
    public Matchup round1Game2;
    public Matchup round1Game3;
    public Matchup round1Game4;
    public Matchup round1Game5;
    public Matchup round1Game6;
    public Matchup round1Game7;
    public Matchup round1Game8;
    public Matchup round2Game1;
    public Matchup round2Game2;
    public Matchup round2Game3;
    public Matchup round2Game4;
    public Matchup championship;

    // Accept array of all 12 teams.
    public BracketGenerator() {

    }

    public BracketGenerator(Team team1, Team team2, Team team3, Team team4, Team team5, Team team6, Team team7, Team team8) {
    
    }

    // Divide the array into two arrays, separated by the Team.division boolean;

    // Use a formula to sort the teams by their roster - FORMULA TDB

    // Create Matchups based on the example at the bottom of this file: 1v8, 2v7, 3v6, and 4,5.

    // Each subsequent round creates new matchups based on the winners from previous round.

    // After the final round, there should be a winner declared. The object will then have no further work to so.
}

/*

1.                                                                               1.
________________                                                                ________________

8.                                                                               8.
________________                                                                ________________

                    ________________                        ________________


2.                  ________________                        ________________    2.
________________                                                                ________________

7.                                                                              7.
________________                                                                ________________

                                        _________________




                                            __________



3.                                      _________________                        3.
________________                                                                ________________

6.                                                                               6.
________________                                                                ________________

                    ________________                        ________________


4.                  ________________                        ________________    4.
________________                                                                ________________

5.                                                                              5.
________________                                                                ________________
 
 */