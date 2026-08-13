package com.alexshegstad.footballsimulator.model.enumerations;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.assertj.core.api.Assertions.*;

public class SpendingHabitTest {
    
    @Test
    @DisplayName("✅ Should have all 5 spending habit types")
    void testAllSpendingHabitsExist() {
        SpendingHabit[] habits = SpendingHabit.values();
        
        assertThat(habits).hasSize(5);
        assertThat(habits).contains(
            SpendingHabit.MISERLY,
            SpendingHabit.FRUGAL,
            SpendingHabit.AVERAGE,
            SpendingHabit.GENEROUS,
            SpendingHabit.EXTRAVAGANT
        );
    }
    
    @Test
    @DisplayName("💰 Should have correct spending multipliers")
    void testSpendingMultipliers() {
        assertThat(SpendingHabit.MISERLY.getSpendingMultiplier()).isEqualTo(0.6);
        assertThat(SpendingHabit.FRUGAL.getSpendingMultiplier()).isEqualTo(0.8);
        assertThat(SpendingHabit.AVERAGE.getSpendingMultiplier()).isEqualTo(1.0);
        assertThat(SpendingHabit.GENEROUS.getSpendingMultiplier()).isEqualTo(1.3);
        assertThat(SpendingHabit.EXTRAVAGANT.getSpendingMultiplier()).isEqualTo(1.7);
    }
    
    @Test
    @DisplayName("📊 Should have multipliers in ascending order")
    void testMultipliersAscending() {
        assertThat(SpendingHabit.MISERLY.getSpendingMultiplier())
            .isLessThan(SpendingHabit.FRUGAL.getSpendingMultiplier());
        
        assertThat(SpendingHabit.FRUGAL.getSpendingMultiplier())
            .isLessThan(SpendingHabit.AVERAGE.getSpendingMultiplier());
        
        assertThat(SpendingHabit.AVERAGE.getSpendingMultiplier())
            .isLessThan(SpendingHabit.GENEROUS.getSpendingMultiplier());
        
        assertThat(SpendingHabit.GENEROUS.getSpendingMultiplier())
            .isLessThan(SpendingHabit.EXTRAVAGANT.getSpendingMultiplier());
    }
    
    @Test
    @DisplayName("📝 Should have non-empty names and descriptions")
    void testNamesAndDescriptions() {
        for (SpendingHabit habit : SpendingHabit.values()) {
            assertThat(habit.getHabit())
                .as("Habit name should not be null or empty")
                .isNotNull()
                .isNotEmpty();
                
            assertThat(habit.getDescription())
                .as("Description should not be null or empty")
                .isNotNull()
                .isNotEmpty();
        }
    }
    
    @Test
    @DisplayName("💵 Should calculate spending correctly")
    void testCalculateSpending() {
        double baseBudget = 100_000_000.0; // $100M base budget
        
        assertThat(SpendingHabit.MISERLY.calculateSpending(baseBudget))
            .isEqualTo(60_000_000.0); // 60% of base
        
        assertThat(SpendingHabit.FRUGAL.calculateSpending(baseBudget))
            .isEqualTo(80_000_000.0); // 80% of base
        
        assertThat(SpendingHabit.AVERAGE.calculateSpending(baseBudget))
            .isEqualTo(100_000_000.0); // 100% of base
        
        assertThat(SpendingHabit.GENEROUS.calculateSpending(baseBudget))
            .isEqualTo(130_000_000.0); // 130% of base
        
        assertThat(SpendingHabit.EXTRAVAGANT.calculateSpending(baseBudget))
            .isEqualTo(170_000_000.0); // 170% of base
    }
    
    @Test
    @DisplayName("🤔 Should determine willingness to spend")
    void testWillingnessToSpend() {
        double teamBudget = 50_000_000.0; // $50M available
        double expensivePlayer = 40_000_000.0; // $40M player
        double affordablePlayer = 20_000_000.0; // $20M player
        
        // MISERLY: Only willing to spend 60% of budget ($30M)
        assertThat(SpendingHabit.MISERLY.isWillingToSpend(expensivePlayer, teamBudget))
            .as("Miserly owner should not spend $40M when budget * 0.6 = $30M")
            .isFalse();
        
        assertThat(SpendingHabit.MISERLY.isWillingToSpend(affordablePlayer, teamBudget))
            .as("Miserly owner should spend $20M when budget * 0.6 = $30M")
            .isTrue();
        
        // EXTRAVAGANT: Willing to spend 170% of budget ($85M)
        assertThat(SpendingHabit.EXTRAVAGANT.isWillingToSpend(expensivePlayer, teamBudget))
            .as("Extravagant owner should spend $40M when budget * 1.7 = $85M")
            .isTrue();
    }
    
    @Test
    @DisplayName("🎯 Should demonstrate realistic spending scenarios")
    void testRealisticScenarios() {
        double salaryCap = 200_000_000.0; // NFL-like salary cap
        
        // Scenario 1: Superstar free agent costs $125M (exceeds MISERLY's $120M limit)
        double starPlayerCost = 125_000_000.0;
        
        assertThat(SpendingHabit.MISERLY.isWillingToSpend(starPlayerCost, salaryCap))
            .as("Miserly owner won't sign $125M superstar (limit = $200M * 0.6 = $120M)")
            .isFalse();
        
        assertThat(SpendingHabit.AVERAGE.isWillingToSpend(starPlayerCost, salaryCap))
            .as("Average owner can afford $30M star ($200M budget)")
            .isTrue();
        
        assertThat(SpendingHabit.EXTRAVAGANT.isWillingToSpend(starPlayerCost, salaryCap))
            .as("Extravagant owner easily affords $30M star ($340M budget)")
            .isTrue();
        
        // Scenario 2: Budget signing costs $5M
        double budgetPlayerCost = 5_000_000.0;
        
        for (SpendingHabit habit : SpendingHabit.values()) {
            assertThat(habit.isWillingToSpend(budgetPlayerCost, salaryCap))
                .as(habit.getHabit() + " owner should afford budget signing")
                .isTrue();
        }
    }
    
    @Test
    @DisplayName("🔤 Should have proper toString formatting")
    void testToString() {
        String miserlyString = SpendingHabit.MISERLY.toString();
        
        assertThat(miserlyString)
            .contains("Miserly")
            .contains("extremely averse to financial risk");
        
        System.out.println("Sample spending habit:");
        System.out.println(SpendingHabit.GENEROUS.toString());
    }
    
    @Test
    @DisplayName("📈 Should show spending differences between habits")
    void testSpendingDifferences() {
        double budget = 100_000_000.0;
        
        System.out.println("\n💰 Spending Analysis for $100M Budget:");
        System.out.println("─".repeat(60));
        
        for (SpendingHabit habit : SpendingHabit.values()) {
            double spending = habit.calculateSpending(budget);
            System.out.printf("%-15s: $%,.2f (%.0f%% of budget)%n", 
                habit.getHabit(), 
                spending, 
                habit.getSpendingMultiplier() * 100);
        }
        
        // Verify the spread
        double miserlySpending = SpendingHabit.MISERLY.calculateSpending(budget);
        double extravagantSpending = SpendingHabit.EXTRAVAGANT.calculateSpending(budget);
        
        assertThat(extravagantSpending)
            .as("Extravagant should spend ~2.83x more than Miserly")
            .isCloseTo(miserlySpending * 2.83, within(1_000_000.0));
    }
}
