package com.alexshegstad.footballsimulator.model.game;

public class Gridiron {
    
    // Field dimensions in yards
    public static final int TOTAL_LENGTH = 120;
    public static final int FIELD_LENGTH = 100;
    public static final int ENDZONE_DEPTH = 10;
    public static final int FIELD_WIDTH = 53;
    
    // Hash mark positions (distance from sideline in yards)
    public static final int HASH_MARK_DISTANCE_FROM_SIDELINE = 18;
    public static final int MIN_ROUTE_SPACE = 15;
    
    // Field representation - [length][width]
    // field[0] = back of endzone, field[119] = back of opposite endzone
    // field[10] = goal line, field[110] = opposite goal line
    private FieldPosition[][] field;
    
    // Current ball position
    private int ballX; // 0-119 (length)
    private int ballY; // 0-52 (width)
    
    public enum FieldZone {
        ENDZONE_1,      // 0-9
        PLAYING_FIELD,  // 10-109
        ENDZONE_2       // 110-119
    }
    
    public enum FieldPosition {
        EMPTY,          // Empty field space
        BALL,           // Current ball position
        HASH_MARK,      // Hash mark positions
        GOAL_LINE,      // Goal lines (10 and 110)
        SIDELINE,       // Sidelines (y=0 and y=52)
        OUT_OF_BOUNDS   // Beyond field boundaries
    }
    
    public Gridiron() {
        initializeField();
        setBallPosition(60, FIELD_WIDTH / 2); // Start at midfield, center
    }
    
    private void initializeField() {
        field = new FieldPosition[TOTAL_LENGTH][FIELD_WIDTH + 1]; // +1 for both sidelines
        
        // Initialize all positions as empty
        for (int x = 0; x < TOTAL_LENGTH; x++) {
            for (int y = 0; y <= FIELD_WIDTH; y++) {
                field[x][y] = FieldPosition.EMPTY;
            }
        }
        
        // Mark sidelines
        for (int x = 0; x < TOTAL_LENGTH; x++) {
            field[x][0] = FieldPosition.SIDELINE;
            field[x][FIELD_WIDTH] = FieldPosition.SIDELINE;
        }
        
        // Mark goal lines
        for (int y = 0; y <= FIELD_WIDTH; y++) {
            field[10][y] = FieldPosition.GOAL_LINE;
            field[110][y] = FieldPosition.GOAL_LINE;
        }
        
        // Mark hash marks (every yard between goal lines)
        for (int x = 10; x <= 110; x++) {
            field[x][HASH_MARK_DISTANCE_FROM_SIDELINE] = FieldPosition.HASH_MARK;
            field[x][FIELD_WIDTH - HASH_MARK_DISTANCE_FROM_SIDELINE] = FieldPosition.HASH_MARK;
        }
    }
    
    public void setBallPosition(int x, int y) {
        // Clear previous ball position
        clearBallFromField();
        
        // Validate and set new position
        this.ballX = Math.max(0, Math.min(TOTAL_LENGTH - 1, x));
        this.ballY = Math.max(1, Math.min(FIELD_WIDTH - 1, y)); // Keep within sidelines
        
        // Ensure ball is placed within hash marks during play
        if (isInPlayingField(ballX)) {
            this.ballY = Math.max(HASH_MARK_DISTANCE_FROM_SIDELINE, 
                         Math.min(FIELD_WIDTH - HASH_MARK_DISTANCE_FROM_SIDELINE, y));
        }
        
        // Place ball on field
        field[ballX][ballY] = FieldPosition.BALL;
    }
    
    public void moveToNearestHash() {
        if (ballY < FIELD_WIDTH / 2) {
            // Move to left hash
            setBallPosition(ballX, HASH_MARK_DISTANCE_FROM_SIDELINE);
        } else {
            // Move to right hash
            setBallPosition(ballX, FIELD_WIDTH - HASH_MARK_DISTANCE_FROM_SIDELINE);
        }
    }
    
    public void centerBall() {
        setBallPosition(ballX, FIELD_WIDTH / 2);
    }
    
    public boolean canPlaceBallAt(int x, int y) {
        // Check bounds
        if (x < 0 || x >= TOTAL_LENGTH || y < 1 || y >= FIELD_WIDTH) {
            return false;
        }
        
        // During play, ball must be between hash marks
        if (isInPlayingField(x)) {
            return y >= HASH_MARK_DISTANCE_FROM_SIDELINE && 
                   y <= FIELD_WIDTH - HASH_MARK_DISTANCE_FROM_SIDELINE;
        }
        
        return true;
    }
    
    public boolean hasRouteSpace(int receiverY, boolean breakingOut) {
        if (!breakingOut) {
            return true;
        }
        
        // Check space to both sidelines
        int spaceToLeftSideline = receiverY;
        int spaceToRightSideline = FIELD_WIDTH - receiverY;
        
        return Math.min(spaceToLeftSideline, spaceToRightSideline) >= MIN_ROUTE_SPACE;
    }
    
    public int getMaxWideReceiverSpread() {
        return FIELD_WIDTH - (2 * MIN_ROUTE_SPACE);
    }
    
    public FieldZone getFieldZone(int x) {
        if (x < 10) return FieldZone.ENDZONE_1;
        if (x > 110) return FieldZone.ENDZONE_2;
        return FieldZone.PLAYING_FIELD;
    }
    
    public boolean isInPlayingField(int x) {
        return x >= 10 && x <= 110;
    }
    
    public boolean isInEndzone(int x) {
        return x < 10 || x > 110;
    }
    
    public int getYardLine() {
        // Convert to traditional yard line (1-50)
        int absolutePosition = ballX;
        
        if (absolutePosition <= 60) {
            // Own territory
            return Math.max(1, absolutePosition - 9);
        } else {
            // Opponent territory
            return Math.max(1, 120 - absolutePosition - 9);
        }
    }
    
    public int getDistanceToGoal() {
        // Distance to nearest goal line
        return Math.min(ballX - 10, 110 - ballX);
    }
    
    public int getFieldGoalDistance() {
        // Distance for field goal attempt (includes endzone depth)
        return getDistanceToGoal() + ENDZONE_DEPTH + 7; // +7 for snap distance
    }
    
    public FieldPosition getPositionAt(int x, int y) {
        if (x < 0 || x >= TOTAL_LENGTH || y < 0 || y > FIELD_WIDTH) {
            return FieldPosition.OUT_OF_BOUNDS;
        }
        return field[x][y];
    }
    
    public boolean isHashMark(int x, int y) {
        return field[x][y] == FieldPosition.HASH_MARK;
    }
    
    public boolean isBetweenHashes(int y) {
        return y > HASH_MARK_DISTANCE_FROM_SIDELINE && 
               y < FIELD_WIDTH - HASH_MARK_DISTANCE_FROM_SIDELINE;
    }
    
    private void clearBallFromField() {
        // Find and clear current ball position
        for (int x = 0; x < TOTAL_LENGTH; x++) {
            for (int y = 0; y <= FIELD_WIDTH; y++) {
                if (field[x][y] == FieldPosition.BALL) {
                    // Restore original field marking
                    if (x == 10 || x == 110) {
                        field[x][y] = FieldPosition.GOAL_LINE;
                    } else if (y == 0 || y == FIELD_WIDTH) {
                        field[x][y] = FieldPosition.SIDELINE;
                    } else if ((y == HASH_MARK_DISTANCE_FROM_SIDELINE || 
                               y == FIELD_WIDTH - HASH_MARK_DISTANCE_FROM_SIDELINE) &&
                               isInPlayingField(x)) {
                        field[x][y] = FieldPosition.HASH_MARK;
                    } else {
                        field[x][y] = FieldPosition.EMPTY;
                    }
                }
            }
        }
    }
    
    // Getters
    public int getBallX() { return ballX; }
    public int getBallY() { return ballY; }
    public FieldPosition[][] getField() { return field; }
    
    // Debug method to print field representation
    public void printField() {
        System.out.println("Football Field (X=Length, Y=Width):");
        for (int x = 0; x < TOTAL_LENGTH; x += 10) {
            System.out.printf("%3d: ", x);
            for (int y = 0; y <= FIELD_WIDTH; y += 5) {
                char symbol = switch (field[x][y]) {
                    case BALL -> 'O';
                    case HASH_MARK -> 'H';
                    case GOAL_LINE -> 'G';
                    case SIDELINE -> '|';
                    case EMPTY -> '.';
                    case OUT_OF_BOUNDS -> 'X';
                };
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
