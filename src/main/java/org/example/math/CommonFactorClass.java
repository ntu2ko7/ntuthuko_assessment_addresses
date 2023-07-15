package org.example.math;

import java.util.Arrays;

public class CommonFactorClass {

    public int highestCommonFactor(int[] numbers) {
        return Arrays.stream(numbers).reduce(0, this::highestCommonFactor);
    }

    /**
     * divide smaller number by bigger number taking the remainder (mod) until remainder is (Euclid’s algorithm)
     * */
    public int highestCommonFactor(int a, int b) {
        return b == 0 ? a : highestCommonFactor(b, a % b);
    }
}
