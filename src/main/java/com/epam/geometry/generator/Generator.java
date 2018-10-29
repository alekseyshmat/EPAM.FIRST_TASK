package com.epam.geometry.generator;

import java.util.Random;

public class Generator {
    private static Random random = new Random();

    private static final long MIN_VALUE = 1L;
    private static final long MAX_VALUE = 23456789L;

    public static long generate() {
        return MIN_VALUE + (random.nextLong() * (MAX_VALUE - MIN_VALUE));
    }
}
