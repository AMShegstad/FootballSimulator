# FootballSimulator

A comprehensive American football simulator featuring 12 teams with complete rosters, coaches, playbooks, and stadiums. The simulator runs play-by-play games with outcomes determined by player statistics and random number generation.

## Features

- **Team Generation**: 12 teams with names, locations, stadiums, coaches, and playbooks
- **Round-Robin Tournament**: Complete bracket system
- **Play-by-Play Simulation**: Detailed game simulation with statistical outcomes
- **Terminal Display**: Initial text-based interface (JavaFX GUI planned for future)
- **Player Statistics**: Comprehensive player stats affecting game outcomes
- **Random Elements**: RNG combined with stats for realistic gameplay

## Project Structure

```
src/
├── main/java/com/footballsim/
│   ├── Main.java                 # Entry point
│   ├── models/                   # Data models
│   ├── game/                     # Game logic and simulation
│   ├── data/                     # Data management and generation
│   ├── ui/                       # User interface (terminal/JavaFX)
│   └── utils/                    # Utility classes
├── test/java/                    # Unit tests
└── resources/                    # Configuration files and data
```

## Getting Started

1. Compile and run the project
2. Teams will be automatically generated
3. Tournament bracket will be created
4. Watch the play-by-play simulation unfold

## Future Development

- JavaFX graphical interface
- User play selection
- Advanced statistics tracking
- Season management
- Player development system
