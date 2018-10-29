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

        if (calculator.calculateSide(pointA, pointB) - calculator.calculateSide(pointA, pointC) < DELTA
                && calculator.calculateSide(pointA, pointC) - calculator.calculateSide(pointB, pointC) < DELTA
                && calculator.calculateSide(pointD, pointA) - calculator.calculateSide(pointD, pointB) < DELTA
                && calculator.calculateSide(pointD, pointB) - calculator.calculateSide(pointD, pointC) < DELTA
                && calculator.calculateSide(pointA, pointB) - calculator.calculateSide(pointD, pointA) < DELTA) {
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

    public static Tetrahedron changePointsValues(Tetrahedron tetrahedron) {
        double sideAB = tetrahedron.getSideAB();
        double sideBC = tetrahedron.getSideBC();
        double sideAC = tetrahedron.getSideAC();

        if (sideAB == sideBC && sideAB != sideAC) {
            tetrahedron.setSideAC(sideAB);
        } else if (sideAB == sideAC && sideAB != sideBC) {
            tetrahedron.setSideBC(sideAB);
        } else if (sideBC == sideAC && sideBC != sideAB) {
            tetrahedron.setSideAB(sideBC);
        }

        return tetrahedron;
    }
}
