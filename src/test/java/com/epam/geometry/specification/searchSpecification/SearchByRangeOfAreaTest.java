package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByRangeOfAreaTest {

    private Tetrahedron tetrahedron = new Tetrahedron( // input object
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    private SearchByRangeOfArea searchByRangeOfArea = new SearchByRangeOfArea(1, 25);

    @Test
    public void searchByRangeOfAreaPositiveTest() {

        boolean result = searchByRangeOfArea.specified(tetrahedron);

        Assert.assertTrue(result);
    }
}
