package com.epam.geometry.generator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GeneratorTest {

    @Test
    public void generateIdPositiveTest() {
        long expectedId = 1;
        long actualId = Generator.generateId();
        Assert.assertEquals(actualId, expectedId);
    }
}


