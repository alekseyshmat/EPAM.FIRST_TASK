package com.epam.geometry.action;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CalculatorTest {

    private static final Tetrahedron FIRST_TETRAHEDRON = new Tetrahedron(
            new Point(2, 0, 0),
            new Point(0, 2, 0),
            new Point(1, 0, 1),
            new Point(0, 1, 1)
    );

    private static final Tetrahedron SECOND_TETRAHEDRON = new Tetrahedron(
            new Point(-1, 2, 3),
            new Point(2, 2, 1),
            new Point(2.23, 2, 4.6),
            new Point(1.08, -0.94, 2.87)
    );

    private static final Tetrahedron THIRD_TETRAHEDRON = new Tetrahedron(
            new Point(-2, 0, -1),
            new Point(0, -3, -1),
            new Point(1.6, 0.23, -1),
            new Point(-0.13, -0.92, 1.94)
    );

    private static final Tetrahedron FORTH_TETRAHEDRON = new Tetrahedron(
            new Point(3, -1, 0),
            new Point(3, 1, 4),
            new Point(3, 3.46, 0.27),
            new Point(6.65, 1.16, 1.42)
    );

    private static final Tetrahedron FIFTH_TETRAHEDRON = new Tetrahedron(
            new Point(-1, 3, 3),
            new Point(-4, 3, 1),
            new Point(-4.2, 3, 4.6),
            new Point(-3.1, 0.1, 2.9)
    );

    private static final Tetrahedron SIXTH_TETRAHEDRON = new Tetrahedron(
            new Point(-2, 0, 1),
            new Point(3, 1, 4),
            new Point(-2.2, 1, 6.83),
            new Point(-0.85, 5.4, 3.11)
    );

    private static final double DELTA = 0.01;

    private Calculator calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider(name = "calculateAreaPositiveTest")
    public Object[][] dataForCalculateAreaPositiveTest() {
        return new Object[][]{
                {
                        FIRST_TETRAHEDRON,  // input object
                        13.86              // expected area
                },
                {
                        SECOND_TETRAHEDRON,
                        22.51
                }};
    }

    @DataProvider(name = "calculateVolumePositiveTest")
    public Object[][] dataForCalculateVolumePositiveTest() {
        return new Object[][]{
                {
                        FIRST_TETRAHEDRON,  // input object
                        3.26            //expected volume
                },
                {
                        SECOND_TETRAHEDRON,
                        6.76
                }};
    }

    @DataProvider(name = "calculateHeightPositiveTest")
    public Object[][] dataForCalculateHeightPositiveTest() {
        return new Object[][]{
                {
                        FIRST_TETRAHEDRON,  // input object
                        2.3                //expected height
                },
                {
                        THIRD_TETRAHEDRON,
                        2.94
                }};
    }

    @DataProvider(name = "calculateSmallHeightPositiveTest")
    public Object[][] dataForCalculateSmallHeightPositiveTest() {
        return new Object[][]{
                {
                        THIRD_TETRAHEDRON,      // input object
                        1.94                //expected small height
                },
                {
                        FORTH_TETRAHEDRON,
                        0.65
                },
                {
                        SECOND_TETRAHEDRON,
                        0.94
                },
                {
                        FIFTH_TETRAHEDRON,
                        0.05
                },
                {
                        SIXTH_TETRAHEDRON,
                        0
                }};
    }

    @DataProvider(name = "calculateVolumeRatioPositiveTest")
    public Object[][] dataForCalculateVolumeRatioPositiveTest() {
        return new Object[][]{
                {
                        THIRD_TETRAHEDRON,
                        3.3                 //expected volume ratio
                },
                {
                        FORTH_TETRAHEDRON,
                        14
                },
                {
                        SECOND_TETRAHEDRON,
                        7.52
                },
                {
                        FIFTH_TETRAHEDRON,
                        136.64
                },
                {
                        SIXTH_TETRAHEDRON,
                        0
                }};
    }

    @Test(dataProvider = "calculateAreaPositiveTest")
    public void calculateAreaPositiveTest(Tetrahedron tetrahedron, final double expectedArea) {
        double actual = calculator.calculateArea(tetrahedron);

        Assert.assertEquals(actual, expectedArea, DELTA);
    }

    @Test(dataProvider = "calculateVolumePositiveTest")
    public void calculateVolumePositiveTest(Tetrahedron tetrahedron, final double expectedArea) {
        double actual = calculator.calculateVolume(tetrahedron);

        Assert.assertEquals(actual, expectedArea, DELTA);
    }

    @Test(dataProvider = "calculateHeightPositiveTest")
    public void shouldReturnTrueHeight(Tetrahedron tetrahedron, final double expectedHeight) {
        double actual  = calculator.calculateHeight(tetrahedron);

        Assert.assertEquals(actual, expectedHeight, DELTA);
    }

    @Test(dataProvider = "calculateSmallHeightPositiveTest")
    public void calculateSmallHeightPositiveTest(Tetrahedron tetrahedron, final double expectedHeight) {
        double actual = calculator.calculateHeightOfSmallPyramid(tetrahedron);

        Assert.assertEquals(actual, expectedHeight, DELTA);
    }

    @Test(dataProvider = "calculateVolumeRatioPositiveTest")
    public void calculateVolumeRatioPositiveTest(Tetrahedron tetrahedron, final double expectedRatio) {
        double actual = calculator.calculateVolumeRatio(tetrahedron);

        Assert.assertEquals(actual, expectedRatio, DELTA);
    }
}
