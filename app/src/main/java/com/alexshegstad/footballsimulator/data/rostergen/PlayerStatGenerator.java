package com.alexshegstad.footballsimulator.data.rostergen;

import com.alexshegstad.footballsimulator.model.teamcomponents.*;

public interface PlayerStatGenerator {
    void applyStats(Player.Builder builder);
}
