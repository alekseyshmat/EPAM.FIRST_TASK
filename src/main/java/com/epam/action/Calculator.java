package com.epam.action;

import com.epam.entity.TetrahedronPoint;
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

    public double calculateSide(TetrahedronPoint firstTetrahedronPoint, TetrahedronPoint secondTetrahedronPoint) {
        double side = Math.sqrt(Math.pow((firstTetrahedronPoint.getX() - secondTetrahedronPoint.getX()), NUMBER_TWO) +
                Math.pow((firstTetrahedronPoint.getY() - secondTetrahedronPoint.getY()), NUMBER_TWO) +
                Math.pow((firstTetrahedronPoint.getZ() - secondTetrahedronPoint.getZ()), NUMBER_TWO));
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
        double pointAcoordinateX = tetrahedron.getTetrahedronPointA().getX();
        double pointAcoordinateY = tetrahedron.getTetrahedronPointA().getY();
        double pointAcoordinateZ = tetrahedron.getTetrahedronPointA().getZ();

        double pointBcoordinateX = tetrahedron.getTetrahedronPointB().getX();
        double pointBcoordinateY = tetrahedron.getTetrahedronPointB().getY();
        double pointBcoordinateZ = tetrahedron.getTetrahedronPointB().getZ();

        double pointCcoordinateX = tetrahedron.getTetrahedronPointC().getX();
        double pointCcoordinateY = tetrahedron.getTetrahedronPointC().getY();
        double pointCcoordinateZ = tetrahedron.getTetrahedronPointC().getZ();

        double pointDcoordinateX = tetrahedron.getTetrahedronPointD().getX();
        double pointDcoordinateY = tetrahedron.getTetrahedronPointD().getY();
        double pointDcoordinateZ = tetrahedron.getTetrahedronPointD().getZ();

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
