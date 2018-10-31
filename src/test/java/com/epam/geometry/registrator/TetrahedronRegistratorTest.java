package com.epam.geometry.registrator;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronRegistratorTest {

    private TetrahedronsRegistrator tetrahedronsRegistrator;
    private Calculator calculator;
    private static final Tetrahedron FIRST_TETRAHEDRON = new Tetrahedron(
            new Point(-1, 2, 3),
            new Point(2, 2, 1),
            new Point(2.23, 2, 4.6),
            new Point(1.08, -0.94, 2.87)
    );

    @BeforeClass
    public void setUp() {
        tetrahedronsRegistrator = new TetrahedronsRegistrator();
        FIRST_TETRAHEDRON.addObserver(tetrahedronsRegistrator);
        calculator = new Calculator();
    }

    @Test
    public void handleEventIdPositiveTest() {
        long actualId = FIRST_TETRAHEDRON.getId();
        long expectedId = tetrahedronsRegistrator.getId();

        Assert.assertEquals(actualId, expectedId);
    }

    @Test
    public void handleEventAreaPositiveTest() {
        double actualArea = calculator.calculateArea(FIRST_TETRAHEDRON);
        double expectedArea = tetrahedronsRegistrator.getArea();

        Assert.assertEquals(actualArea, expectedArea);
    }

    @Test
    public void handleEventVolumePositiveTest() {
        double actualVolume = calculator.calculateVolume(FIRST_TETRAHEDRON);
        double expectedVolume = tetrahedronsRegistrator.getVolume();

        Assert.assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void handleEventVolumeRatioPositiveTest() {
        double actualVolume = calculator.calculateVolumeRatio(FIRST_TETRAHEDRON);
        double expectedVolume = tetrahedronsRegistrator.getVolumeRatio();

        Assert.assertEquals(actualVolume, expectedVolume);
    }
}
