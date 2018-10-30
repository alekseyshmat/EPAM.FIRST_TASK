package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.creator.TetrahedronCreator;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class SearchByIdTest {

    private Tetrahedron tetrahedron;
    private TetrahedronCreator tetrahedronCreator;
    private SearchById searchById;

    @BeforeClass
    public void setUp() {
        tetrahedronCreator = new TetrahedronCreator();
    }

    @DataProvider(name = "dataForSearchByIdTestPositive")
    public Object[][] dataForSearchByIdTestPositive() {
        return new Object[][]{
                {
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                        1
                },
                {
                        Arrays.asList(2.0, 0.0, 0.0, 0.0, 2.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0),
                        2
                }
        };
    }

    @Test(dataProvider = "dataForSearchByIdTestPositive")
    public void searchByIdPositiveTest(List<Double> resultList, long id) {
        tetrahedron = tetrahedronCreator.createTetrahedron(resultList);
        searchById = new SearchById(id);

        boolean result = searchById.specified(tetrahedron);

        Assert.assertTrue(result);
    }
}
