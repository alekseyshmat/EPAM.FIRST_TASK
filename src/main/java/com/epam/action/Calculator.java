package com.epam.action;

import com.epam.entity.Point;
import com.epam.entity.Tetrahedron;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Calculator {

    private static final double NUMBER_TWO = 2;
    private static final double NUMBER_THREE = 3;
    private static final int NUMBER_TWELVE = 12;

    private static final Logger logger = LogManager.getLogger();

    public Calculator() {
    }

    public double calculateSide(Point firstPoint, Point secondPoint) {
        double side = Math.sqrt(Math.pow((firstPoint.getX() - secondPoint.getX()), NUMBER_TWO) +
                Math.pow((firstPoint.getY() - secondPoint.getY()), NUMBER_TWO) +
                Math.pow((firstPoint.getZ() - secondPoint.getZ()), NUMBER_TWO));
        logger.info("Tetrahedron's side is " + side);
        return side;
    }

    public double calculateArea(Tetrahedron tetrahedron) {
        double edge = tetrahedron.getSideAB();
        double square = Math.pow(edge, NUMBER_TWO) * Math.sqrt(NUMBER_THREE);
        logger.info("Tetrahedron's square is " + square);
        return square;
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double edge = tetrahedron.getSideAB();
        double volume = Math.sqrt(NUMBER_THREE) / NUMBER_TWELVE * Math.pow(edge, NUMBER_THREE);
        logger.info("Tetrahedron's volume is " + volume);
        return volume;
    }

    public double calculateHeight(Tetrahedron tetrahedron) {
        double height = Math.sqrt(NUMBER_TWO / NUMBER_THREE) * tetrahedron.getSideAB();
        logger.info("Tetrahedron's volume is " + height);
        return height;
    }


}
