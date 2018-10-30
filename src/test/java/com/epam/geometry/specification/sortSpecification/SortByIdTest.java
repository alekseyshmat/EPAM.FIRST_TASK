package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.creator.TetrahedronCreator;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortByIdTest {

    private Tetrahedron firstTetrahedron;
    private Tetrahedron secondTetrahedron;
    private TetrahedronCreator tetrahedronCreator;
    private SortById sortById;

    @BeforeClass
    public void setUp() {
        tetrahedronCreator = new TetrahedronCreator();
        sortById = new SortById();
    }

    @DataProvider(name = "dataForSortByIdTestPositive")
    public Object[][] dataForSortByIdTestPositive() {
        List<List<Double>> coordinatesList = new ArrayList<>();
        List<Double> listForFirstTetrahedron = Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0);
        List<Double> listForSecondTetrahedron = Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0);

        coordinatesList.add(listForFirstTetrahedron);
        coordinatesList.add(listForSecondTetrahedron);
        return new Object[][]{
                {
                        coordinatesList, //input List
                        -1     //input id
                }
        };
    }

    @Test(dataProvider = "dataForSortByIdTestPositive")
    public void sortByIdTestPositive(List<List<Double>> coordinatesListForTetrahedrons, int expectedResult) {
        firstTetrahedron = tetrahedronCreator.createTetrahedron(coordinatesListForTetrahedrons.get(0));
        secondTetrahedron = tetrahedronCreator.createTetrahedron(coordinatesListForTetrahedrons.get(1));

        int result = sortById.compare(firstTetrahedron, secondTetrahedron);

        Assert.assertEquals(result, expectedResult);
    }
}
