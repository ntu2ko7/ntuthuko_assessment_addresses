package org.example.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CommonFactorClassTest {

    @Test
    public void testHighestCommonFactor() {
        int[] numbers = { 10, 20, 30 };
        CommonFactorClass commonFactorClass = new CommonFactorClass();
        int result = commonFactorClass.highestCommonFactor(numbers);
        assertEquals(10, result);
    }

    @Test
    public void testHighestCommonFactorIsOne() {
        int[] numbers = { 3, 5, 7 };
        CommonFactorClass commonFactorClass = new CommonFactorClass();
        int result = commonFactorClass.highestCommonFactor(numbers);
        assertEquals(1, result);
    }

    @Test
    public void testHighestCommonFactorUnordered() {
        int[] numbers = { 7, 5, 3 };
        CommonFactorClass commonFactorClass = new CommonFactorClass();
        int result = commonFactorClass.highestCommonFactor(numbers);
        assertEquals(1, result);
    }
}