package com.epam.action;

import com.epam.entity.Point;
import com.epam.entity.Tetrahedron;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;
    private final double DELTA = 0.01;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider(name = "calculateSidePositiveTest")
    public Object[][] dataForCalculateSidePositiveTest() {
        return new Object[][]{{new Point(0, 5, 0), new Point(0, 10, 0), 5},
                {new Point(2, -4, 7), new Point(-3, -1, -2), 10.72},
                {new Point(4, 5, 0), new Point(-1, 0, 6), 9.27},
                {new Point(0, 0, 0), new Point(0, 0, 0), 0}};
    }

    @Test(dataProvider = "calculateSidePositiveTest")
    public void calculateSidePositiveTest(Point firstPoint, Point secondPoint, final double expectedSide) {
        double actual = calculator.calculateSide(firstPoint, secondPoint);
        org.testng.Assert.assertEquals(expectedSide, actual, DELTA);
    }

    @DataProvider(name = "calculateAreaPositiveTest")
    public Object[][] dataForCalculateAreaPositiveTest() {
        return new Object[][]{{13.86, new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1))}};
    }

    @Test(dataProvider = "calculateAreaPositiveTest")
    public void calculateAreaPositiveTest(final double expectedArea, Tetrahedron tetrahedron) {
        double square = calculator.calculateArea(tetrahedron);
        Assert.assertEquals(expectedArea, square, DELTA);
    }

    @DataProvider(name = "calculateVolumePositiveTest")
    public Object[][] dataForCalculateVolumePositiveTest() {
        return new Object[][]{{3.26, new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1))}};
    }

    @Test(dataProvider = "calculateVolumePositiveTest")
    public void calculateVolumePositiveTest(final double expectedArea, Tetrahedron tetrahedron) {
        double square = calculator.calculateVolume(tetrahedron);
        Assert.assertEquals(expectedArea, square, DELTA);
    }


////    @Test
//    public void shouldReturnTrueHeight() {
//        double height = calculator.calculateHeight(TETRAHEDRON);
//        Assert.assertEquals(2.3, height, DELTA);
//    }

}
