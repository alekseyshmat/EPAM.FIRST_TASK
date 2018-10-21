package com.epam.action;

import com.epam.entity.Point;
import com.epam.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronActions {
    private static final double NUMBER_TWO = 2;

    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public TetrahedronActions() {
    }


    public boolean isTetrahedron(Tetrahedron tetrahedron) {
        if (tetrahedron.getSideAB() - tetrahedron.getSideAC() == 0
                && tetrahedron.getSideAC() - tetrahedron.getSideBC() == 0
                && tetrahedron.getSideDA() - tetrahedron.getSideDB() == 0
                && tetrahedron.getSideDB() - tetrahedron.getSideDC() == 0
                && tetrahedron.getSideAB() - tetrahedron.getSideDA() == 0) {
            logger.info("This is a tetrahedron");
            return true;
        }
        logger.info("This is not a tetrahedron");
        return false;
    }

    public boolean isBaseBelongsToTheXOY(Tetrahedron tetrahedron) {
        if (tetrahedron.getPointA().getX() > 0
                && tetrahedron.getPointA().getY() > 0
                && tetrahedron.getPointB().getY() > 0
                && tetrahedron.getPointB().getY() > 0
                && tetrahedron.getPointC().getX() > 0
                && tetrahedron.getPointC().getY() > 0) {
            logger.info("Base ABC belongs to the plane XOY");
            return true;
        }
        logger.info("Base ABC does not belong to the plane XOY");
        return false;
    }


    public double heigt1(Tetrahedron tetrahedron) {
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

        if (pointAcoordinateX == pointBcoordinateX && pointBcoordinateX == pointCcoordinateX) {
//            if (pointDcoordinateX > 0)
        }
        double height =0;
        return height;
    }


}
