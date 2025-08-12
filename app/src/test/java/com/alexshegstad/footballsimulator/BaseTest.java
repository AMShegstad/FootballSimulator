package com.alexshegstad.footballsimulator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import java.util.logging.Logger;

public abstract class BaseTest {
    
    protected static final Logger logger = Logger.getLogger(BaseTest.class.getName());
    
    @BeforeEach
    void logTestStart(TestInfo testInfo) {
        logger.info("Starting test: " + testInfo.getDisplayName());
    }
    
    // Common test utilities
    protected void assertStatInRange(int stat, int min, int max) {
        if (stat < min || stat > max) {
            throw new AssertionError(
                String.format("Stat %d is not in range [%d, %d]", stat, min, max)
            );
        }
    }
}