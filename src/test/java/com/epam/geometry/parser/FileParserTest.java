package com.epam.geometry.parser;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileParserTest {
    private FileParser fileParser;

    @BeforeClass
    public void setUp() {
        fileParser = new FileParser();
    }

    @DataProvider(name = "dataForParsingLinesTestPositive")
    public Object[][] dataForParsingLinesTestPositive() {
        return new Object[][]{{Collections.singletonList("2 0 0 0 2 0 1 0 1 0 1 1"), Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0)}};
    }

    @Test(dataProvider = "dataForParsingLinesTestPositive")
    public void parsingLinesTestPositive(List<String> lines, List<Double> expectedResult) {
        List actual = fileParser.parsingLines(lines);
        Assert.assertEquals(actual, expectedResult);
    }

    @DataProvider(name = "dataForParsingLinesTestNegative")
    public Object[][] dataForParsingLinesTestNegative() {
        return new Object[][]{{Collections.singletonList(("2.0 0.0f 0 0 -2 0 1 0 1 0 1 1 Ad.2 0 0 =0 2 0 1 0 1 0 1 1")), Collections.emptyList()}};
    }

    @Test(dataProvider = "dataForParsingLinesTestNegative")
    public void parsingLinesTestNegative(List<String> lines, List<Double> expectedResult) {
        List actual = fileParser.parsingLines(lines);
        Assert.assertEquals(actual, expectedResult);
    }
}
