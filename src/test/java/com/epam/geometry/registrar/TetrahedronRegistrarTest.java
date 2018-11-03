package com.epam.geometry.registrar;

import com.epam.geometry.action.Calculator;
import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TetrahedronRegistrarTest {

    private TetrahedronsRegistrar tetrahedronsRegistrar;
    private Calculator calculator;
    private static final Tetrahedron FIRST_TETRAHEDRON = new Tetrahedron(
            new Point(-1, 2, 3),
            new Point(2, 2, 1),
            new Point(2.23, 2, 4.6),
            new Point(1.08, -0.94, 2.87)
    );

    @BeforeClass
    public void setUp() {
        tetrahedronsRegistrar = new TetrahedronsRegistrar();
        FIRST_TETRAHEDRON.addObserver(tetrahedronsRegistrar);
        calculator = new Calculator();
    }

    @Test
    public void handleEventIdPositiveTest() {
        long actualId = FIRST_TETRAHEDRON.getId();
        long expectedId = tetrahedronsRegistrar.getId();

        Assert.assertEquals(actualId, expectedId);
    }

    @Test
    public void handleEventAreaPositiveTest() {
        double actualArea = calculator.calculateArea(FIRST_TETRAHEDRON);
        double expectedArea = tetrahedronsRegistrar.getArea();

        Assert.assertEquals(actualArea, expectedArea);
    }

    @Test
    public void handleEventVolumePositiveTest() {
        double actualVolume = calculator.calculateVolume(FIRST_TETRAHEDRON);
        double expectedVolume = tetrahedronsRegistrar.getVolume();

        Assert.assertEquals(actualVolume, expectedVolume);
    }

    @Test
    public void handleEventVolumeRatioPositiveTest() {
        double actualVolume = calculator.calculateVolumeRatio(FIRST_TETRAHEDRON);
        double expectedVolume = tetrahedronsRegistrar.getVolumeRatio();

        Assert.assertEquals(actualVolume, expectedVolume);
    }
}
