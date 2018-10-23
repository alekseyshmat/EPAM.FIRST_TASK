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
        double edge = tetrahedron.getSideAB();
        double height = Math.sqrt(NUMBER_TWO / NUMBER_THREE) * edge;
        logger.info("Tetrahedron's height is " + height);
        return height;
    }

    public double sideOfSection(Tetrahedron tetrahedron) {
        double smallSide = 2 * (tetrahedron.getSideAB() - calculateHeightOfSmallPyramid(tetrahedron)) / Math.sqrt(NUMBER_THREE);
        logger.info("Small side is " + smallSide);
        return smallSide;
    }

    public double calculateHeightOfSmallPyramid(Tetrahedron tetrahedron) {
        double pointAcoordinateX = tetrahedron.getPointA().getX();
        double pointAcoordinateY = tetrahedron.getPointA().getY();
        double pointAcoordinateZ = tetrahedron.getPointA().getZ();

        double pointBcoordinateX = tetrahedron.getPointB().getX();
        double pointBcoordinateY = tetrahedron.getPointB().getY();
        double pointBcoordinateZ = tetrahedron.getPointB().getZ();

        double pointCcoordinateX = tetrahedron.getPointC().getX();
        double pointCcoordinateY = tetrahedron.getPointC().getY();
        double pointCcoordinateZ = tetrahedron.getPointC().getZ();

        double pointDcoordinateX = tetrahedron.getPointD().getX();
        double pointDcoordinateY = tetrahedron.getPointD().getY();
        double pointDcoordinateZ = tetrahedron.getPointD().getZ();

        double smallHeight = 0;
        double height = calculateHeight(tetrahedron);

        if (pointAcoordinateZ == pointBcoordinateZ && pointAcoordinateZ == pointCcoordinateZ && pointDcoordinateZ != 0) {
            smallHeight = height - Math.abs(pointAcoordinateZ);
            logger.info("Dissected by the plane Z");
        } else if (pointAcoordinateX == pointBcoordinateX && pointBcoordinateX == pointCcoordinateX && pointDcoordinateX != 0) {
            smallHeight = height - Math.abs(pointAcoordinateX);
            logger.info("Dissected by the plane X");
        } else if (pointAcoordinateY == pointBcoordinateY && pointBcoordinateY == pointCcoordinateY && pointDcoordinateY != 0) {
            smallHeight = height - Math.abs(pointAcoordinateY);
            logger.info("Dissected by the plane Y");
        } else {
            logger.info("This tetrahedron is not dissected therefore height of dissected tetrahedron is 0 ");
            return 0;
        }
        logger.info("Height of dissected tetrahedron is " + smallHeight);
        return smallHeight;
    }

    public double volumeRatio(Tetrahedron tetrahedron) {
        double heightOfTruncatedPyramid = calculateHeight(tetrahedron) - calculateHeightOfSmallPyramid(tetrahedron);
        double heightOfSmallPyramid = calculateHeightOfSmallPyramid(tetrahedron);
        double squareOfTruncatedPyramid = Math.pow(tetrahedron.getSideAB(), 2) * Math.sqrt(NUMBER_THREE) / 4;
        double squareOfSmallPyramid = Math.pow(sideOfSection(tetrahedron), 2) * Math.sqrt(NUMBER_THREE) / 4;


        double ratio = heightOfTruncatedPyramid * (squareOfTruncatedPyramid + Math.sqrt(squareOfTruncatedPyramid * squareOfSmallPyramid) + squareOfSmallPyramid) /
                (heightOfSmallPyramid * squareOfSmallPyramid);

        logger.info("The ratio of the truncated pyramid to the small " + ratio);
        return ratio;
    }


}
