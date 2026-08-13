# Football Simulator — Development Roadmap

---

## Phase 1: Complete the Data Layer

_Goal: Every generator works and can produce valid objects._

- [ X - Not using for now] Uncomment and finish `LocationGenerator` (wraps the existing `Location` builder)
- [ X - Not using for now] Uncomment and finish `OwnerGenerator` (wraps the existing `Owner` builder)
- [ X - Not using for now] Uncomment and finish `ColorSchemeGenerator` (randomly picks from the `ColorSchemes` enum)
- [ X - Not using for now] Uncomment and finish `TeamGenerator` — the orchestrator that calls all other generators and returns a fully-built `Team`
- [ ] Write unit tests for each generator

---

## Phase 2: Complete the Team Model

_Goal: A `Team` can be fully constructed and inspected._

- [ ] Fill in `PersonnelPackage` — groups of players for a given formation (e.g., base 4-3, nickel, dime)
- [ ] Add roster query methods to `Team` — getters for starters by unit (offense, defense, special teams), depth chart, etc.
- [ ] Add a `toString()` / display method to `Team` so you can print a team summary to the console
- [ ] Verify `CoachTest` and `TeamTest` are green; expand their coverage
- [ ] Implement a `DataExporter` utility that writes a generated team's full data to a human-readable file on disk (plain text or HTML — no technical jargon, no raw JSON; formatted so a non-programmer can read it); include team identity (name, location, colors, stadium), owner and coach profiles, and a full roster table with each player's name, position, age, and key ratings

---

## Phase 3: Build the Game Models

_Goal: The pieces of a game are represented as data._

- [ ] Implement `OffensiveFormation` — position coordinates on the `Gridiron` grid for each formation
- [ ] Implement `DefensiveFormation` — same for defensive alignments
- [ ] Implement `Playbook` — a collection of formations and their associated plays, assign one to each `Team`
- [ ] Implement `Play` — represents a single called play (formation, type: run/pass, target/direction)
- [ ] Implement `Matchup` — holds two `Team` objects, score, current down/distance/field position, weather, and game state

---

## Phase 4: Build the Simulation Engine

_Goal: A single play can be simulated with a result._

- [ ] Implement `StatChange` — calculates net stat values after applying `WeatherEffects` and any other modifiers
- [ ] Implement play resolution logic — given a `Play` and two `Team` rosters, compute yards gained, turnovers, scores (start with run plays, then passing)
- [ ] Implement `Kickoff` — simulates a kickoff and returns starting field position
- [ ] Implement drive logic — loop over plays from snap to end of possession (score, turnover, or punt/kick)
- [ ] Implement game loop — four quarters, clock management, halftime, overtime
- [ ] Write unit tests for play outcomes and edge cases (goal line, two-minute drill, etc.)

---

## Phase 5: Build the Bracket / Season System

_Goal: Multiple teams can compete in a structured tournament._

- [ ] Uncomment and implement `BracketGenerator` — seed 16 teams, create 1v8 style matchups per the existing design notes
- [ ] Add round advancement logic — winners progress, bracket updates after each round
- [ ] Add a season stats tracker — record W/L, score history, and player stat accumulation across games
- [ ] Implement a simple league schedule generator (optional, for a full season mode)

---

## Phase 6: Entry Point & JavaFX User Interface

_Goal: A user can run a game through a JavaFX desktop application._

- [ ] Add the `org.openjfx` JavaFX dependencies (`javafx-controls`, `javafx-fxml`) to `build.gradle.kts` and verify the app launches
- [ ] Create the application shell — `App` extends `javafx.application.Application`, launches a primary `Stage`
- [ ] Build a main menu screen — New Game, Load Game, Settings, Quit
- [ ] Build a team selection screen — display generated team info (name, location, roster summary) and allow the user to confirm or re-roll
- [ ] Build the in-game play-calling screen — show current down, distance, field position, and a list of available plays; wire up to the simulation engine
- [ ] Build a results/scoreboard screen — show final score, key stats, and options to export the game report or return to the main menu
- [ ] Add a "sim to end" option that auto-resolves a full game without user input
- [ ] Add save/load functionality (serialize game state to JSON using Jackson)

---

## Phase 7: Visual Gridiron

_Goal: The field and players are rendered visually during a game._

- [ ] Implement a JavaFX `GridironView` canvas component — draw the field, yard lines, hash marks, and end zones to scale
- [ ] Map each player's position on the `Gridiron` grid to pixel coordinates on the `GridironView`
- [ ] Render offensive and defensive formations at the snap — place player icons/tokens on the field in the correct positions
- [ ] Animate player movement during play resolution — move tokens from their snap position to their end position over the course of a play
- [ ] Display player name/number labels on or beside each token; highlight the ball carrier, the tackler, and key contact events
- [ ] Integrate `GridironView` into the in-game screen from Phase 6

---

## Phase 9: Game Simulation Export

_Goal: Every game can be exported to a human-readable file for post-game review._

- [ ] Design a `GameReport` data structure that accumulates a full record of a game as it is simulated — every play called by both the user and the CPU, every player-vs-player contact event and its outcome, scoring drives, and the final result
- [ ] Implement `GameReportExporter` — writes a completed `GameReport` to disk in plain text or HTML; sections should include: final score and game summary, a chronological play-by-play log (down, distance, field position, play called, yards gained/lost, turnovers, scores), and a player matchup log listing every individual contact event (attacker, defender, relevant ratings, and result)
- [ ] Hook `GameReportExporter` into the game loop so a report is offered at the end of every simulated game
- [ ] Ensure the output is readable without any knowledge of the codebase — use natural language labels, not field names or enum constants

---

## Phase 10: Test Coverage

_Goal: 100% test coverage across all non-stub classes._

- [ ] Configure JaCoCo in `build.gradle.kts` to measure and enforce coverage
- [ ] Reach 100% coverage on all `model/` classes (Team, Player, Coach, Owner, Location, Stadium, College)
- [ ] Reach 100% coverage on all `data/` generators (NameGenerator, RosterGenerator, CollegeGenerator, WeatherEffects, and the newly completed generators from Phase 1)
- [ ] Reach 100% coverage on all `logic/` classes (CoinFlip, Kickoff, StatChange, and the simulation engine from Phase 4)
- [ ] Reach 100% coverage on all `model/enumerations/` (enum methods, multipliers, display names, etc.)
- [ ] Reach 100% coverage on all `model/game/` classes (Gridiron, Matchup, Play, Playbook, formations)
- [ ] Add a Gradle task that fails the build if coverage drops below 100%
- [ ] Add edge case and boundary tests (e.g., empty rosters, null builders, extreme weather modifiers)

---

## Phase 11: Multiplayer (Stretch Goal)

_Goal: Two players can play head-to-head over a network._

- [ ] Design the client/server protocol (turn-based message passing)
- [ ] Implement `MultiplayerServer` — hosts a game session, syncs state
- [ ] Implement `MultiplayerClient` — connects to a session, sends play calls, receives results

---

## Phase 12: Isometric View with LibGDX (Stretch Goal)

_Goal: Replace the top-down JavaFX renderer with a Diablo/RTS-style isometric view using LibGDX._

**Prerequisite:** Nothing in `model/`, `data/`, or `logic/` imports any JavaFX or LibGDX class — the simulation engine must be renderer-agnostic before this phase begins.

- [ ] Evaluate whether the project warrants the upgrade; only proceed if the top-down JavaFX view feels limiting
- [ ] Add LibGDX dependencies to `build.gradle.kts`; verify the app still launches
- [ ] Implement the isometric coordinate transform — convert game-world `(col, row)` to screen `(x, y)` using `screenX = (col - row) * tileWidthHalf` and `screenY = (col + row) * tileHeightHalf`
- [ ] Replace `GridironView` with a LibGDX `IsometricGridironView` — draw field tiles as diamonds, maintain back-to-front draw order (painter's algorithm) so near objects paint over far ones
- [ ] Port player token rendering — map each player's `(fieldX, fieldY)` through the iso transform; add a vertical pixel offset for the ball's `z` height during pass arcs
- [ ] Replace JavaFX menu/UI screens with LibGDX `Scene2D` equivalents
- [ ] Remove JavaFX dependencies once LibGDX rendering is fully verified

---

## Suggested Order of Attack

If returning to the project fresh, the immediate priority is fixing the 7 failing tests in
`NameGeneratorTest` — the first and last name JSON files share overlapping entries that
the tests expect to be disjoint. Remove the duplicates from `firstNames.json` and
`lastNames.json` until all tests are green.

From there, the highest-leverage next step is **Phase 1**: write unit tests for the three
active generators (`NameGenerator`, `CollegeGenerator`, `RosterGenerator`). The four
commented-out generators (`LocationGenerator`, `OwnerGenerator`, `ColorSchemeGenerator`,
`TeamGenerator`) are no longer needed — their responsibilities were absorbed by the Builder
patterns inside the model classes — and can be deleted.

Then move to **Phase 2** (roster query methods and the `DataExporter`). That gets you to a
point where you can generate a team and read a human-readable summary of it — a satisfying
milestone that validates the whole data layer before game logic begins.

Test coverage (Phase 10) is listed as its own phase but should be treated as an ongoing
habit throughout all phases — write tests alongside each new class rather than saving
them all for the end. Phase 10 then becomes a final audit and enforcement step.
