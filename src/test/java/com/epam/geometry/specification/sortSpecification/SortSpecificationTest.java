package com.epam.geometry.specification.sortSpecification;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortSpecificationTest {

    private static final int LARGER = 1;
    private static final int LESS = -1;

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
        SortById sortById = new SortById();

        int result = sortById.compare(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON);

        Assert.assertEquals(result, LESS);
    }

    @Test
    public void sortByLengthOfSideTestPositive() {
        SortByLengthOfSide sortByLengthOfSide = new SortByLengthOfSide();

        int result = sortByLengthOfSide.compare(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON);

        Assert.assertEquals(result, LARGER);
    }

    @Test
    public void sortByVolumeTestPositive() {
        SortByVolume sortByVolume = new SortByVolume();

        int result = sortByVolume.compare(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON);

        Assert.assertEquals(result, LARGER);
    }
}
