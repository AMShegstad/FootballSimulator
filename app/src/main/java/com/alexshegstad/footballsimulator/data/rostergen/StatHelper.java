package com.alexshegstad.footballsimulator.data.rostergen;

import java.util.*;
import com.alexshegstad.footballsimulator.model.enumerations.*;
import com.alexshegstad.footballsimulator.model.teamcomponents.Position;

public class StatHelper {
    private static final Random rand = new Random();

    public static int generateStat() {
        return generateStat(10, 65);
    }

    public static int generateStat(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    public static int getDefaultHeight(Position position) {
        switch (position) {
            case QB: case WR: case CB: return rand.nextInt(4) + 70;
            case LT: case C: case RT: case LE: case DT: case RE: return rand.nextInt(5) + 74;
            default: return rand.nextInt(6) + 71;
        }
    }

    public static int getDefaultWeight(Position position) {
        switch (position) {
            case QB: return rand.nextInt(20) + 210;
            case WR: return rand.nextInt(20) + 180;
            case LT: case C: case RT: return rand.nextInt(40) + 290;
            case DT: return rand.nextInt(40) + 280;
            default: return rand.nextInt(30) + 240;
        }
    }
}