package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.data.*;
import com.alexshegstad.footballsimulator.model.enumerations.Handedness;
import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Player {
    // All your existing fields...
    private Position position;
    private int number;
    private String firstName;
    private String lastName;
    private Location hometown;
    private College college;
    private int experience;
    private int age;
    private int height;
    private int weight;
    private int awareness;
    private int strength;
    private int speed;
    private int acceleration;
    private int injuryResistance;
    private int passBlock;
    private int runBlock;
    private int impactBlock;
    private int carrying;
    private int catching;
    private int routeRunning;
    private int ballCarrierVision;
    private int trucking;
    private int elusiveness;
    private int catchInTraffic;
    private int spectacularCatch;
    private int release;
    private int stiffArm;
    private int juke;
    private int jumping;
    private int throwPower;
    private int shortAccuracy;
    private int mediumAccuracy;
    private int deepAccuracy;
    private int playAction;
    private int throwOnTheRun;
    private int tackle;
    private int playRecognition;
    private int blockShedding;
    private int powerMoves;
    private int finesseMoves;
    private int zoneCoverage;
    private int manCoverage;
    private int pursuit;
    private int hitPower;
    private int press;
    private int kickAccuracy;
    private int kickPower;
    private LeadershipStyle preferredLeadershipStyle;
    private Handedness handedness;

    // Stats tracking
    private int starts = 0;
    private int wins = 0;
    private int losses = 0;
    private int draws = 0;
    private int gamesPlayed = 0;
    private int seasonsPlayed = 0;
    private int downsPlayed = 0;
    private int matchupWins = 0;

    // Private constructor for Builder pattern
    private Player(Builder builder) {
        this.firstName = builder.firstName != null ? builder.firstName : randomFirstName();
        this.lastName = builder.lastName != null ? builder.lastName : randomLastName();
        this.position = builder.position;
        this.hometown = builder.hometown != null ? builder.hometown : randomLocation();
        this.college = builder.college != null ? builder.college : getRandomCollege();
        this.number = builder.number;
        this.experience = builder.experience > 18 ? builder.experience : builder.age - 21;
        this.age = builder.age > 17 ? builder.age : randomAge();
        // Height must be represented as an int between 60 - 84 (inches)
        this.height = builder.height;
        // Weight must be represented as an int between 160 and 360 (lbs)
        this.weight = builder.weight;
        this.awareness = builder.awareness;
        this.strength = builder.strength;
        this.speed = builder.speed;
        this.acceleration = builder.acceleration;
        this.injuryResistance = builder.injuryResistance;
        this.passBlock = builder.passBlock;
        this.runBlock = builder.runBlock;
        this.impactBlock = builder.impactBlock;
        this.carrying = builder.carrying;
        this.catching = builder.catching;
        this.routeRunning = builder.routeRunning;
        this.ballCarrierVision = builder.ballCarrierVision;
        this.trucking = builder.trucking;
        this.elusiveness = builder.elusiveness;
        this.catchInTraffic = builder.catchInTraffic;
        this.spectacularCatch = builder.spectacularCatch;
        this.release = builder.release;
        this.stiffArm = builder.stiffArm;
        this.juke = builder.juke;
        this.jumping = builder.jumping;
        this.throwPower = builder.throwPower;
        this.shortAccuracy = builder.shortAccuracy;
        this.mediumAccuracy = builder.mediumAccuracy;
        this.deepAccuracy = builder.deepAccuracy;
        this.playAction = builder.playAction;
        this.throwOnTheRun = builder.throwOnTheRun;
        this.tackle = builder.tackle;
        this.playRecognition = builder.playRecognition;
        this.blockShedding = builder.blockShedding;
        this.powerMoves = builder.powerMoves;
        this.finesseMoves = builder.finesseMoves;
        this.zoneCoverage = builder.zoneCoverage;
        this.manCoverage = builder.manCoverage;
        this.pursuit = builder.pursuit;
        this.hitPower = builder.hitPower;
        this.press = builder.press;
        this.kickAccuracy = builder.kickAccuracy;
        this.kickPower = builder.kickPower;
        this.preferredLeadershipStyle = builder.preferredLeadershipStyle != null ? builder.preferredLeadershipStyle
                : randomLeadershipStyle();
        this.handedness = builder.handedness != null ? builder.handedness : generateRandomHandedness();
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        firstName = newFirstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String newLastName) {
        lastName = newLastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPosition) {
        if (position == newPosition) {
            System.out.print(getFullName() + " is already assigned to " + newPosition + " role.");
        } else {
            position = newPosition;
        }
    }

    public int getNumber() {
        return number;
    }

    public Location getHometown() {
        return hometown;
    }

    public College getCollege() {
        return college;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int newWeight) {
        if (newWeight > 60 && newWeight < 84) {
            height = newWeight;
        } else {
            System.out.print("Invalid Height");
        }
    }

    public int getAwareness() {
        return awareness;
    }

    public void incrementAwareness(int change) {
        if (awareness < (99 - change)){
            awareness = awareness + change;
        } else {
            awareness = 99;
        }
    }

    public void decrementAwareness(int change) {
        if (awareness > change) {
            awareness = awareness - change;
        } else {
            awareness = 0;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void incrementStrength(int change) {
        if (strength < (99 - change)) {
            strength = strength + change;
        } else {
            strength = 99;
        }
    }

    public void decrementStrength(int change) {
        if (strength > change) {
            strength = strength - change;
        } else {
            strength = 0;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void incrementSpeed(int change) {
        if (speed < (99 - change)) {
            speed = speed + change;
        } else {
            speed = 99;
        }
    }

    public void decrementSpeed(int change) {
        if (speed > change) {
            speed = speed - change;
        } else {
            speed = 0;
        }
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void incrementAcceleration(int change) {
        if (acceleration < (99 - change)) {
            acceleration = acceleration + change;
        } else {
            acceleration = 99;
        }
    }

    public void decrementAcceleration(int change) {
        if (acceleration > change) {
            acceleration = acceleration - change;
        } else {
            acceleration = 0;
        }
    }

    public int getInjuryResistance() {
        return injuryResistance;
    }

    public void incrementInjuryResistance(int change) {
        if (injuryResistance < (99 - change)) {
            injuryResistance = injuryResistance + change;
        } else {
            injuryResistance = 99;
        }
    }

    public void decrementInjuryResistance(int change) {
        if (injuryResistance > change) {
            injuryResistance = injuryResistance - change;
        } else {
            injuryResistance = 0;
        }
    }

    public int getPassBlock() {
        return passBlock;
    }

    public void incrementPassBlock(int change) {
        if (passBlock < (99 - change)) {
            passBlock = passBlock + change;
        } else {
            passBlock = 99;
        }
    }

    public void decrementPassBlock(int change) {
        if (passBlock > change) {
            passBlock = passBlock - change;
        } else {
            passBlock = 0;
        }
    }

    public int getRunBlock() {
        return runBlock;
    }

    public void incrementRunBlock(int change) {
        if (runBlock < (99 - change)){
            runBlock = runBlock + change;
        } else {
            runBlock = 99;
        }
     }

    public void decrementRunBlock(int change) {
        if (runBlock > change) {
            runBlock = runBlock - change;
        } else {
            runBlock = 0;
        }
    }

    public int getImpactBlock() {
        return impactBlock;
    }

    public void incrementImpactBlock(int change) {
        if (impactBlock < (99 - change)) {
            impactBlock = impactBlock + change;
        } else {
            impactBlock = 99;
        }
    }

    public void decrementImpactBlock(int change) {
        if (impactBlock > change) {
            impactBlock = impactBlock - change;
        } else {
            impactBlock = 0;
        }
    }

    public int getCarrying() {
        return carrying;
    }

    public void incrementCarrying(int change) {
        if (carrying < (99 - change)) {
            carrying = carrying + change;
        } else {
            carrying = 99;
        }
    }

    public void decrementCarrying(int change) {
        if (carrying > change) {
            carrying = carrying - change;
        } else {
            carrying = 0;
        }
    }

    public int getBallCarrierVision() {
        return ballCarrierVision;
    }

    public void incrementBallCarrierVision(int change) {
        if (ballCarrierVision < (99 - change)) {
            ballCarrierVision = ballCarrierVision + change;
        } else {
            ballCarrierVision = 99;
        }
    }

    public void decrementBallCarrierVision(int change) {
        if (ballCarrierVision > change) {
            ballCarrierVision = ballCarrierVision - change;
        } else {
            ballCarrierVision = 0;
        }
    }

    public int getCatching() {
        return catching;
    }

    public void incrementCatching(int change) {
        if (catching < (99 - change)) {
            catching = catching + change;
        } else {
            catching = 99;
        }
    }

    public void decrementCatching(int change) {
        if (catching > change) {
            catching = catching - change;
        } else {
            catching = 0;
        }
    }

    public int getRouteRunning() {
        return routeRunning;
    }

    public void incrementRouteRunning(int change) {
        if (routeRunning < (99 - change)) {
            routeRunning = routeRunning + change;
        } else {
            routeRunning = 99;
        }
    }

    public void decrementRouteRunning(int change) {
        if (routeRunning > change) {
            routeRunning = routeRunning - change;
        } else {
            routeRunning = 0;
        }
    }

    public int getTrucking() {
        return trucking;
    }

    public void incrementTrucking(int change) {
        if (trucking < (99 - change)) { 
            trucking = trucking + change;
        } else {
            trucking = 99;
        }
    }

    public void decrementTrucking(int change) {
        if (trucking > change) {
            trucking = trucking - change;
        } else {
            trucking = 0;
        }
    }

    public int getElusiveness() {
        return elusiveness;
    }

    public void incrementElusiveness(int change) {
        if (elusiveness < (99 - change)) {
            elusiveness = elusiveness + change;
        } else {
            elusiveness = 99;
        }
    }

    public void decrementElusiveness(int change) {
        if (elusiveness > change) {
            elusiveness = elusiveness - change;
        } else {
            elusiveness = 0;
        }
    }

    public int getCatchInTraffic() {
        return catchInTraffic;
    }

    public void incrementCatchInTraffic(int change) {
        if (catchInTraffic < (99 - change)) {
            catchInTraffic = catchInTraffic - change;
        } else {
            catchInTraffic = 99;
        }
    }

    public void decrementCatchInTraffic(int change) {
        if (catchInTraffic > change) {
            catchInTraffic = catchInTraffic - change;
        } else {
            catchInTraffic = 0;
        }
    }

    public int getSpectacularCatch() {
        return spectacularCatch;
    }

    public void incrementSpectacularCatch(int change) {
        if (spectacularCatch < (99 - change)) {
            spectacularCatch = spectacularCatch + 0;
        } else {
            spectacularCatch = 99;
        }
    }

    public void decrementSpectacularCatch(int change) {
        if (spectacularCatch > change) {
            spectacularCatch = spectacularCatch - change;
        } else {
            spectacularCatch = 0;
        }
    }

    public int getRelease() {
        return release;
    }

    public void incrementRelease(int change) {
        if (release < (99 - change)) {
            release = release + change;
        } else {
            release = 99;
        }
    }

    public void decrementRelease(int change) {
        if (release > change) {
            release = release - change;
        } else {
             release = 0;
        }
    }

    public int getStiffArm() {
        return stiffArm;
    }

    public void incrementStiffArm(int change) {
        if (stiffArm < (99 - change)) {
            stiffArm = stiffArm + change;
        } else {
            stiffArm = 99;
        }
    }

    public void decrementStiffArm(int change) {
        if (stiffArm > change) {
            stiffArm = stiffArm - change;
        }
    }

    public int getJuke() {
        return juke;
    }

    public void incrementJuke(int change) {
        if (juke < (99 - change)) {
            juke = juke + change;
        } else {
            juke = 99;
        }
    }

    public void decrementJuke(int change) {
        if (juke > change) {
            juke = juke - change;
        } else {
            juke = 0;
        }
    }

    public int getJumping() {
        return jumping;
    }

    public void incrementJumping(int change) {
        if (jumping < (99 - change)) {
            jumping = jumping + change;
        } else {
            jumping = 99;
        }
    }

    public void decrementJumping(int change) {
        if (jumping > change) {
            jumping = jumping - change;
        } else {
            jumping = 0;
        }
    }

    public int getThrowPower() {
        return throwPower;
    }

    public void incrementThrowPower(int change){
        if (throwPower < (99 - change)) {
            throwPower = throwPower + change;
        } else {
            throwPower = 99;
        }
    }

    public void decrementThrowPower(int change) {
        if (throwPower > change) {
            throwPower = throwPower - change;
        } else {
            throwPower = 0;
        }
    }

    public int getShortAccuracy() {
        return shortAccuracy;
    }

    public void incrementShortAccuracy(int change) {
        if (shortAccuracy < (99 - change)) {
            shortAccuracy = shortAccuracy + change;
        } else {
            shortAccuracy = 99;
        }
    }

    public void decrementShortAccuracy(int change) {
        if (shortAccuracy > change) {
            shortAccuracy = shortAccuracy - change;
        } else {
            shortAccuracy = 0;
        }
    }

    public int getMediumAccuracy() {
        return mediumAccuracy;
    }

    public void incrementMediumAccuracy(int change) {
        if (mediumAccuracy < (99 - change)) {
            mediumAccuracy = mediumAccuracy + change;
        } else {
            mediumAccuracy = 99;
        }
    }

    public void decrementMediumAccuracy(int change) {
        if (mediumAccuracy > change) {
            mediumAccuracy = mediumAccuracy - change;
        } else {
            mediumAccuracy = 0;
        }
    }

    public int getDeepAccuracy() {
        return deepAccuracy;
    }

    public void incrementDeepAccuracy(int change) {
        if (deepAccuracy < (99 - change)) {
            deepAccuracy = deepAccuracy + change;
        } else {
            deepAccuracy = 99;
        }
    }

    public void decrementDeepAccuracy(int change) {
        if (deepAccuracy > change) {
            deepAccuracy = deepAccuracy - change;
        } else {
            deepAccuracy = 0;
        }
    }

    public int getPlayAction() {
        return playAction;
    }

    public void incrementPlayAction(int change) {
        if (playAction < (99 - change)) {
            playAction = playAction - change;
        } else {
            playAction = 99;
        }
    }

    public void decrementPlayAction(int change) {
        if (playAction > change) {
            playAction = playAction - change;
        } else {
            playAction = 0;
        }
    }

    public int getThrowOnTheRun() {
        return throwOnTheRun;
    }

    public void incrementThrowOnTheRun(int change) {
        if (throwOnTheRun < (99 - change)){
            throwOnTheRun = throwOnTheRun + change;
        } else {
            throwOnTheRun = 99;
        }
    }

    public void decrementThrowOnTheRun(int change) {
        if (throwOnTheRun > change) {
            throwOnTheRun = throwOnTheRun - change;
        } else {
            throwOnTheRun = 0;
        }
    }

    public int getTackle() {
        return tackle;
    }

    public void incrementTackle(int change) {
        if (tackle < (99 - change)) {
            tackle = tackle + change;
        } else {
            tackle = 99;
        }
    }

    public void decrementTackle(int change) { 
        if (tackle > change) {
            tackle = tackle - tackle;
        } else {
            tackle = 0;
        }
    }

    public int getPlayRecognition() {
        return playRecognition;
    }

    public void incrementPlayRecognition(int change) {
        if (playRecognition < (99 - change)) {
            playRecognition = playRecognition + change;
        } else {
            playRecognition = 99;
        }
    }

    public void decrementPlayRecognition(int change) {
        if (playRecognition > change) {
            playRecognition = playRecognition - change;
        } else {
            playRecognition = 0;
        }
    }

    public int getBlockShedding() {
        return blockShedding;
    }

    public void incrementBlockShedding(int change) {
        if (blockShedding < (99 - change)) {
            blockShedding = blockShedding + change;
        } else {
            blockShedding = 99;
        }
    }

    public void decrementBlockShedding(int change) {
        if (blockShedding > change) {
            blockShedding = blockShedding - change;
        } else {
            blockShedding = 0;
        }
    }

    public int getPowerMoves() {
        return powerMoves;
    }

    public void incrementPowerMoves(int change) {
        if (powerMoves < (99 - change)){
            powerMoves = powerMoves + change;
        } else {

        }
    }

    public int getFinesseMoves() {
        return finesseMoves;
    }

    public int getZoneCoverage() {
        return zoneCoverage;
    }

    public int getManCoverage() {
        return manCoverage;
    }

    public int getPursuit() {
        return pursuit;
    }

    public int getHitPower() {
        return hitPower;
    }

    public int getPress() {
        return press;
    }

    public int getKickAccuracy() {
        return kickAccuracy;
    }

    public int getKickPower() {
        return kickPower;
    }

    public LeadershipStyle getPreferredLeadershipStyle() {
        return preferredLeadershipStyle;
    }

    public String getHandedness() {
        return handedness.name();
    }

    // Getters and incrementers for tracked stats
    public int getStarts() {
        return starts;
    }

    public void incrementStarts(int change) {
        starts = starts + change;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins(int change) {
        wins = wins + change;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementLosses(int change) {
        losses = losses + change;
    }

    public int getDraws() {
        return draws;
    }

    public void incrementDraws(int change) {
        draws = draws + change;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void incrementGamesPlayed(int change) {
        gamesPlayed = gamesPlayed + change;
    }

    public int getSeasonsPlayed() {
        return seasonsPlayed;
    }

    public void incrementSeasonsPlayed(int change) {
        seasonsPlayed = seasonsPlayed + change;
    }

    public int getMatchupWins() {
        return matchupWins;
    }

    public void incrementMatchupWins(int change) {
        matchupWins = matchupWins + change;
    }

    public int getDownsPlayed() {
        return downsPlayed;
    }

    private static int randomAge() {
        return (int) (30 + Math.random() * 35);
    }

    private static String randomFirstName() {
        NameGenerator names = new NameGenerator();
        String firstName = names.getRandomFirstName();
        return firstName;
    }

    private static String randomLastName() {
        NameGenerator names = new NameGenerator();
        String lastName = names.getRandomLastName();
        return lastName;
    }

    private static LeadershipStyle randomLeadershipStyle() {
        LeadershipStyle[] leadershipStyles = LeadershipStyle.values();
        int randomIndex = ThreadLocalRandom.current().nextInt(leadershipStyles.length);
        return leadershipStyles[randomIndex];
    }

    private static Location randomLocation() {
        Location loc = new Location.Builder().build();
        return loc;
    }

    private static College getRandomCollege() {
        CollegeGenerator colGen = new CollegeGenerator();
        College col = colGen.getRandomCollegeObject();
        return col;
    }

    public static Handedness generateRandomHandedness() {
        Random rand = new Random();
        int roll = rand.nextInt(100); // 0-99

        if (roll < 85) {
            // 85% chance: right-handed players
            // Split evenly between RIGHT and RIGHT_MOST
            return roll < 43 ? Handedness.RIGHT : Handedness.RIGHT_MOST;
        } else {
            // 15% chance: non-right-handed players
            int leftRoll = rand.nextInt(100);
            if (leftRoll < 10) {
                // 10% of remaining = 1.5% overall
                return Handedness.AMBIDEXTROUS;
            } else if (leftRoll < 55) {
                return Handedness.LEFT;
            } else {
                return Handedness.LEFT_MOST;
            }
        }
    }

    // The following code is incorrect.

    // public void incrementStatistic(int stat, int change) {
    //     if (stat < (99 - change)) {
    //         stat = stat + change;
    //     } else {
    //         stat = 99;
    //     }
    // }

    // public void decrementStatistic(int stat, int change) {
    //     if (stat > change) {
    //         stat = stat - change;
    //     } else {
    //         stat = 0;
    //     }
    // }

    @Override
    public String toString() {
        return String.format("%s %s #%d - %s (Age: %d, Exp: %d)",
                firstName, lastName, number, position, age, experience);
    }

    // Builder Pattern
    public static class Builder {
        private static final Random rand = new Random();
        private static NameGenerator nameGen;
        private static CollegeGenerator collegeGen;

        // Required fields
        // No player can be created without first having a predetermined position. This
        // allows control of roster size and composition.
        private Position position;

        // Optional fields with defaults
        private String firstName;
        private String lastName;
        private Location hometown;
        private College college;
        private int number;
        private int experience;
        private int age;
        private int height;
        private int weight;
        private int awareness;
        private int strength;
        private int speed;
        private int acceleration;
        private int injuryResistance;
        private int passBlock, runBlock, impactBlock;
        private int carrying, catching, routeRunning;
        private int ballCarrierVision, trucking, elusiveness;
        private int catchInTraffic, spectacularCatch, release;
        private int stiffArm, juke, jumping;
        private int throwPower, shortAccuracy, mediumAccuracy, deepAccuracy;
        private int playAction, throwOnTheRun;
        private int tackle, playRecognition, blockShedding;
        private int powerMoves, finesseMoves;
        private int zoneCoverage, manCoverage, pursuit;
        private int hitPower, press;
        private int kickAccuracy, kickPower;
        private LeadershipStyle preferredLeadershipStyle;
        private Handedness handedness;

        static {
            nameGen = new NameGenerator();
            collegeGen = new CollegeGenerator();
        }

        public Builder(Position position) {
            this.position = position;

            // Set defaults based on position
            setPositionDefaults(position);
        }

        private void setPositionDefaults(Position position) {
            // Generate random name
            String fullName = nameGen.getRandomName();
            String[] parts = fullName.split(" ", 2);
            this.firstName = parts.length > 0 ? parts[0] : "John";
            this.lastName = parts.length > 1 ? parts[1] : "Doe";

            // Generate random hometown and college
            this.hometown = new Location.Builder().build();
            this.college = collegeGen.getRandomCollegeObject();

            // Common defaults
            this.injuryResistance = randBetween(50, 99);
            this.experience = randBetween(0, 20);
            this.age = experience + randBetween(20, 23);

            // Position-specific defaults
            switch (position) {
                case QB:
                    setQuarterbackDefaults();
                    break;
                case HB:
                    setRunningBackDefaults();
                    break;
                case WR:
                    setWideReceiverDefaults();
                    break;
                // ... add other positions
                default:
                    setGenericDefaults();
            }
        }

        private void setQuarterbackDefaults() {
            this.number = randBetween(1, 19);
            this.height = randBetween(68, 80);
            this.weight = randBetween(165, 250);
            this.awareness = randBetween(65, 99);
            this.speed = randBetween(40, 95);
            this.throwPower = randBetween(75, 99);
            this.shortAccuracy = randBetween(75, 99);
            this.mediumAccuracy = randBetween(75, 99);
            this.deepAccuracy = randBetween(65, 89);
            // this.acceleration = randBetween(50, 95);
            // this.passBlock = randBetween(10, 50);
            // this.runBlock = randBetween(15, 45);
            // this.impactBlock = randBetween(5, 35);
            // this.carrying = randBetween(35, 85);
            // this.catching = randBetween(25, 40);
            // this.routeRunning = randBetween(5, 15);
            // this.ballCarrierVision = randBetween(30, 75);
        }

        private void setRunningBackDefaults() {
            this.number = randBetween(20, 44);
            this.height = randBetween(66, 74);
            this.weight = randBetween(180, 235);
            this.speed = randBetween(82, 99);
            this.carrying = randBetween(80, 99);
            this.ballCarrierVision = randBetween(72, 99);
            this.elusiveness = randBetween(65, 99);
            // Set all other HB-specific stats...
        }

        private void setWideReceiverDefaults() {
            this.number = randBetween(10, 19); // Will need special handling for 80-89
            this.height = randBetween(72, 81);
            this.weight = randBetween(183, 234);
            this.speed = randBetween(82, 99);
            this.catching = randBetween(88, 99);
            this.routeRunning = randBetween(75, 99);
            this.spectacularCatch = randBetween(75, 99);
            // Set all other WR-specific stats...
        }

        private void setGenericDefaults() {
            this.number = randBetween(1, 99);
            this.height = randBetween(66, 80);
            this.weight = randBetween(150, 350);
            this.awareness = randBetween(50, 80);
            this.speed = randBetween(40, 80);
            // Set all stats to moderate values...
        }

        // Fluent setters for custom values
        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder position() {
            Random random = new Random();
            Position[] positions = Position.values();
            this.position = positions[random.nextInt(positions.length)];
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder height(int height) {
            this.height = height;
            return this;
        }

        public Builder weight(int weight) {
            this.weight = weight;
            return this;
        }

        public Builder speed(int speed) {
            this.speed = speed;
            return this;
        }

        public Builder awareness(int awareness) {
            this.awareness = awareness;
            return this;
        }

        public Builder throwPower(int throwPower) {
            this.throwPower = throwPower;
            return this;
        }

        public Builder catching(int catching) {
            this.catching = catching;
            return this;
        }

        public Builder preferredLeadershipStyle(LeadershipStyle preferredLeadershipStyle) {
            this.preferredLeadershipStyle = preferredLeadershipStyle;
            return this;
        }

        public Builder college(College college) {
            this.college = collegeGen.getRandomCollegeObject();
            return this;
        }

        public Builder handedness(Handedness handedness) {
            this.handedness = generateRandomHandedness();
            return this;
        }

        // Add more setters for other stats as needed...

        public Player build() {
            return new Player(this);
        }

        private static int randBetween(int min, int max) {
            return rand.nextInt(max - min + 1) + min;
        }

    }
}
