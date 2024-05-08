package org.projects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MortgageCalculatorTest {

    @Test
    void testCalculateMortgage30() {
        assertEquals(472.81, MortgageCalculator.calculateMortgage(100000, 3.92F, 30));
    }

    @Test
    void testCalculateMortgage10() {
        assertEquals(1008.65, MortgageCalculator.calculateMortgage(100000, 3.92F, 10));
    }
}