package com.epam.geometry.reader;

import com.epam.geometry.exception.ReadingFileException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataReaderTest {

    private DataReader dataReader;

    @BeforeClass
    public void setUp() {
        dataReader = new DataReader();
    }

    @DataProvider
    public static Object[][] dataForReadingLinesTestPositive() {
        final String VALID_PATH = "src/test/resources/test.txt";
        return new Object[][]{
                {
                        Arrays.asList("2.0 0.0f 0 0 -2 0 1 0 1 0 1 1",
                                "Ad.2 0 0 =0 2 0 1 0 1 0 1 1",
                                "2.00 0 0 0 2.00 0 1 0 1 0 1 00",
                                "2 0 0 0 2 0 1 0 1 0 1 1f",
                                "2 0 0 0 2 0 1 0 1 0 1 1",
                                "2 0 0 0 2 0 1 0 1 0 1 1 sd",
                                " 2 0   0 0 2 0 1 0 1 0 1 1"),
                        VALID_PATH
                }
        };
    }

    @Test(dataProvider = "dataForReadingLinesTestPositive")
    public void readingLinesTestPositive(List<String> expectedResult, String path) throws ReadingFileException {
        try {
            List<String> actual = dataReader.readingLines(path);
            Assert.assertEquals(actual, expectedResult);
        } catch (ReadingFileException | IOException e) {
            throw new ReadingFileException(e);
        }
    }
}
