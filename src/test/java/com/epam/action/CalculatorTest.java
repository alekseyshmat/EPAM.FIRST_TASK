package com.epam.action;

import com.epam.entity.Point;
import com.epam.entity.Tetrahedron;
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
        return new Object[][]{{13.86, new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1))}};
    }

    @Test(dataProvider = "calculateAreaPositiveTest")
    public void calculateAreaPositiveTest(final double expectedArea, Tetrahedron tetrahedron) {
        double square = calculator.calculateArea(tetrahedron);
        Assert.assertEquals(square, expectedArea, DELTA);
    }

    @DataProvider(name = "calculateVolumePositiveTest")
    public Object[][] dataForCalculateVolumePositiveTest() {
        return new Object[][]{{3.26, new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1))}};
    }

    @Test(dataProvider = "calculateVolumePositiveTest")
    public void calculateVolumePositiveTest(final double expectedArea, Tetrahedron tetrahedron) {
        double square = calculator.calculateVolume(tetrahedron);
        Assert.assertEquals(square, expectedArea, DELTA);
    }

    @DataProvider(name = "calculateHeightPositiveTest")
    public Object[][] dataForCalculateHeightPositiveTest() {
        return new Object[][]{{2.3, new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1))},
                {2.94, new Tetrahedron(new Point(-2, 0, -1), new Point(0, -3, -1), new Point(1.6, 0.23, -1), new Point(-0.13, -0.92, 1.94))}};
    }


    @Test(dataProvider = "calculateHeightPositiveTest")
    public void shouldReturnTrueHeight(final double expectedHeight, Tetrahedron tetrahedron) {
        double height = calculator.calculateHeight(tetrahedron);
        Assert.assertEquals(height, expectedHeight, DELTA);
    }

    @DataProvider(name = "calculateSmallHeightPositiveTest")
    public Object[][] dataForCalculateSmallHeightPositiveTest() {
        return new Object[][]{{1.94, new Tetrahedron(new Point(-2, 0, -1), new Point(0, -3, -1), new Point(1.6, 0.23, -1), new Point(-0.13, -0.92, 1.94))},
                {0.65, new Tetrahedron(new Point(3, -1, 0), new Point(3, 1, 4), new Point(3, 3.46, 0.27), new Point(6.65, 1.16, 1.42))},
                {0.94, new Tetrahedron(new Point(-1, 2, 3), new Point(2, 2, 1), new Point(2.23, 2, 4.6), new Point(1.08, -0.94, 2.87))},
//                {1.2, new Tetrahedron(new Point(-1, 3, 3), new Point(-4, 3, 1), new Point(4.2, 3, 4.6), new Point(-3.1, 6, 2.9))},
                {0, new Tetrahedron(new Point(-2, 0, 1), new Point(3, 1, 4), new Point(-2.2, 1, 6.83), new Point(-0.85, 5.4, 3.11))}};
    }

    @Test(dataProvider = "calculateSmallHeightPositiveTest")
    public void calculateSmallHeightPositiveTest(final double expectedHeight, Tetrahedron tetrahedron) {
        double height = calculator.calculateHeightOfSmallPyramid(tetrahedron);
        Assert.assertEquals(height, expectedHeight, DELTA);
    }

    @DataProvider(name = "calculateVolumeRatioPositiveTest")
    public Object[][] dataForCalculateVolumeRatioPositiveTest() {
        return new Object[][]{{3.3, new Tetrahedron(new Point(-2, 0, -1), new Point(0, -3, -1), new Point(1.6, 0.23, -1), new Point(-0.13, -0.92, 1.94))},
                {14, new Tetrahedron(new Point(3, -1, 0), new Point(3, 1, 4), new Point(3, 3.46, 0.27), new Point(6.65, 1.16, 1.42))},
                {7.52, new Tetrahedron(new Point(-1, 2, 3), new Point(2, 2, 1), new Point(2.23, 2, 4.6), new Point(1.08, -0.94, 2.87))},
//                {1.2, new Tetrahedron(new Point(-1, 3, 3), new Point(-4, 3, 1), new Point(4.2, 3, 4.6), new Point(-3.1, 6, 2.9))},
//                {0, new Tetrahedron(new Point(-2, 0, 1), new Point(3, 1, 4), new Point(-2.2, 1, 6.83), new Point(-0.85, 5.4, 3.11))}};
        };
    }

    @Test(dataProvider = "calculateVolumeRatioPositiveTest")
    public void calculateVolumeRatioPositiveTest(final double expectedRatio, Tetrahedron tetrahedron) {
        double ratio = calculator.volumeRatio(tetrahedron);
        Assert.assertEquals(ratio, expectedRatio, DELTA);
    }


}
