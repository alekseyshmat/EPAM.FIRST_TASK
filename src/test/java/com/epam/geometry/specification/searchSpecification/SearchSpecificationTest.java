package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSpecificationTest {

    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVETEEN = 15;

    private SearchVolumeGreater searchVolumeGreater;
    private SearchById searchById;
    private SearchByRangeOfArea searchByRangeOfArea;
    private SearchByRangeOfVolume searchByRangeOfVolume;

    private static final Tetrahedron TETRAHEDRON = new Tetrahedron( // input object
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    @Test
    public void searchByIdPositiveTest() {
        searchById = new SearchById(ONE);

        boolean result = searchById.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }

    @Test
    public void searchByRangeOfAreaPositiveTest() {
        searchByRangeOfArea = new SearchByRangeOfArea(ONE, FIVETEEN);

        boolean result = searchByRangeOfArea.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }

    @Test
    public void searchByRangeOfVolumePositiveTest() {
        searchByRangeOfVolume = new SearchByRangeOfVolume(ONE, FOUR);

        boolean result = searchByRangeOfVolume.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }

    @Test
    public void searchByGreaterVolumePositiveTest() {
        searchVolumeGreater = new SearchVolumeGreater(THREE);

        boolean result = searchVolumeGreater.specified(TETRAHEDRON);

        Assert.assertTrue(result);
    }
}
