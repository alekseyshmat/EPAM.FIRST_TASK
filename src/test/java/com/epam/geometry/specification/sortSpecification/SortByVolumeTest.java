package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.creator.TetrahedronCreator;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByVolumeTest {

    private SortByVolume sortByVolume;
    private Tetrahedron firstTetrahedron;
    private Tetrahedron secondTetrahedron;
    private TetrahedronCreator tetrahedronCreator;

    @BeforeClass
    public void setUp() {
        tetrahedronCreator = new TetrahedronCreator();
        sortByVolume = new SortByVolume();
    }

    @DataProvider(name = "dataForSortByVolumeTestPositive")
    public Object[][] dataForSortByVolumeTestPositive() {
        return new Object[][]{
                {
                        Arrays.asList(-1.0, 2.0, 3.0, 2.0, 2.0, 1.0, 2.23, 2.0, 4.6, 1.08, -0.94, 2.87),   //input first
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),        //input second
                        1                                                                             //expected result
                },
                {
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                        0
                },
                {
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                        Arrays.asList(-1.0, 2.0, 3.0, 2.0, 2.0, 1.0, 2.23, 2.0, 4.6, 1.08, -0.94, 2.87),
                        -1
                }
        };
    }

    @Test(dataProvider = "dataForSortByVolumeTestPositive")
    public void sortByVolumeTestPositive(List<Double> firstList, List<Double> secondList, int expectedResult) {
        firstTetrahedron = tetrahedronCreator.createTetrahedron(firstList);
        secondTetrahedron = tetrahedronCreator.createTetrahedron(secondList);

        int result = sortByVolume.compare(firstTetrahedron, secondTetrahedron);

        Assert.assertEquals(result, expectedResult);
    }
}
