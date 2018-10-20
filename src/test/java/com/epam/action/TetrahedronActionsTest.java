package com.epam.action;

import com.epam.entity.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TetrahedronActionsTest {
    private static final double DELTA = 0.01;
    private TetrahedronActions tetrahedronActions;
    private Point firstPoint, secondPoint;

    @BeforeClass
    public void setUp() {
        tetrahedronActions = new TetrahedronActions();
    }

    @DataProvider(name = "createSidePositiveTest")
    public Object[][] dataForCreateSidePositiveTest() {
        return new Object[][]{{new Point(0, 5, 0), new Point(0, 10, 0), 5},
                {new Point(2, -4, 7), new Point(-3, -1, -2), 10.72},
                {new Point(4, 5, 0), new Point(-1, 0, 6), 9.27},
                {new Point(0, 0, 0), new Point(0, 0, 0), 0}};
    }

    @Test(dataProvider = "createSidePositiveTest")
    public void createSidePositiveTest(Point firstPoint, Point secondPoint, final double expectedSide) {
        double actual = tetrahedronActions.createSide(firstPoint, secondPoint);
        Assert.assertEquals(expectedSide, actual, DELTA);
    }

}
