package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSpecificationTest {

    private static final Tetrahedron TETRAHEDRON = new Tetrahedron( // input object
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    @Test
    public void searchByIdPositiveTest() {
        SearchById searchById = new SearchById(1);

        boolean result = searchById.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }

    @Test
    public void searchByRangeOfAreaPositiveTest() {
        SearchByRangeOfArea searchByRangeOfArea = new SearchByRangeOfArea(1, 15);

        boolean result = searchByRangeOfArea.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }

    @Test
    public void searchByRangeOfVolumePositiveTest() {
        SearchByRangeOfVolume searchByRangeOfVolume = new SearchByRangeOfVolume(1, 4);

        boolean result = searchByRangeOfVolume.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }

    @Test
    public void searchByGreaterVolumePositiveTest() {
        SearchVolumeGreater searchVolumeGreater = new SearchVolumeGreater(3);

        boolean result = searchVolumeGreater.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }
}
