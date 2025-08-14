package com.alexshegstad.footballsimulator.model.teamcomponents;

public class Player {

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
    private int starts = 0;
    private int wins = 0;
    private int losses = 0;
    private int gamesPlayed = 0;
    private int seasonsPlayed = 0;
    private int downsPlayed = 0;
    private int matchupWins = 0;

    public Player(String firstName, String lastName, Location hometown, College college, Position position, int number, int experience, int age, int height, int weight, int awareness, int strength, int speed, int acceleration, int passBlock, int runBlock, int impactBlock, int carrying, int catching, int routeRunning, int ballCarrierVision, int trucking, int elusiveness, int catchInTraffic, int spectacularCatch, int release, int stiffArm, int juke, int jumping, int injuryResistance, int throwPower, int shortAccuracy, int mediumAccuracy, int deepAccuracy, int playAction, int throwOnTheRun, int tackle, int playRecognition, int blockShedding, int powerMoves, int finesseMoves, int zoneCoverage, int manCoverage, int pursuit, int hitPower, int press, int kickAccuracy, int kickPower) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.hometown = hometown;
        this.college = college;
        this.age = age;
        this.number = number;
        this.experience = experience;
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
    }

    // Test created
    public String getFirstName() {
        return firstName;
    }

    // Test created
    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Test created
    public Position getPosition() {
        return position;
    }

    // Test created
    public String getHometown() {
        return hometown.toString();
    }

    // Test created
    public College getCollege() {
        return college;
    }

    // 
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
        if (awareness > 1) {
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
        if (strength > 1) {
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
        if (strength > 1) {
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
        if (strength > 1) {
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
        if (passBlock > 1) {
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
        if (runBlock > 1) {
            runBlock--;
        } else {
            System.out.println("Min runBlock value reached");
        }
    }

    public int getImpactBlock() {
        return impactBlock;
    }

    public void incrementImpactBlock() {
        if (impactBlock < 99) {
            impactBlock++;
        } else {
            System.out.println("Max impactBlock value reached");
        }
    }

    public void decrementImpactBlock() {
        if (impactBlock > 1) {
            impactBlock--;
        } else {
            System.out.println("Min impactBlock value reached");
        }
    }

    public int getCarrying() {
        return carrying;
    }

    public void incrementCarrying() {
        if (carrying < 99) {
            carrying++;
        } else {
            System.out.println("Max carrying value reached");
        }
    }

    public void decrementCarrying() {
        if (carrying > 1) {
            carrying--;
        } else {
            System.out.println("Min carrying value reached");
        }
    }

    public int getCatching() {
        return catching;
    }

    public void incrementCatching() {
        if (catching < 99) {
            catching++;
        } else {
            System.out.println("Max catching value reached");
        }
    }

    public void decrementCatching() {
        if (catching > 1) {
            catching--;
        } else {
            System.out.println("Min catching value reached");
        }
    }

    public int getRouteRunning() {
        return routeRunning;
    }

    public void incrementRouteRunning() {
        if (routeRunning < 99) {
            routeRunning++;
        } else {
            System.out.println("Max routeRunning value reached");
        }
    }

    public void decrementRouteRunning() {
        if (routeRunning > 1) {
            routeRunning--;
        } else {
            System.out.println("Min routeRunning value reached");
        }
    }

    public int getBallCarrierVision() {
        return ballCarrierVision;
    }

    public void incrementBallCarrierVision() {
        if (ballCarrierVision < 99) {
            ballCarrierVision++;
        } else {
            System.out.println("Max ballCarrierVision value reached");
        }
    }

    public void decrementBallCarrierVision() {
        if (ballCarrierVision > 1) {
            ballCarrierVision--;
        } else {
            System.out.println("Min ballCarrierVision value reached");
        }
    }

    public int getTrucking() {
        return trucking;
    }

    public void incrementTrucking() {
        if (trucking < 99) {
            trucking++;
        } else {
            System.out.println("Max trucking value reached");
        }
    }

    public void decrementTrucking() {
        if (trucking > 1) {
            trucking--;
        } else {
            System.out.println("Min trucking value reached");
        }
    }

    public int getElusiveness() {
        return elusiveness;
    }

    public void incrementExlusiveness() {
        if (elusiveness < 99) {
            elusiveness++;
        } else {
            System.out.println("Max elusiveness value reached");
        }
    }

    public void decrementElusiveness() {
        if (elusiveness > 1) {
            elusiveness++;
        } else {
            System.out.println("Min elusiveness value reached");
        }
    }

    public int getCatchInTraffic() {
        return catchInTraffic;
    }

    public void incrementCatchIntTraffic() {
        if (catchInTraffic < 99) {
            catchInTraffic++;
        } else {
            System.out.println("Max catchInTraffic value reached");
        }
    }

    public void decrementCatchInTraffic() {
        if (catchInTraffic > 1) {
            catchInTraffic--;
        } else {
            System.out.println("Min catchInTraffic value reached");
        }
    }

    public int getSpectacularCatch() {
        return spectacularCatch;
    }

    public void incrementSpectacularCatch() {
        if (spectacularCatch < 99) {
            spectacularCatch++;
        } else {
            System.out.println("Max spectacularCatch value reached");
        }
    }

    public void decrementSpectacularCatch() {
        if (spectacularCatch > 1) {
            spectacularCatch--;
        } else {
            System.out.println("Min spectacularCatch value reached");
        }
    }

    public int getRelease() {
        return release;
    }

    public void incrementRelease() {
        if (release < 99) {
            release++;
        } else {
            System.out.println("Max release value reached");
        }
    }

    public void decrementRelease() {
        if (release > 1) {
            release--;
        } else {
            System.out.println("Min release value reached");
        }
    }

    public int getStiffArm() {
        return stiffArm;
    }

    public void incrementStiffArm() {
        if (stiffArm < 99) {
            stiffArm++;
        } else {
            System.out.println("Max stiffArm value reached");
        }
    }

    public void decrementStiffArm() {
        if (stiffArm > 1) {
            stiffArm--;
        } else {
            System.out.println("Min stiffArm value reached");
        }
    }

    public int getJuke() {
        return juke;
    }

    public void incrementJuke() {
        if (juke < 99) {
            juke++;
        } else {
            System.out.println("Max juke value reached");
        }
    }

    public void decrementJuke() {
        if (juke > 1) {
            juke--;
        } else {
            System.out.println("Min juke value reached");
        }
    }

    public int getJumping() {
        return jumping;
    }

    public void incrementJumping() {
        if (jumping < 99) {
            jumping++;
        } else {
            System.out.println("Max jumping value reached");
        }
    }

    public void decrementJumping() {
        if (jumping > 1) {
            jumping--;
        } else {
            System.out.println("Min jumping value reached");
        }
    }

    public int injuryResistance() {
        return injuryResistance;
    }

    public void incrementInjuryResistance() {
        if (injuryResistance < 99) {
            injuryResistance++;
        } else {
            System.out.println("Max injuryResistance value reached");
        }
    }

    public void decrementInjuryResistance() {
        if (injuryResistance > 1) {
            injuryResistance--;
        } else {
            System.out.println("Min injuryResistance value reached");
        }
    }

    public int getThrowPower() {
        return throwPower;
    }

    public void incrementThrowPower() {
        if (throwPower < 99) {
            throwPower++;
        } else {
            System.out.println("Max throwPower value reached");
        }
    }

    public void decrementThrowPower() {
        if (throwPower > 1) {
            throwPower--;
        } else {
            System.out.println("Min throwPower value reached");
        }
    }

    public int getShortAccuracy() {
        return shortAccuracy;
    }

    public void incrementShortAccuracy() {
        if (shortAccuracy < 99) {
            shortAccuracy++;
        } else {
            System.out.println("Max shortAccuracy value reached");
        }
    }

    public void decrementShortAccuracy() {
        if (shortAccuracy > 1) {
            shortAccuracy--;
        } else {
            System.out.println("Min shortAccuracy value reached");
        }
    }

    public int getMediumAccuracy() {
        return mediumAccuracy;
    }

    public void incrementMediumAccuracy() {
        if (mediumAccuracy < 99) {
            mediumAccuracy++;
        } else {
            System.out.println("Max mediumAccuracy value reached");
        }
    }

    public void decrementMediumAccuracy() {
        if (mediumAccuracy > 1) {
            mediumAccuracy--;
        } else {
            System.out.println("Min mediumAccuracy value reached");
        }
    }

    public int getDeepAccuracy() {
        return deepAccuracy;
    }

    public void incrementDeepAccuracy() {
        if (deepAccuracy < 99) {
            deepAccuracy++;
        } else {
            System.out.println("Max deepAccuracy value reached");
        }
    }

    public void decrementDeepAccuracy() {
        if (deepAccuracy > 1) {
            deepAccuracy--;
        } else {
            System.out.println("Min deepaccuracy value reached");
        }
    }

    public int getPlayAction() {
        return playAction;
    }

    public void incrementPlayAction() {
        if (playAction < 99) {
            playAction++;
        } else {
            System.out.println("Max playAction value reached");
        }
    }

    public void decrementPlayAction() {
        if (playAction > 1) {
            playAction--;
        } else {
            System.out.println("Min placyAction value reached");
        }
    }

    public int getThrowOnTheRun() {
        return throwOnTheRun;
    }

    public void incrementThrowOnTheRun() {
        if (throwOnTheRun < 99) {
            throwOnTheRun++;
        } else {
            System.out.println("Max throwOnTheRun value reached");
        }
    }

    public void decrementThrowOnTheRun() {
        if (throwOnTheRun > 1) {
            throwOnTheRun--;
        } else {
            System.out.println("Min throwOnTheRun value reached");
        }
    }

    public int getTackle() {
        return tackle;
    }

    public void incrementTackle() {
        if (tackle < 99) {
            tackle++;
        } else {
            System.out.println("Max tackle value reached");
        }
    }

    public void decrementTackle() {
        if (tackle > 1) {
            tackle--;
        } else {
            System.out.println("Min tackle value reached");
        }
    }

    public int getPlayRecognition() {
        return playRecognition;
    }

    public void incrementPlayRecognition() {
        if (playRecognition < 99) {
            playRecognition++;
        } else {
            System.out.println("Max playRecognition value reached");
        }
    }

    public void decrementPlayRecognition() {
        if (playRecognition > 1) {
            playRecognition--;
        } else {
            System.out.println("Min playRecognition value reached");
        }
    } 

    public int getBlockShedding() {
        return blockShedding;
    }

    public void incrementBlockShedding() {
        if (blockShedding < 99) {
            blockShedding++;
        } else {
            System.out.println("Max playRecognition value reached");
        }
    }

    public void decrementBlockShedding() {
        if (blockShedding > 1) {
            blockShedding--;
        } else {
            System.out.println("Min blockShedding value reached");
        }
    }

    public int getPowerMoves() {
        return powerMoves;
    }

    public void incrementPowerMoves() {
        if (powerMoves < 99) {
            powerMoves++;
        } else {
            System.out.println("Max powerMoves value reached");
        }
    }

    public void decrementPowerMoves() {
        if (powerMoves > 1) {
            powerMoves--;
        } else {
            System.out.println("Min powerMoves value reached");
        }
    }

    public int getFinesseMoves() {
        return finesseMoves;
    }

    public void incrementFinesseMoves() {
        if (finesseMoves < 99) {
            finesseMoves++;
        } else {
            System.out.println("Max finesseMoves value reached");
        }
    }

    public void decrementFinesseMoves() {
        if (finesseMoves > 1) {
            finesseMoves--;
        } else {
            System.out.println("Min finesseMoves value reached");
        }
    }

    public int getZoneCoverage() {
        return zoneCoverage;
    }

    public void incrementZoneCoverage() {
        if (zoneCoverage < 99) {
            zoneCoverage++;
        } else {
            System.out.println("Max zoneCoverage value reached");
        }
    }

    public void decrementZoneCoverage() {
        if (zoneCoverage > 1) {
            zoneCoverage--;
        } else {
            System.out.println("Min zoneCoverage value reached");
        }
    }

    public int getManCoverage() {
        return manCoverage;
    }

    public void incrementManCoverage() {
        if (manCoverage < 99) {
            manCoverage++;
        } else {
            System.out.println("Max manCoverage value reached");
        }
    }

    public void decrementManCoverage() {
        if (manCoverage > 1) {
            manCoverage--;
        } else {
            System.out.println("Min manCoverage value reached");
        }
    }

    public int getPursuit() {
        return pursuit;
    }

    public void incrementPursuit() {
        if (pursuit < 99) {
            pursuit++;
        } else {
            System.out.println("Max pursuit value reached");
        }
    }

    public void decrementPursuit() {
        if (pursuit > 1) {
            pursuit--;
        } else {
            System.out.println("Min pursuit value reached");
        }
    }

    public int getHitPower() {
        return hitPower;
    }

    public void incrementHitPower() {
        if (hitPower < 99) {
            hitPower++;
        } else {
            System.out.println("Max hitPower value reached");
        }
    }

    public void decrementHitPower() {
        if (hitPower > 1) {
            hitPower--;
        } else {
            System.out.println("Min hitPower value reached");
        }
    }

    public int getPress() {
        return press;
    }

    public void incrementPress() {
        if (press < 99) {
            press++;
        } else {
            System.out.println("Max press value reached");
        }
    }

    public void decrementPress() {
        if (press > 1) {
            press--;
        } else {
            System.out.println("Min press value reached");
        }
    }

    public int getNumber() {
        return number;
    }

    public int getKickAccuracy() {
        return kickAccuracy;
    }

    public void incrementKickAccuracy() {
        if (kickAccuracy < 99) {
            kickAccuracy++;
        } else {
            System.out.print("Max kickAccuracy value reached");
        }
    }

    public void decrementKickAccuracy() {
        if (kickAccuracy > 1) {
            kickAccuracy--;
        } else {
            System.out.println("Min kickAccuracy value reached");
        }
    }

    public int getKickPower() {
        return kickPower;
    }

    public void incrementKickPower() {
        if (kickPower < 99) {
            kickPower++;
        } else {
            System.out.println("Max kickPower value reached");
        }
    }

    public void decrementKickPower() {
        if (kickPower > 1) {
            kickPower--;
        } else {
            System.out.println("Min kickPower value reached");
        }
    }

    public String toString() {
        String text = "";
        return text;
    }

    public int getStarts() {
        return starts;
    }

    public void incrementStarts() {
        starts++;
    }

    public int getWins() {
        return wins;
    }

    public void incrementWins() {
        wins++;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementLosses() {
        losses++;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void incrementGamesPlayed() {
        gamesPlayed++;
    }

    public int getSeasonsPlayed() {
        return seasonsPlayed;
    }

    public void incrementSeasonsPlayed() {
        seasonsPlayed++;
    }

    public int getDownsPlayed() {
        return downsPlayed;
    }

    public void incrementDownsPlayed() {
        downsPlayed++;
    }

    public int getMatchupWins() {
        return matchupWins;
    }

    public void incrementMatchupWins() {
        matchupWins++;
    }
}
