package com.epam.geometry.repository;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import com.epam.geometry.specification.searchSpecification.SearchById;
import com.epam.geometry.specification.searchSpecification.SearchByRangeOfArea;
import com.epam.geometry.specification.searchSpecification.SearchByRangeOfVolume;
import com.epam.geometry.specification.searchSpecification.SearchVolumeGreater;
import com.epam.geometry.specification.sortSpecification.SortById;
import com.epam.geometry.specification.sortSpecification.SortByLengthOfSide;
import com.epam.geometry.specification.sortSpecification.SortByVolume;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TetrahedronRepositoryTest {
    private static final Tetrahedron FIRST_TETRAHEDRON = new Tetrahedron(
            new Point(-1, 2, 3),
            new Point(2, 2, 1),
            new Point(2.23, 2, 4.6),
            new Point(1.08, -0.94, 2.87)
    );

    private static final Tetrahedron SECOND_TETRAHEDRON = new Tetrahedron(
            new Point(-2, 0, -1),
            new Point(0, -3, -1),
            new Point(1.6, 0.23, -1),
            new Point(-0.13, -0.92, 1.94)
    );

    private static final Tetrahedron THIRD_TETRAHEDRON = new Tetrahedron(
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    private static final Tetrahedron FOURTH_TETRAHEDRON = new Tetrahedron(
            new Point(3, -1, 0),
            new Point(3, 1, 4),
            new Point(3, 3.46, 0.27),
            new Point(6.65, 1.16, 1.42)
    );

    private static final Tetrahedron FIFTH_TETRAHEDRON = new Tetrahedron(
            new Point(-2, 0, 1),
            new Point(3, 1, 4),
            new Point(-2.2, 1, 6.83),
            new Point(-0.85, 5.4, 3.11)
    );

    private Repository<Tetrahedron> repository;

    @BeforeClass
    public void setUp() {
        repository = new TetrahedronRepository();
        repository.add(FIRST_TETRAHEDRON);
        repository.add(FOURTH_TETRAHEDRON);
        repository.add(FIFTH_TETRAHEDRON);
        repository.add(SECOND_TETRAHEDRON);
        repository.add(THIRD_TETRAHEDRON);
    }

    @Test
    public void findByIdPositiveTest() {
        List<Tetrahedron> resultList = repository.findBy(new SearchById(3));
        List<Tetrahedron> expectedResult = Arrays.asList(THIRD_TETRAHEDRON);

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void findByRangeOfAreaPositiveTest() {
        List<Tetrahedron> resultList = repository.findBy(new SearchByRangeOfArea(30, 65));
        List<Tetrahedron> expectedResult = Arrays.asList(FOURTH_TETRAHEDRON, FIFTH_TETRAHEDRON);

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void findByRangeOfVolumePositiveTest() {
        List<Tetrahedron> resultList = repository.findBy(new SearchByRangeOfVolume(6, 15));
        List<Tetrahedron> expectedResult = Arrays.asList(FIRST_TETRAHEDRON, SECOND_TETRAHEDRON, FOURTH_TETRAHEDRON);

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void findByVolumeGreaterPositiveTest() {
        List<Tetrahedron> resultList = repository.findBy(new SearchVolumeGreater(25));
        List<Tetrahedron> expectedResult = Arrays.asList(FIFTH_TETRAHEDRON);

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void sortByIdPositiveTest() {
        List<Tetrahedron> resultList = repository.sortBy(new SortById());
        List<Tetrahedron> expectedResult =
                Arrays.asList(FIRST_TETRAHEDRON,
                        SECOND_TETRAHEDRON,
                        THIRD_TETRAHEDRON,
                        FOURTH_TETRAHEDRON,
                        FIFTH_TETRAHEDRON
                );

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void sortByLengthOfSidePositiveTest() {
        List<Tetrahedron> resultList = repository.sortBy(new SortByLengthOfSide());
        List<Tetrahedron> expectedResult =
                Arrays.asList(THIRD_TETRAHEDRON,
                        FIRST_TETRAHEDRON,
                        SECOND_TETRAHEDRON,
                        FOURTH_TETRAHEDRON,
                        FIFTH_TETRAHEDRON
                );

        Assert.assertEquals(resultList, expectedResult);
    }

    @Test
    public void sortByVolumePositiveTest() {
        List<Tetrahedron> resultList = repository.sortBy(new SortByVolume());
        List<Tetrahedron> expectedResult =
                Arrays.asList(THIRD_TETRAHEDRON,
                        FIRST_TETRAHEDRON,
                        SECOND_TETRAHEDRON,
                        FOURTH_TETRAHEDRON,
                        FIFTH_TETRAHEDRON
                );

        Assert.assertEquals(resultList, expectedResult);
    }
}
