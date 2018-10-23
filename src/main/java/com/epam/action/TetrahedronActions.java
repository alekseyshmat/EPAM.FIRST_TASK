package com.epam.action;

import com.epam.entity.Point;
import com.epam.entity.Tetrahedron;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetrahedronActions {
    private static final double DELTA = 0.01;
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public TetrahedronActions() {
    }

    public boolean isTetrahedron(Tetrahedron tetrahedron) {
        logger.debug(tetrahedron.getSideAB());
        logger.debug(tetrahedron.getSideAC());
        logger.debug(tetrahedron.getSideBC());
        logger.debug(tetrahedron.getSideDB());
        logger.debug(tetrahedron.getSideDA());
        logger.debug(tetrahedron.getSideDC());
        if (tetrahedron.getSideAB() - tetrahedron.getSideAC() < DELTA
                && tetrahedron.getSideAC() - tetrahedron.getSideBC() < DELTA
                && tetrahedron.getSideDA() - tetrahedron.getSideDB() < DELTA
                && tetrahedron.getSideDB() - tetrahedron.getSideDC() < DELTA
                && tetrahedron.getSideAB() - tetrahedron.getSideDA() < DELTA) {
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
}
