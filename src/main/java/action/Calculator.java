package action;

import entity.Point;
import entity.Tetrahedron;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Calculator {

    private static final double NUMBER_TWO = 2;
    private static final double NUMBER_THREE = 3;
    private static final int NUMBER_TWELVE = 12;

    private static final Logger logger = LogManager.getLogger(Calculator.class.getName());

    public double calculateArea(Tetrahedron tetrahedron) {
        double square = Math.pow(tetrahedron.getEdge(), NUMBER_TWO) * Math.sqrt(NUMBER_THREE);
        logger.info("Tetrahedron's square is " + square);
        return square;
    }

    public double calculateVolume(Tetrahedron tetrahedron) {
        double volume = Math.sqrt(NUMBER_THREE) / NUMBER_TWELVE * Math.pow(tetrahedron.getEdge(), NUMBER_THREE);
        logger.info("Tetrahedron's volume is " + volume);
        return volume;
    }

    public double calculateEdge(Tetrahedron tetrahedron) {
        return Math.sqrt(Math.pow((tetrahedron.getPointA().getX() - tetrahedron.getPointB().getX()), NUMBER_TWO) +
                Math.pow((tetrahedron.getPointA().getY() - tetrahedron.getPointB().getY()), NUMBER_TWO) +
                Math.pow((tetrahedron.getPointA().getZ() - tetrahedron.getPointB().getZ()), NUMBER_TWO));
    }

    public double calculateHeight(Tetrahedron tetrahedron) {
        return Math.sqrt(NUMBER_TWO / NUMBER_THREE) * tetrahedron.getEdge();
    }

    public double calculateEdgeOfSection(Tetrahedron tetrahedron) {
        double edgeOfSection = Math.sqrt(Math.pow((tetrahedron.getPointC().getX() - tetrahedron.getPointD().getX()), NUMBER_TWO) +
                Math.pow((tetrahedron.getPointC().getY() - tetrahedron.getPointD().getY()), NUMBER_TWO) +
                Math.pow((tetrahedron.getPointC().getZ() - tetrahedron.getPointD().getZ()), NUMBER_TWO));
//        tetrahedron.setEdgeOfSection(edgeOfSection);
        return edgeOfSection;
    }

    public double calculateHeightOfSmallTetrahedron(Tetrahedron tetrahedron) {
        return Math.sqrt(NUMBER_TWO / NUMBER_THREE) * tetrahedron.getEdgeOfSection();
    }

}
