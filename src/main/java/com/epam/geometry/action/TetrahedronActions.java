package com.epam.geometry.action;

import com.epam.geometry.entity.Point;
import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronActions {
    private static final double DELTA = 0.01;
    private Calculator calculator;
    private static final Logger LOGGER = LogManager.getLogger();

    public TetrahedronActions() {
        calculator = new Calculator();
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron) {
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        Point pointC = tetrahedron.getPointC();
        Point pointD = tetrahedron.getPointD();

        if (calculator.calculateSideOfTetrahedron(pointA, pointB) - calculator.calculateSideOfTetrahedron(pointA, pointC) < DELTA
                && calculator.calculateSideOfTetrahedron(pointA, pointC) - calculator.calculateSideOfTetrahedron(pointB, pointC) < DELTA
                && calculator.calculateSideOfTetrahedron(pointD, pointA) - calculator.calculateSideOfTetrahedron(pointD, pointB) < DELTA
                && calculator.calculateSideOfTetrahedron(pointD, pointB) - calculator.calculateSideOfTetrahedron(pointD, pointC) < DELTA
                && calculator.calculateSideOfTetrahedron(pointA, pointB) - calculator.calculateSideOfTetrahedron(pointD, pointA) < DELTA) {
            LOGGER.info("This is a tetrahedron");
            return true;
        }
        LOGGER.info("This is not a tetrahedron");
        return false;
    }

    public boolean isBaseBelongsToTheXOY(Tetrahedron tetrahedron) {
        Point pointA = tetrahedron.getPointA();
        Point pointB = tetrahedron.getPointB();
        Point pointC = tetrahedron.getPointC();

        if (pointA.getX() > 0
                && pointA.getY() > 0
                && pointB.getY() > 0
                && pointB.getY() > 0
                && pointC.getX() > 0
                && pointC.getY() > 0) {
            LOGGER.info("Base ABC belongs to the plane XOY");
            return true;
        }
        LOGGER.info("Base ABC does not belong to the plane XOY");
        return false;
    }

}
