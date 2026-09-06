package com.alexshegstad.footballsimulator.model.teamcomponents;

import com.alexshegstad.footballsimulator.data.*;
import com.alexshegstad.footballsimulator.model.enumerations.Handedness;
import com.alexshegstad.footballsimulator.model.enumerations.LeadershipStyle;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

    // Position is predetermined, to control roster makeup and size.
    private Position position;
    // number is taken from a list to ensure that no numbers are repeated on a team.
    private int number;
    // NameGenerator is used to pull names, both first and last, from a
    // predetermined list.
    private String firstName;
    private String lastName;
    // LocationGenerator will pull in a Location object, including both a city and
    // state.
    private Location hometown;
    // The College object utilizes a list pulled from a third party, so it contains
    // several data points that will nott necessarily be used.
    private College college;
    private int height;
    private int weight;
    // The following fields are going to be changing regularly. Setters and Getters
    // are non-negotiable.
    private int experience;
    private int age;
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
    // If LeadershipStyle matches that of the coach, certain attributes will be
    // boosted.
    private LeadershipStyle preferredLeadershipStyle;
    // Matchup outcomes can be affected by a combination of handedness and player
    // position.
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
            weight = newWeight;
        } else {
            System.out.print("Invalid Height");
        }
    }

    public int getAwareness() {
        return awareness;
    }

    public void setAwareness(int i) {
        awareness = i;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int i) {
        strength = i;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int i) {
        speed = i;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void setAccerlation(int i) {
        acceleration = i;
    }

    public int getInjuryResistance() {
        return injuryResistance;
    }

    public void setInjuryResistance(int i) {
        injuryResistance = i;
    }

    public int getPassBlock() {
        return passBlock;
    }

    public void setPassBlock(int i) {
        passBlock = i;
    }

    public int getRunBlock() {
        return runBlock;
    }

    public void setRunBlock(int i) {
        runBlock = i;
    }

    public int getImpactBlock() {
        return impactBlock;
    }

    public void setImpactBlock(int i) {
        impactBlock = i;
    }

    public int getCarrying() {
        return carrying;
    }

    public void setCarrying(int i) {
        carrying = i;
    }

    public int getBallCarrierVision() {
        return ballCarrierVision;
    }

    public void setBallCarrierVision(int i) {
        ballCarrierVision = i;
    }

    public int getCatching() {
        return catching;
    }

    public void setCatching(int i) {
        catching = i;
    }

    public int getRouteRunning() {
        return routeRunning;
    }

    public void setRouteRunning(int i) {
        routeRunning = i;
    }

    public int getTrucking() {
        return trucking;
    }

    public void setTrucking(int i) {
        trucking = i;
    }

    public int getElusiveness() {
        return elusiveness;
    }

    public void setElusiveness(int i) {
        elusiveness = i;
    }

    public int getCatchInTraffic() {
        return catchInTraffic;
    }

    public void setCatchInTraffic(int i) {
        catchInTraffic = i;
    }

    public int getSpectacularCatch() {
        return spectacularCatch;
    }

    public void setSpectacularCatch(int i) {
        spectacularCatch = i;
    }

    public int getRelease() {
        return release;
    }

    public void setRelease(int i) {
        release = i;
    }

    public int getStiffArm() {
        return stiffArm;
    }

    public void setStiffArm(int i) {
        stiffArm = i;
    }

    public int getJuke() {
        return juke;
    }

    public void setJuke(int i) {
        juke = i;
    }

    public int getJumping() {
        return jumping;
    }

    public void setJumping(int i) {
        jumping = i;
    }

    public int getThrowPower() {
        return throwPower;
    }

    public void setThrowPower(int i) {
        throwPower = i;
    }

    public int getShortAccuracy() {
        return shortAccuracy;
    }

    public void setShortAccuracy(int i) {
        shortAccuracy = i;
    }

    public int getMediumAccuracy() {
        return mediumAccuracy;
    }

    public void setMediumAccuracy(int i) {
        mediumAccuracy = i;
    }

    public int getDeepAccuracy() {
        return deepAccuracy;
    }

    public void setDeepAccuracy(int i) {
        deepAccuracy = i;
    }

    public int getPlayAction() {
        return playAction;
    }

    public void setPlayAction(int i) {
        playAction = i;
    }

    public int getThrowOnTheRun() {
        return throwOnTheRun;
    }

    public void setThrowOnTheRun(int i) {
        throwOnTheRun = i;
    }

    public int getTackle() {
        return tackle;
    }

    public void setTackle(int i) {
        tackle = i;
    }

    public int getPlayRecognition() {
        return playRecognition;
    }

    public void setPlayRecognition(int i) {
        playRecognition = i;
    }

    public int getBlockShedding() {
        return blockShedding;
    }

    public void setBlockShedding(int i) {
        blockShedding = i;
    }

    public int getPowerMoves() {
        return powerMoves;
    }

    public void setPowerMoves(int i) {
        powerMoves = i;
    }

    public int getFinesseMoves() {
        return finesseMoves;
    }

    public void setFinesseMoves(int i) {
        finesseMoves = i;
    }

    public int getZoneCoverage() {
        return zoneCoverage;
    }

    public void setZoneCoverage(int i) {
        zoneCoverage = i;
    }

    public int getManCoverage() {
        return manCoverage;
    }

    public void setManCoverage(int i) {
        manCoverage = i;
    }

    public int getPursuit() {
        return pursuit;
    }

    public void setPursuit(int i) {
        pursuit = i;
    }

    public int getHitPower() {
        return hitPower;
    }

    public void setHitPower(int i) {
        hitPower = i;
    }

    public int getPress() {
        return press;
    }

    public void setPress(int i) {
        press = i;
    }

    public int getKickAccuracy() {
        return kickAccuracy;
    }

    public void setKickAccuracy(int i) {
        kickAccuracy = i;
    }

    public int getKickPower() {
        return kickPower;
    }

    public void setKickPower(int i) {
        kickPower = i;
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

    public void addStart(int i) {
        starts = starts + i;
    }

    public int getWins() {
        return wins;
    }

    public void addWins(int i) {
        wins = wins + i;
    }

    public int getLosses() {
        return losses;
    }

    public void addLosses(int i) {
        losses = losses + i;
    }

    public int getDraws() {
        return draws;
    }

    public void addDraws(int i) {
        draws = draws + i;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void addGamesPlayed(int i) {
        gamesPlayed = gamesPlayed + i;
    }

    public int getSeasonsPlayed() {
        return seasonsPlayed;
    }

    public void addSeasonsPlayed(int i) {
        seasonsPlayed = seasonsPlayed + i;
    }

    public int getMatchupWins() {
        return matchupWins;
    }

    public void addMatchupWins(int i) {
        matchupWins = matchupWins + i;
    }

    public int getDownsPlayed() {
        return downsPlayed;
    }

    public void addDownsPlayed(int i) {
        downsPlayed = downsPlayed + i;
    }

    // Methods for filling data fields
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

    // Code for progression and regression of players in-game;
    public static int raiseStat(int stat, int change) {
        if (stat < (99 - change)) {
            return stat + change;
        } else {
            stat = 99;
            return stat;
        }
    }

    public static int lowerStat(int stat, int change) {
        if (stat > change) {
            return stat - change;
        } else {
            stat = 0;
            return stat;
        }
    }

    /*
     * Usage:
     * 
     * player.setStrength(lowerStat(player.getStrength(), 3));
     */

    @Override
    public String toString() {
        return String.format(
                "%s %s #%d - %s | Age: %d, Exp: %d | Spd: %d, Str: %d, Awr: %d | Pow: %d, ShtAcc: %d, MedAcc: %d, DpAcc: %d | Tck: %d, Ctch: %d",
                firstName, lastName, number, position, age, experience,
                speed, strength, awareness,
                throwPower, shortAccuracy, mediumAccuracy, deepAccuracy,
                tackle, catching);
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
            this.college = college;
            return this;
        }

        public Builder handedness(Handedness handedness) {
            this.handedness = handedness;
            return this;
        }

        public Builder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder hometown(Location hometown) {
            this.hometown = hometown;
            return this;
        }

        public Builder strength(int strength) {
            this.strength = strength;
            return this;
        }

        public Builder acceleration(int acceleration) {
            this.acceleration = acceleration;
            return this;
        }

        public Builder injuryResistance(int injuryResistance) {
            this.injuryResistance = injuryResistance;
            return this;
        }

        public Builder passBlock(int passBlock) {
            this.passBlock = passBlock;
            return this;
        }

        public Builder runBlock(int runBlock) {
            this.runBlock = runBlock;
            return this;
        }

        public Builder impactBlock(int impactBlock) {
            this.impactBlock = impactBlock;
            return this;
        }

        public Builder carrying(int carrying) {
            this.carrying = carrying;
            return this;
        }

        public Builder routeRunning(int routeRunning) {
            this.routeRunning = routeRunning;
            return this;
        }

        public Builder ballCarrierVision(int ballCarrierVision) {
            this.ballCarrierVision = ballCarrierVision;
            return this;
        }

        public Builder trucking(int trucking) {
            this.trucking = trucking;
            return this;
        }

        public Builder elusiveness(int elusiveness) {
            this.elusiveness = elusiveness;
            return this;
        }

        public Builder catchInTraffic(int catchInTraffic) {
            this.catchInTraffic = catchInTraffic;
            return this;
        }

        public Builder spectacularCatch(int spectacularCatch) {
            this.spectacularCatch = spectacularCatch;
            return this;
        }

        public Builder release(int release) {
            this.release = release;
            return this;
        }

        public Builder stiffArm(int stiffArm) {
            this.stiffArm = stiffArm;
            return this;
        }

        public Builder juke(int juke) {
            this.juke = juke;
            return this;
        }

        public Builder jumping(int jumping) {
            this.jumping = jumping;
            return this;
        }

        public Builder shortAccuracy(int shortAccuracy) {
            this.shortAccuracy = shortAccuracy;
            return this;
        }

        public Builder mediumAccuracy(int mediumAccuracy) {
            this.mediumAccuracy = mediumAccuracy;
            return this;
        }

        public Builder deepAccuracy(int deepAccuracy) {
            this.deepAccuracy = deepAccuracy;
            return this;
        }

        public Builder playAction(int playAction) {
            this.playAction = playAction;
            return this;
        }

        public Builder throwOnTheRun(int throwOnTheRun) {
            this.throwOnTheRun = throwOnTheRun;
            return this;
        }

        public Builder tackle(int tackle) {
            this.tackle = tackle;
            return this;
        }

        public Builder playRecognition(int playRecognition) {
            this.playRecognition = playRecognition;
            return this;
        }

        public Builder blockShedding(int blockShedding) {
            this.blockShedding = blockShedding;
            return this;
        }

        public Builder powerMoves(int powerMoves) {
            this.powerMoves = powerMoves;
            return this;
        }

        public Builder finesseMoves(int finesseMoves) {
            this.finesseMoves = finesseMoves;
            return this;
        }

        public Builder zoneCoverage(int zoneCoverage) {
            this.zoneCoverage = zoneCoverage;
            return this;
        }

        public Builder manCoverage(int manCoverage) {
            this.manCoverage = manCoverage;
            return this;
        }

        public Builder pursuit(int pursuit) {
            this.pursuit = pursuit;
            return this;
        }

        public Builder hitPower(int hitPower) {
            this.hitPower = hitPower;
            return this;
        }

        public Builder press(int press) {
            this.press = press;
            return this;
        }

        public Builder kickAccuracy(int kickAccuracy) {
            this.kickAccuracy = kickAccuracy;
            return this;
        }

        public Builder kickPower(int kickPower) {
            this.kickPower = kickPower;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

        private static int randBetween(int min, int max) {
            return rand.nextInt(max - min + 1) + min;
        }

    }
}
