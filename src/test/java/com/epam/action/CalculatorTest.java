package com.epam.action;

import com.epam.entity.Point;
import com.epam.entity.Tetrahedron;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private final Tetrahedron TETRAHEDRON = new Tetrahedron(new Point(2, 0, 0), new Point(0, 2, 0), new Point(1, 0, 1), new Point(0, 1, 1));
    private final Calculator CALCULATOR = new Calculator();

    private final double DELTA = 0.01;

    @Test
    public void shouldReturnTrueSquare() {
        double square = CALCULATOR.calculateArea(TETRAHEDRON);
        Assert.assertEquals(13.86, square, DELTA);
    }

    @Test
    public void shouldReturnTrueVolume() {
        double volume = CALCULATOR.calculateVolume(TETRAHEDRON);
        Assert.assertEquals(3.26, volume, DELTA);
    }

    @Test
    public void shouldReturnTrueHeight() {
        double height = CALCULATOR.calculateHeight(TETRAHEDRON);
        Assert.assertEquals(2.3, height, DELTA);
    }

}
