package com.alexshegstad.footballsimulator.data.rostergen;

import java.util.Map;
import com.alexshegstad.footballsimulator.model.teamcomponents.*;
import com.alexshegstad.footballsimulator.data.rostergen.positionstats.QBStatGenerator;
import com.alexshegstad.footballsimulator.data.rostergen.positionstats.WRStatGenerator;
import com.alexshegstad.footballsimulator.data.rostergen.positionstats.TEStatGenerator;

public class StatGeneratorFactory {
    
    private static final Map<Position, Class<? extends PlayerStatGenerator>> GENERATORS = Map.ofEntries(
        Map.entry(Position.QB, QBStatGenerator.class),
        Map.entry(Position.WR, WRStatGenerator.class),
        Map.entry(Position.TE, TEStatGenerator.class));
}
