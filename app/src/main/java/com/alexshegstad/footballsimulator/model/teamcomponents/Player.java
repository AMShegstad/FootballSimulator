package com.alexshegstad.footballsimulator.model.teamcomponents;

public class Player {

    private Position position;
    private int number;
    private String firstName;
    private String lastName;
    private String hometown;
    private College college;
    private int experience;
    private int age;
    private int height;
    private int weight;
    private int awareness;
    private int strength;
    private int speed;
    private int acceleration;
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
    private int injuryResistance;
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
    private int starts;
    private int wins;
    private int losses;
    private int gamesPlayed;
    private int seasonsPlayed;
    private int downsPlayed;
    private int matchupWins;

    public Player(String firstName, String lastName, String hometown, String college, Position position, int number, int experience, int age, int height, int weight, int awareness, int strength, int speed, int acceleration, int passBlock, int runBlock, int impactBlock, int carrying, int catching, int routeRunning, int ballCarrierVision, int trucking, int elusiveness, int catchInTraffic, int spectacularCatch, int release, int stiffArm, int juke, int jumping, int injuryResistance, int throwPower, int shortAccuracy, int mediumAccuracy, int deepAccuracy, int playAction, int throwOnTheRun, int tackle, int playRecognition, int blockShedding, int powerMoves, int finesseMoves, int zoneCoverage, int manCoverage, int pursuit, int hitPower, int press, int kickAccuracy, int kickPower, int wins, int losses, int starts, int gamesPlayed, int seasonsPlayed, int downsPlayed, int matchupWins) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hometown = hometown;
        this.age = age;
        this.number = number;
        this.height = height;
        this.weight = weight;
        this.awareness = awareness;
        this.strength = strength;
        this.speed = speed;
        this.acceleration = acceleration;
        this.passBlock = passBlock;
        this.runBlock = runBlock;
        this.impactBlock = impactBlock;
        this.carrying = carrying;
        this.catching = catching;
        this.routeRunning = routeRunning;
        this.ballCarrierVision = ballCarrierVision;
        this.trucking = trucking;
        this.elusiveness = elusiveness;
        this.catchInTraffic = catchInTraffic;
        this.spectacularCatch = spectacularCatch;
        this.release = release;
        this.stiffArm = stiffArm;
        this.juke = juke;
        this.jumping = jumping;
        this.injuryResistance = injuryResistance;
        this.throwPower = throwPower;
        this.shortAccuracy = shortAccuracy;
        this.mediumAccuracy = mediumAccuracy;
        this.deepAccuracy = deepAccuracy;
        this.playAction = playAction;
        this.throwOnTheRun = throwOnTheRun;
        this.tackle = tackle;
        this.playRecognition = playRecognition;
        this.blockShedding = blockShedding;
        this.powerMoves = powerMoves;
        this.finesseMoves = finesseMoves;
        this.zoneCoverage = zoneCoverage;
        this.manCoverage = manCoverage;
        this.pursuit = pursuit;
        this.hitPower = hitPower;
        this.press = press;
        this.kickAccuracy = kickAccuracy;
        this.kickPower = kickPower;
        this.starts = starts;
        this.wins = wins;
        this.losses = losses;
        this.gamesPlayed = gamesPlayed;
        this.downsPlayed = downsPlayed;
        this.matchupWins = matchupWins;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public Position getPosition() {
        return position;
    }

    public String getHometown() {
        return hometown;
    }

    public College getCollege() {
        return college;
    }

    public int getExperience() {
        return experience;
    }

    public void incrementExperience() {
        if (experience < 20) {
            experience++;
        } else {
            // Implement retirement at some point...
        }
    }

    public int getAge() {
        return age;
    }

    public void incrementAge() {
        age++;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int i) {
        weight = i;
        System.out.println("Player weight set to " + i);
    }

    public int getAwareness() {
        return awareness;
    }

    public void incrementAwareness() {
        if (awareness < 99) { 
            awareness++;
        } else {
            System.out.println("Max value reached");
        }
    }

    public void decrementAwareness() {
        if (awareness >= 2) {
            awareness--;
        } else {
            System.out.println("Lowest value reached");
        }
    }

    public int getStrength() {
        return strength;
    }

    public void incrementStrength() {
        if (strength < 99) {
            strength++;
        } else {
            System.out.println("Max value reached");
        }
    }

    public void decrementStrength() {
        if (strength >= 2) {
            strength--;
        } else {
            System.out.println("Min value reached");
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void incrementSpeed() {
        if (speed < 99) {
            speed++;
        } else {
            System.out.println("Max value reached");
        }
    }

    public void decrementSpeed() {
        if (strength >= 2) {
            strength--;
        } else {
            System.out.println("Min value reached");
        }
    }

    public int getAcceleration() {
        return acceleration;
    }

    public void incrementAcceleration() {
        if (acceleration < 99) {
            acceleration++;
        } else {
            System.out.println("Max value reached");
        }
    }

    public void decrementAcceleration() {
        if (strength >= 2) {
            strength--;
        } else {
            System.out.println("Min value reached");
        }
    }

    public int getPassBlock() {
        return passBlock;
    }

    public void incrementPassBlock() {
        if (passBlock < 99) {
            passBlock++;
        } else {
            System.out.println("Max passBlock value reached");
        }
    }

    public void decrementPassBlock() {
        if (passBlock >= 2) {
            passBlock--;
        } else {
            System.out.println("Min passBlock value reached");
        }
    }

    public int getRunBlock() {
        return runBlock;
    }

    public void incrementRunBlock() {
        if (runBlock < 99) {
            runBlock++;
        } else {
            System.out.println("Max runBlock value reached");
        }
    }

    public void decrementRunBlock() {
        if (runBlock >= 2) {
            runBlock--;
        } else {
            System.out.println("Min runBlock value reached");
        }
    }

    public int getImpactBlock() {
        return impactBlock;
    }

    public void incrementImpactBlock() {
        impactBlock++;
    }

    public void decrementImpactBlock() {
        impactBlock--;
    }

    public int getCarrying() {
        return carrying;
    }

    public void incrementCarrying() {
        carrying++;
    }

    public int getCatching() {
        return catching;
    }

    public int getRouteRunning() {
        return routeRunning;
    }

    public int getBallCarrierVision() {
        return ballCarrierVision;
    }

    public int getTrucking() {
        return trucking;
    }

    public int getElusiveness() {
        return elusiveness;
    }

    public int getCatchInTraffic() {
        return catchInTraffic;
    }

    public int getSpectacularCatch() {
        return spectacularCatch;
    }

    public int getRelease() {
        return release;
    }

    public int getStiffArm() {
        return stiffArm;
    }

    public int getJuke() {
        return juke;
    }

    public int getJumping() {
        return jumping;
    }

    public int injuryResistance() {
        return injuryResistance;
    }

    public int getThrowPower() {
        return throwPower;
    }

    public int getShortAccuracy() {
        return shortAccuracy;
    }

    public int getMediumAccuracy() {
        return mediumAccuracy;
    }

    public int getDeepAccuracy() {
        return deepAccuracy;
    }

    public int getPlayAction() {
        return playAction;
    }

    public int getThrowOnTheRun() {
        return throwOnTheRun;
    }

    public int getTackle() {
        return tackle;
    }

    public int getPlayRecognition() {
        return playRecognition;
    }

    public int getBlockShedding() {
        return blockShedding;
    }

    public int getPowerMoves() {
        return powerMoves;
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

    public int getNumber() {
        return number;
    }

    public int getKickAccuracy() {
        return kickAccuracy;
    }

    public int getKickPower() {
        return kickPower;
    }

    public String toString() {
        String text = "";
        return text;
    }

    public int getStarts() {
        return starts;
    }

    public void incrementStarts() {
        starts = starts + 1;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        wins = wins + 1;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementLosses() {
        losses = losses + 1;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void incrementGamesPlayed() {
        gamesPlayed = gamesPlayed + 1;
    }

    public int getSeasonsPlayed() {
        return seasonsPlayed;
    }

    public void incrementSeasonsPlayed() {
        seasonsPlayed = seasonsPlayed + 1;
    }

    public int getDownsPlayed() {
        return downsPlayed;
    }

    public void incrementDownsPlayed() {
        downsPlayed = downsPlayed + 1;
    }

    public int getMatchupWins() {
        return matchupWins;
    }

    public void incrementMatchupWins() {
        matchupWins = matchupWins + 1;
    }
}
