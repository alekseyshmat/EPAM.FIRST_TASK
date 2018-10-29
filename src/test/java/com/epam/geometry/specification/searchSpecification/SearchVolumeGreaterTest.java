package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchVolumeGreaterTest  {

    private Tetrahedron tetrahedron = new Tetrahedron( // input object
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    private SearchVolumeGreater searchVolumeGreater = new SearchVolumeGreater(3);

    @Test
    public void searchByRangeOfAreaPositiveTest() {

        boolean result = searchVolumeGreater.specified(tetrahedron);

        Assert.assertTrue(result);
    }
}
