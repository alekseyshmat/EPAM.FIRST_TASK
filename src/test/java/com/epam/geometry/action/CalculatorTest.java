package com.epam.geometry.action;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
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

    @DataProvider(name = "calculateAreaPositiveTest")
    public Object[][] dataForCalculateAreaPositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron( // input object
                                new Point(2, 0, 0),
                                new Point(0, 2, 0),
                                new Point(1, 0, 1),
                                new Point(0, 1, 1)
                        ),
                        13.86              // expected area
                },
                {
                        new Tetrahedron(
                                new Point(-1, 2, 3),
                                new Point(2, 2, 1),
                                new Point(2.23, 2, 4.6),
                                new Point(1.08, -0.94, 2.87)
                        ),
                        22.51
                }};
    }

    @DataProvider(name = "calculateVolumePositiveTest")
    public Object[][] dataForCalculateVolumePositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron( //input object
                                new Point(2, 0, 0),
                                new Point(0, 2, 0),
                                new Point(1, 0, 1),
                                new Point(0, 1, 1)
                        ),
                        3.26            //expected volume
                },
                {
                        new Tetrahedron(
                                new Point(-1, 2, 3),
                                new Point(2, 2, 1),
                                new Point(2.23, 2, 4.6),
                                new Point(1.08, -0.94, 2.87)
                        ),
                        6.76
                }};
    }

    @DataProvider(name = "calculateHeightPositiveTest")
    public Object[][] dataForCalculateHeightPositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron(   //input object
                                new Point(2, 0, 0),
                                new Point(0, 2, 0),
                                new Point(1, 0, 1),
                                new Point(0, 1, 1)
                        ),
                        2.3                //expected height
                },
                {
                        new Tetrahedron(
                                new Point(-2, 0, -1),
                                new Point(0, -3, -1),
                                new Point(1.6, 0.23, -1),
                                new Point(-0.13, -0.92, 1.94)
                        ),
                        2.94
                }};
    }

    @DataProvider(name = "calculateSmallHeightPositiveTest")
    public Object[][] dataForCalculateSmallHeightPositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron(    //input object
                                new Point(-2, 0, -1),
                                new Point(0, -3, -1),
                                new Point(1.6, 0.23, -1),
                                new Point(-0.13, -0.92, 1.94)
                        ),
                        1.94                //expected small height
                },
                {
                        new Tetrahedron(
                                new Point(3, -1, 0),
                                new Point(3, 1, 4),
                                new Point(3, 3.46, 0.27),
                                new Point(6.65, 1.16, 1.42)
                        ),
                        0.65
                },
                {
                        new Tetrahedron(
                                new Point(-1, 2, 3),
                                new Point(2, 2, 1),
                                new Point(2.23, 2, 4.6),
                                new Point(1.08, -0.94, 2.87)
                        ),
                        0.94
                },
                {
                        new Tetrahedron(
                                new Point(-1, 3, 3),
                                new Point(-4, 3, 1),
                                new Point(-4.2, 3, 4.6),
                                new Point(-3.1, 0.1, 2.9)
                        ),
                        0.05
                },
                {
                        new Tetrahedron(
                                new Point(-2, 0, 1),
                                new Point(3, 1, 4),
                                new Point(-2.2, 1, 6.83),
                                new Point(-0.85, 5.4, 3.11)
                        ),
                        0
                }};
    }

    @DataProvider(name = "calculateVolumeRatioPositiveTest")
    public Object[][] dataForCalculateVolumeRatioPositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron(      //input object
                                new Point(-2, 0, -1),
                                new Point(0, -3, -1),
                                new Point(1.6, 0.23, -1),
                                new Point(-0.13, -0.92, 1.94)
                        ),
                        3.3                 //expected volume ratio
                },
                {
                        new Tetrahedron(
                                new Point(3, -1, 0),
                                new Point(3, 1, 4),
                                new Point(3, 3.46, 0.27),
                                new Point(6.65, 1.16, 1.42)
                        ),
                        14
                },
                {
                        new Tetrahedron(
                                new Point(-1, 2, 3),
                                new Point(2, 2, 1),
                                new Point(2.23, 2, 4.6),
                                new Point(1.08, -0.94, 2.87)
                        ),
                        7.52
                },
                {
                        new Tetrahedron(
                                new Point(-1, 3, 3),
                                new Point(-4, 3, 1),
                                new Point(4.2, 3, 4.6),
                                new Point(-3.1, 6, 2.9)
                        ),
                        136.64
                },
                {
                        new Tetrahedron(
                                new Point(-2, 0, 1),
                                new Point(3, 1, 4),
                                new Point(-2.2, 1, 6.83),
                                new Point(-0.85, 5.4, 3.11)
                        ),
                        0
                }};
    }

    @Test(dataProvider = "calculateAreaPositiveTest")
    public void calculateAreaPositiveTest(Tetrahedron tetrahedron, final double expectedArea) {
        double square = calculator.calculateArea(tetrahedron);
        Assert.assertEquals(square, expectedArea, DELTA);
    }

    @Test(dataProvider = "calculateVolumePositiveTest")
    public void calculateVolumePositiveTest(Tetrahedron tetrahedron, final double expectedArea) {
        double square = calculator.calculateVolume(tetrahedron);
        Assert.assertEquals(square, expectedArea, DELTA);
    }

    @Test(dataProvider = "calculateHeightPositiveTest")
    public void shouldReturnTrueHeight(Tetrahedron tetrahedron, final double expectedHeight) {
        double height = calculator.calculateHeight(tetrahedron);
        Assert.assertEquals(height, expectedHeight, DELTA);
    }

    @Test(dataProvider = "calculateSmallHeightPositiveTest")
    public void calculateSmallHeightPositiveTest(Tetrahedron tetrahedron, final double expectedHeight) {
        double height = calculator.calculateHeightOfSmallPyramid(tetrahedron);
        Assert.assertEquals(height, expectedHeight, DELTA);
    }

    @Test(dataProvider = "calculateVolumeRatioPositiveTest")
    public void calculateVolumeRatioPositiveTest(Tetrahedron tetrahedron, final double expectedRatio) {
        double ratio = calculator.calculateVolumeRatio(tetrahedron);
        Assert.assertEquals(ratio, expectedRatio, DELTA);
    }
}
