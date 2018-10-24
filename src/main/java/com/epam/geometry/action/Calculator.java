package com.epam.geometry.action;

import com.epam.geometry.entity.TetrahedronPoint;
import com.epam.geometry.entity.Tetrahedron;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Calculator {

    private static final double NUMBER_TWO = 2;
    private static final double NUMBER_THREE = 3;
    private static final int NUMBER_TWELVE = 12;
    private static final Logger logger = LogManager.getLogger();

    public Calculator() {
    }

    public double calculateSide(TetrahedronPoint firstTetrahedronPoint, TetrahedronPoint secondTetrahedronPoint) {
        double side = Math.sqrt(Math.pow((firstTetrahedronPoint.getX() - secondTetrahedronPoint.getX()), NUMBER_TWO) +
                Math.pow((firstTetrahedronPoint.getY() - secondTetrahedronPoint.getY()), NUMBER_TWO) +
                Math.pow((firstTetrahedronPoint.getZ() - secondTetrahedronPoint.getZ()), NUMBER_TWO));
        logger.info("Tetrahedron's side is " + side);
        return side;
    }

    public double calculateArea(Tetrahedron tetrahedron) {
        TetrahedronPoint pointA = tetrahedron.getTetrahedronPointA();
        TetrahedronPoint pointB = tetrahedron.getTetrahedronPointB();
        double edge = calculateSide(pointA, pointB);
        double square = Math.pow(edge, NUMBER_TWO) * Math.sqrt(NUMBER_THREE);
        logger.info("Tetrahedron's square is " + square);
        return square;
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        TetrahedronPoint pointA = tetrahedron.getTetrahedronPointA();
        TetrahedronPoint pointB = tetrahedron.getTetrahedronPointB();
        double edge = calculateSide(pointA, pointB);
        double volume = Math.sqrt(NUMBER_THREE) / NUMBER_TWELVE * Math.pow(edge, NUMBER_THREE);
        logger.info("Tetrahedron's volume is " + volume);
        return volume;
    }

    public double calculateHeight(Tetrahedron tetrahedron) {
        TetrahedronPoint pointA = tetrahedron.getTetrahedronPointA();
        TetrahedronPoint pointB = tetrahedron.getTetrahedronPointB();
        double edge = calculateSide(pointA, pointB);
        double height = Math.sqrt(NUMBER_TWO / NUMBER_THREE) * edge;
        logger.info("Tetrahedron's height is " + height);
        return height;
    }

    public double calculateHeightOfSmallPyramid(Tetrahedron tetrahedron) {
        TetrahedronPoint pointA = tetrahedron.getTetrahedronPointA();
        TetrahedronPoint pointB = tetrahedron.getTetrahedronPointB();
        TetrahedronPoint pointC = tetrahedron.getTetrahedronPointC();
        TetrahedronPoint pointD = tetrahedron.getTetrahedronPointD();

        double smallHeight;
        double height = calculateHeight(tetrahedron);

        if (pointA.getZ() == pointB.getZ() && pointA.getZ() == pointC.getZ() && pointD.getZ() != 0) {
            smallHeight = height - Math.abs(pointA.getZ());
            logger.info("Dissected by the plane Z");
        } else if (pointA.getX() == pointB.getX() && pointB.getX() == pointC.getX() && pointD.getX() != 0) {
            smallHeight = height - Math.abs(pointA.getX());
            logger.info("Dissected by the plane X");
        } else if (pointA.getY() == pointB.getY() && pointB.getY() == pointC.getY() && pointD.getY() != 0) {
            smallHeight = Math.abs(height - Math.abs(pointA.getY()));
            logger.info("Dissected by the plane Y");
        } else {
            logger.info("This tetrahedron is not dissected therefore height of dissected tetrahedron is 0 ");
            return 0;
        }
        logger.info("Height of dissected tetrahedron is " + smallHeight);
        return smallHeight;
    }

    private double sideOfSection(Tetrahedron tetrahedron) {
        TetrahedronPoint pointA = tetrahedron.getTetrahedronPointA();
        TetrahedronPoint pointB = tetrahedron.getTetrahedronPointB();
        double edge = calculateSide(pointA, pointB);
        double smallSide = 2 * (edge - calculateHeightOfSmallPyramid(tetrahedron)) / Math.sqrt(NUMBER_THREE);
        logger.info("Small side is " + smallSide);
        return smallSide;
    }

    public double volumeRatio(Tetrahedron tetrahedron) {
        TetrahedronPoint pointA = tetrahedron.getTetrahedronPointA();
        TetrahedronPoint pointB = tetrahedron.getTetrahedronPointB();

        double heightOfSmallPyramid = calculateHeightOfSmallPyramid(tetrahedron);
        if (heightOfSmallPyramid == 0) {
            logger.info("Height of small pyramid is 0, therefore volume ratio also is 0");
            return 0;
        }
        double heightOfTruncatedPyramid = calculateHeight(tetrahedron) - calculateHeightOfSmallPyramid(tetrahedron);
        double edge = calculateSide(pointA, pointB);
        double squareOfTruncatedPyramid = Math.pow(edge, 2) * Math.sqrt(NUMBER_THREE) / 4;
        double squareOfSmallPyramid = Math.pow(sideOfSection(tetrahedron), 2) * Math.sqrt(NUMBER_THREE) / 4;

        double ratio = heightOfTruncatedPyramid * (squareOfTruncatedPyramid + Math.sqrt(squareOfTruncatedPyramid * squareOfSmallPyramid) + squareOfSmallPyramid) /
                (heightOfSmallPyramid * squareOfSmallPyramid);
        logger.info("The ratio of the truncated pyramid to the small " + ratio);
        return ratio;
    }
}
