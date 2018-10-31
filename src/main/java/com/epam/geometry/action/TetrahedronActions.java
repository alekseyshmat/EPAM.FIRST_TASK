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

        double sideAB = calculator.calculateSideOfTetrahedron(pointA, pointB);
        double sideAC = calculator.calculateSideOfTetrahedron(pointA, pointC);
        double sideBC = calculator.calculateSideOfTetrahedron(pointB, pointC);
        double sideDB = calculator.calculateSideOfTetrahedron(pointD, pointB);
        double sideDA = calculator.calculateSideOfTetrahedron(pointD, pointA);
        double sideDC = calculator.calculateSideOfTetrahedron(pointD, pointC);

        if (sideAB - sideAC < DELTA
                && sideAC - sideBC < DELTA
                && sideDA - sideDB < DELTA
                && sideDB - sideDC < DELTA
                && sideAB - sideDA < DELTA) {
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
