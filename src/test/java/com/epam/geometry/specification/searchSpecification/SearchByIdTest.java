package com.epam.geometry.specification.searchSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByIdTest {

    private Tetrahedron tetrahedron = new Tetrahedron( // input object
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    private static final long ID  = 0;
    private SearchById searchById = new SearchById(ID);



    @Test
    public void searchByIdPositiveTest(){

        boolean result = searchById.specified(tetrahedron);

        Assert.assertTrue(result);
    }
}
