package com.epam.parser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ParserFileTest {
    private ParserFile parserFile;

    @BeforeClass
    public void setUp() {
        parserFile = new ParserFile();
    }

    @DataProvider(name = "dataForParsingLinesTestPositive")
    public Object[][] dataForParsingLinesTestPositive() {
        return new Object[][]{{Collections.singletonList("2 0 0 0 2 0 1 0 1 0 1 1"), Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0)}};
    }

    @Test(dataProvider = "dataForParsingLinesTestPositive")
    public void parsingLinesTestPositive(List<String> lines, List<Double> expectedResult) {
        List actual = parserFile.parsingLines(lines);
        Assert.assertEquals(actual, expectedResult);
    }

    @DataProvider(name = "dataForParsingLinesTestNegative")
    public Object[][] dataForParsingLinesTestNegative() {
        return new Object[][]{{Collections.singletonList(("2.0 0.0f 0 0 -2 0 1 0 1 0 1 1 Ad.2 0 0 =0 2 0 1 0 1 0 1 1")), Collections.emptyList()}};
    }

    @Test(dataProvider = "dataForParsingLinesTestNegative")
    public void parsingLinesTestNegative(List<String> lines, List<Double> expectedResult) {
        List actual = parserFile.parsingLines(lines);
        Assert.assertEquals(actual, expectedResult);
    }
}
