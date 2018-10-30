package com.epam.geometry.generator;


public class Generator {
    private static long MIN_VALUE = 1L;

    public static long generate() {
        return MIN_VALUE++;
    }
}
