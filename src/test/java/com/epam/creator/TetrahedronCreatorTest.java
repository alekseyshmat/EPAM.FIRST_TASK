package com.epam.creator;

import com.epam.exception.ReadingFileException;
import com.epam.reader.Reader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TetrahedronCreatorTest {

    private TetrahedronCreator tetrahedronCreator;
    private List<Double> result;
    @BeforeClass
    public void setUp() {
        tetrahedronCreator = new TetrahedronCreator(result);
    }

    @DataProvider
    public static Object[][] dataForCreateTetrahedronTestPositive() {
        String path = "src/test/resources/test.txt";
        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("2 0 0 0 2 0 1 0 1 0 1 1");
        return new Object[][]{{path, expectedResult}};
    }

    @Test(dataProvider = "dataForCreateTetrahedronTestPositive")
    public void createTetrahedronTestPositive(List<String> expectedResult) {
        List actual = new ArrayList<>();
      /*  try {
            actual = tetrahedronCreator.createTetrahedron();
        } catch (ReadingFileException e) {
            e.printStackTrace();
        }*/
        Assert.assertEquals(expectedResult, actual);
    }
}
