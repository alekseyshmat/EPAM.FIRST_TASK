package com.epam.validator;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidationTest {
    private Validation validation;

    @BeforeClass
    public void setUp() {
        validation = new Validation();
    }

    @DataProvider(name = "dataForIsValidPositiveTest")
    public Object[][] dataForIsValidPositiveTest() {
        return new Object[][]{{"2 0 0 0 2 0 1 0 1 0 1 1"},
                {"-1 2 3 2 2 1 2.23 2 4.6 1.08 -0.94 2.87"},
                {"-2 0 -1 0 -3 -1 1.6 0.23 -1 -0.13 -0.92 1.94"}};
    }

    @Test(dataProvider = "dataForIsValidPositiveTest")
    public void isValidPositiveTest(String lines) {
        boolean actual = validation.isValid(lines);
        Assert.assertTrue(actual);
    }

    @DataProvider(name = "dataForIsValidNegativeTest")
    public Object[][] dataForIsValidNegativeTest() {
        return new Object[][]{{"2 0 0 0 2 0 1 0 1 0 1 1 2.0 8.96 45.36 78.36"},
                {"2 0 0 0 2"},
                {"-1 2 3 2 2 1 2.23 2 4.6 1.08 -0.94 2.87d"}};
    }

    @Test(dataProvider = "dataForIsValidNegativeTest")
    public void isValidNegativeTest(String lines) {
        boolean actual = validation.isValid(lines);
        Assert.assertFalse(actual);
    }
}
