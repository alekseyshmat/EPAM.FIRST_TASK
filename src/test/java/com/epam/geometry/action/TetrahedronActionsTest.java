package com.epam.geometry.action;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TetrahedronActionsTest {
    private TetrahedronActions tetrahedronActions;

    @BeforeClass
    public void setUp() {
        tetrahedronActions = new TetrahedronActions();
    }

    @DataProvider(name = "isTetrahedronPositiveTest")
    public Object[][] dataForIsTetrahedronPositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron(        //input object
                                new Point(-2, 0, -1),
                                new Point(0, -3, -1),
                                new Point(1.6, 0.23, -1),
                                new Point(-0.13, -0.92, 1.94)
                        )
                },
                {
                        new Tetrahedron(new Point(3, -1, 0),
                                new Point(3, 1, 4),
                                new Point(3, 3.46, 0.27),
                                new Point(6.65, 1.16, 1.42)
                        )
                },
                {
                        new Tetrahedron(new Point(-1, 2, 3),
                                new Point(2, 2, 1),
                                new Point(2.23, 2, 4.6),
                                new Point(1.08, -0.94, 2.87)
                        )
                },
                {
                        new Tetrahedron(
                                new Point(1, 2, 3),
                                new Point(3, 2, 1),
                                new Point(0.27, 2, 0.27),
                                new Point(1.42, 4.31, 1.42)
                        )
                },
                {
                        new Tetrahedron(
                                new Point(-2, 0, 1),
                                new Point(3, 1, 4),
                                new Point(-2.2, 1, 6.83),
                                new Point(-0.85, 5.4, 3.11)
                        )
                }
        };
    }

    @DataProvider(name = "isBaseBelongsToTheXOYPositiveTest")
    public Object[][] dataForIsBaseBelongsToTheXOYPositiveTest() {
        return new Object[][]{
                {
                        new Tetrahedron(    //input object
                                new Point(1, 2, 3),
                                new Point(3, 2, 1),
                                new Point(0.27, 2, 0.27),
                                new Point(1.42, 4.31, 1.42)
                        )
                }
        };
    }

    @DataProvider(name = "isBaseBelongsToTheXOYNegativeTest")
    public Object[][] dataForIsBaseBelongsToTheXOYNegativeTest() {
        return new Object[][]{
                {
                        new Tetrahedron(        //input object
                                new Point(-2, 0, -1),
                                new Point(0, -3, -1),
                                new Point(1.6, 0.23, -1),
                                new Point(-0.13, -0.92, 1.94)
                        )
                }
        };
    }

    @Test(dataProvider = "isTetrahedronPositiveTest")
    public void isTetrahedronPositiveTest(Tetrahedron tetrahedron) {
        boolean actual = tetrahedronActions.isTetrahedron(tetrahedron);

        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "isBaseBelongsToTheXOYPositiveTest")
    public void isBaseBelongsToTheXOYPositiveTest(Tetrahedron tetrahedron) {
        boolean actual = tetrahedronActions.isBaseBelongsToTheXOY(tetrahedron);

        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "isBaseBelongsToTheXOYNegativeTest")
    public void isBaseBelongsToTheXOYNegativeTest(Tetrahedron tetrahedron) {
        boolean actual = tetrahedronActions.isBaseBelongsToTheXOY(tetrahedron);

        Assert.assertFalse(actual);
    }
}
