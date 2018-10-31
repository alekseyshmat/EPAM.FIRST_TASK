package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortSpecificationTest {

    private static final int ONE = 1;
    private static final int MINUS_ONE = -1;

    private SortByLengthOfSide sortByLengthOfSide;
    private SortById sortById;
    private SortByVolume sortByVolume;

    private static final Tetrahedron FIRST_TETRAHEDRON = new Tetrahedron(           //input object
            new Point(3, -1, 0),
            new Point(3, 1, 4),
            new Point(3, 3.46, 0.27),
            new Point(6.65, 1.16, 1.42)
    );

    private static final Tetrahedron SECOND_TETRAHEDRON = new Tetrahedron(
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    @Test
    public void sortByIdTestPositive() {
        sortById = new SortById();

        int result = sortById.compare(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON);

        Assert.assertEquals(result, MINUS_ONE);
    }

    @Test
    public void sortByLengthOfSideTestPositive() {
        sortByLengthOfSide = new SortByLengthOfSide();

        int result = sortByLengthOfSide.compare(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON);

        Assert.assertEquals(result, ONE);
    }

    @Test
    public void sortByVolumeTestPositive() {
        sortByVolume = new SortByVolume();

        int result = sortByVolume.compare(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON);

        Assert.assertEquals(result, ONE);
    }
}
