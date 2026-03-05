# Football Simulator — Development Roadmap

---

## Phase 1: Complete the Data Layer
*Goal: Every generator works and can produce valid objects.*

- [ X - Not using for now] Uncomment and finish `LocationGenerator` (wraps the existing `Location` builder)
- [ X - Not using for now] Uncomment and finish `OwnerGenerator` (wraps the existing `Owner` builder)
- [ X - Not using for now] Uncomment and finish `ColorSchemeGenerator` (randomly picks from the `ColorSchemes` enum)
- [ X - Not using for now] Uncomment and finish `TeamGenerator` — the orchestrator that calls all other generators and returns a fully-built `Team`
- [ ] Write unit tests for each generator

---

## Phase 2: Complete the Team Model
*Goal: A `Team` can be fully constructed and inspected.*

- [ ] Fill in `PersonnelPackage` — groups of players for a given formation (e.g., base 4-3, nickel, dime)
- [ ] Add roster query methods to `Team` — getters for starters by unit (offense, defense, special teams), depth chart, etc.
- [ ] Add a `toString()` / display method to `Team` so you can print a team summary to the console
- [ ] Verify `CoachTest` and `TeamTest` are green; expand their coverage

---

## Phase 3: Build the Game Models
*Goal: The pieces of a game are represented as data.*

- [ ] Implement `OffensiveFormation` — position coordinates on the `Gridiron` grid for each formation
- [ ] Implement `DefensiveFormation` — same for defensive alignments
- [ ] Implement `Playbook` — a collection of formations and their associated plays, assign one to each `Team`
- [ ] Implement `Play` — represents a single called play (formation, type: run/pass, target/direction)
- [ ] Implement `Matchup` — holds two `Team` objects, score, current down/distance/field position, weather, and game state

---

## Phase 4: Build the Simulation Engine
*Goal: A single play can be simulated with a result.*

- [ ] Implement `StatChange` — calculates net stat values after applying `WeatherEffects` and any other modifiers
- [ ] Implement play resolution logic — given a `Play` and two `Team` rosters, compute yards gained, turnovers, scores (start with run plays, then passing)
- [ ] Implement `Kickoff` — simulates a kickoff and returns starting field position
- [ ] Implement drive logic — loop over plays from snap to end of possession (score, turnover, or punt/kick)
- [ ] Implement game loop — four quarters, clock management, halftime, overtime
- [ ] Write unit tests for play outcomes and edge cases (goal line, two-minute drill, etc.)

---

## Phase 5: Build the Bracket / Season System
*Goal: Multiple teams can compete in a structured tournament.*

- [ ] Uncomment and implement `BracketGenerator` — seed 16 teams, create 1v8 style matchups per the existing design notes
- [ ] Add round advancement logic — winners progress, bracket updates after each round
- [ ] Add a season stats tracker — record W/L, score history, and player stat accumulation across games
- [ ] Implement a simple league schedule generator (optional, for a full season mode)

---

## Phase 6: Entry Point & User Interface
*Goal: A user can actually run a game.*

- [ ] Update `App.main()` to present a menu (new game, load game, settings)
- [ ] Add a text-based game flow — team selection, coin flip (`CoinFlip` is ready), play calling, results display
- [ ] Add a "sim to end" option that auto-resolves a full game without user input
- [ ] Add save/load functionality (serialize game state to JSON using Jackson)

---

## Phase 7: Test Coverage
*Goal: 100% test coverage across all non-stub classes.*

- [ ] Configure JaCoCo in `build.gradle.kts` to measure and enforce coverage
- [ ] Reach 100% coverage on all `model/` classes (Team, Player, Coach, Owner, Location, Stadium, College)
- [ ] Reach 100% coverage on all `data/` generators (NameGenerator, RosterGenerator, CollegeGenerator, WeatherEffects, and the newly completed generators from Phase 1)
- [ ] Reach 100% coverage on all `logic/` classes (CoinFlip, Kickoff, StatChange, and the simulation engine from Phase 4)
- [ ] Reach 100% coverage on all `model/enumerations/` (enum methods, multipliers, display names, etc.)
- [ ] Reach 100% coverage on all `model/game/` classes (Gridiron, Matchup, Play, Playbook, formations)
- [ ] Add a Gradle task that fails the build if coverage drops below 100%
- [ ] Add edge case and boundary tests (e.g., empty rosters, null builders, extreme weather modifiers)

---

## Phase 8: Multiplayer (Stretch Goal)
*Goal: Two players can play head-to-head over a network.*

- [ ] Design the client/server protocol (turn-based message passing)
- [ ] Implement `MultiplayerServer` — hosts a game session, syncs state
- [ ] Implement `MultiplayerClient` — connects to a session, sends play calls, receives results

---

## Suggested Order of Attack

If returning to the project fresh, the highest-leverage starting point is **Phase 1**
(uncomment and test the generators), followed immediately by **Phase 2** (roster queries
and team display). That gets you to a point where you can print a fully-generated team
to the console — a satisfying milestone that validates the whole data layer before game
logic begins.

Test coverage (Phase 7) is listed as its own phase but should be treated as an ongoing
habit throughout all phases — write tests alongside each new class rather than saving
them all for the end. Phase 7 then becomes a final audit and enforcement step.
