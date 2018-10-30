package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByRangeOfVolumeTest {

    private SearchByRangeOfVolume searchByRangeOfVolume;

    private Tetrahedron tetrahedron = new Tetrahedron( // input object
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    @Test
    public void searchByRangeOfVolumePositiveTest() {
        searchByRangeOfVolume = new SearchByRangeOfVolume(1, 4);

        boolean result = searchByRangeOfVolume.specified(tetrahedron);

        Assert.assertTrue(result);
    }
}
