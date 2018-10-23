package com.epam.reader;

import com.epam.exception.ReadingFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderTest {

    private Reader reader;

    @BeforeClass
    public void setUp() {
        reader = new Reader();
    }

    @DataProvider
    public static Object[][] dataForReadingLinesTestPositive() {
        final String FIRST_PATH = "src/test/resources/test.txt";
        return new Object[][]{{FIRST_PATH, Arrays.asList("2.0 0.0f 0 0 -2 0 1 0 1 0 1 1",
                "Ad.2 0 0 =0 2 0 1 0 1 0 1 1",
                "2.00 0 0 0 2.00 0 1 0 1 0 1 00",
                "2 0 0 0 2 0 1 0 1 0 1 1f",
                "2 0 0 0 2 0 1 0 1 0 1 1",
                "2 0 0 0 2 0 1 0 1 0 1 1 sd",
                " 2 0   0 0 2 0 1 0 1 0 1 1")}};
    }

    @Test(dataProvider = "dataForReadingLinesTestPositive")
    public void readingLinesTestPositive(String path, List<String> expectedResult) {
        List actual = new ArrayList<>();
        try {
            actual = reader.readingLines(path);
        } catch (ReadingFileException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(actual, expectedResult);
    }
}
