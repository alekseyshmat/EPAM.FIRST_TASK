package com.epam.reader;

import com.epam.exception.ReadingFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ReaderTest {

    private Reader reader;

    @BeforeClass
    public void setUp() {
        reader = new Reader();
    }

    @DataProvider
    public static Object[][] dataForReadingLinesTestPositive() {
        String path = "src/test/resources/test.txt";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("2 0 0 0 2 0 1 0 1 0 1 1");
        return new Object[][]{{path, expectedResult}};
    }

    @Test(dataProvider = "dataForReadingLinesTestPositive")
    public void readingLinesTestPositive(String path, List<String> expectedResult) {
        List actual = new ArrayList<>();
        try {
            actual = reader.readingLines(path);
        } catch (ReadingFileException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expectedResult, actual);
    }
}
