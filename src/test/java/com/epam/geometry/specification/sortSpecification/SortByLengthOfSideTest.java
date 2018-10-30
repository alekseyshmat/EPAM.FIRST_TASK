package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.creator.TetrahedronCreator;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SortByLengthOfSideTest {

    private Tetrahedron firstTetrahedron;
    private Tetrahedron secondTetrahedron;
    private TetrahedronCreator tetrahedronCreator;
    private SortByLengthOfSide sortByLengthOfSide;

    @BeforeClass
    public void setUp() {
        tetrahedronCreator = new TetrahedronCreator();
        sortByLengthOfSide = new SortByLengthOfSide();
    }

    @DataProvider(name = "dataForSortByLengthOfSideTestPositive")
    public Object[][] dataForSortByLengthOfSideTestPositive() {
        return new Object[][]{
                {
                        Arrays.asList(3.0, -1.0, 0.0, 3.0, 1.0, 4.0, 3.0, 3.46, 0.27, 6.65, 1.16, 1.42), //input first
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),      //input second
                        1                                                                             //expected result
                },
                {
                        Arrays.asList(3.0, -1.0, 0.0, 3.0, 1.0, 4.0, 3.0, 3.46, 0.27, 6.65, 1.16, 1.42),
                        Arrays.asList(3.0, -1.0, 0.0, 3.0, 1.0, 4.0, 3.0, 3.46, 0.27, 6.65, 1.16, 1.42),
                        0
                },
                {
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                        Arrays.asList(3.0, -1.0, 0.0, 3.0, 1.0, 4.0, 3.0, 3.46, 0.27, 6.65, 1.16, 1.42),
                        -1
                }
        };
    }

    @Test(dataProvider = "dataForSortByLengthOfSideTestPositive")
    public void sortByLengthOfSideTestPositive(List<Double> first, List<Double> second, int expectedResult) {
        firstTetrahedron = tetrahedronCreator.createTetrahedron(first);
        secondTetrahedron = tetrahedronCreator.createTetrahedron(second);

        int result = sortByLengthOfSide.compare(firstTetrahedron, secondTetrahedron);

        Assert.assertEquals(result, expectedResult);
    }
}
